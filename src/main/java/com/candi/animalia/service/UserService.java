package com.candi.animalia.service;
import com.candi.animalia.dto.user.CreateUserRequest;
import com.candi.animalia.dto.user.EditUserDTO;
import com.candi.animalia.error.ActivationExpiredException;
import com.candi.animalia.model.Publicacion;
import com.candi.animalia.model.Role;
import com.candi.animalia.model.Usuario;
import com.candi.animalia.repository.UsuarioRepository;
import com.candi.animalia.security.jwt.refresh.RefreshTokenRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final SendGridMailSender mailSender;
    private final RefreshTokenRepository refreshTokenRepository;
    @Value("${activation.duration}")
    private int activationDuration;

    public Usuario createUser(CreateUserRequest createUserRequest) {
        Usuario user = Usuario.builder()
                .username(createUserRequest.username())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .email(createUserRequest.email())
                .registrationDate(LocalDate.now())
                .roles(Set.of(Role.USER))
                .activationToken(generatedVerificationCode())
                .build();
        try {
            String text = "Su codigo de activacion es " + user.getActivationToken();
            mailSender.sendMail(createUserRequest.email(), "Activación de cuenta", text);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al enviar el email de activación");
        }

        return usuarioRepository.save(user);
    }

    public String generatedVerificationCode(){
        return String.format("%06d", new Random().nextInt(99999));
    }


    public Usuario activateAccount(String token) {

        return usuarioRepository.findByActivationToken(token)
                .filter(user -> ChronoUnit.MINUTES.between(Instant.now(), user.getCreatedAt()) - activationDuration < 0)
                .map(user -> {
                    user.setEnabled(true);
                    user.setActivationToken(null);
                    return usuarioRepository.save(user);
                })
                .orElseThrow(() -> new ActivationExpiredException("El código de activación no existe o ha caducado"));
    }

    public Usuario createAdmin(CreateUserRequest createUserRequest) {
        Usuario user = Usuario.builder()
                .username(createUserRequest.username())
                .password(passwordEncoder.encode(createUserRequest.password()))
                .email(createUserRequest.email())
                .registrationDate(LocalDate.now())
                .roles(Set.of(Role.ADMIN))
                .activationToken(generatedVerificationCode())
                .build();
        try {
            String text = "Su código de activación es " + user.getActivationToken();
            mailSender.sendMail(createUserRequest.email(), "Activación de cuenta", text);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Error al enviar el email de activación");
        }

        return usuarioRepository.save(user);
    }

    public Page<Usuario> findAll(Pageable pageable) {
        Page<Usuario> result = usuarioRepository.findAllUsuario(pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay usuario con esos criterios de búsqueda");
        return result;
    }

    public Usuario findById(UUID id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay usuario con esa id " + id));

    }

    public Usuario editUser(EditUserDTO userDTO, Usuario usuario) {
        usuario.setEmail(userDTO.email());
        usuario.setPassword(passwordEncoder.encode(userDTO.password()));

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void deleteUsuarioCuenta(Usuario usuario) {
        if (usuario != null) {
            refreshTokenRepository.deleteByUser(usuario);
            usuarioRepository.delete(usuario);
        }
    }

    public void deleteUserByAdmin(UUID usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado el usuario con ID " + usuarioId));
        refreshTokenRepository.deleteByUser(usuario);
        usuarioRepository.delete(usuario);
    }

}
