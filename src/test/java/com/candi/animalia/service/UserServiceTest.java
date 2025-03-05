package com.candi.animalia.service;

import com.candi.animalia.dto.user.CreateUserRequest;
import com.candi.animalia.model.Role;
import com.candi.animalia.model.Usuario;
import com.candi.animalia.repository.UsuarioRepository;
import com.candi.animalia.security.jwt.refresh.RefreshTokenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class UserServiceTest {


    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private SendGridMailSender mailSender;

    @Mock
    private RefreshTokenRepository refreshTokenRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        userService = new UserService(usuarioRepository, passwordEncoder, mailSender, refreshTokenRepository);
    }

    @Test
    void createUser_ShouldCreateUser_WhenValidRequest() throws IOException {

        CreateUserRequest request = new CreateUserRequest("username",  "email@example.com", "password123", "password123");
        String encodedPassword = "encodedPassword";

        when(passwordEncoder.encode("password123")).thenReturn(encodedPassword);
        when(usuarioRepository.save(any(Usuario.class))).thenAnswer(invocation -> invocation.getArgument(0));
        doNothing().when(mailSender).sendMail(anyString(), anyString(), anyString());

        Usuario createdUser = userService.createUser(request);

        assertNotNull(createdUser);
        assertEquals("username", createdUser.getUsername());
        assertEquals(encodedPassword, createdUser.getPassword());
        assertEquals("email@example.com", createdUser.getEmail());
        assertEquals(LocalDate.now(), createdUser.getRegistrationDate());
        assertEquals(Set.of(Role.USER), createdUser.getRoles());
        assertNotNull(createdUser.getActivationToken());
        assertTrue(createdUser.getActivationToken().matches("\\d{6}"));

        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> subjectCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);
        verify(mailSender).sendMail(emailCaptor.capture(), subjectCaptor.capture(), messageCaptor.capture());
        assertEquals("email@example.com", emailCaptor.getValue());
        assertEquals("Activación de cuenta", subjectCaptor.getValue());
        assertTrue(messageCaptor.getValue().contains(createdUser.getActivationToken()));
    }

    @Test
    void createUser_ShouldThrowException_WhenEmailSendingFails() throws IOException {
        CreateUserRequest request = new CreateUserRequest("username", "email@example.com","password123", "password123");
        when(passwordEncoder.encode("password123")).thenReturn("encodedPassword");

        doThrow(new IOException("Email sending failed")).when(mailSender).sendMail(anyString(), anyString(), anyString());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            userService.createUser(request);
        });

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatusCode());
        assertEquals("Error al enviar el email de activación", exception.getReason());
        verify(usuarioRepository, never()).save(any(Usuario.class)); // No debería guardarse el usuario
    }
}
