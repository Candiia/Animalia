--raza
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440000', 'Podenco');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440001', 'Labrador Retriever');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440002', 'Siamés');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440003', 'Persa');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440004', 'Bengalí');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440005', 'Beagle');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440006', 'Husky Siberiano');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440007', 'Rottweiler');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440008', 'Dálmata');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440009', 'Golden Retriever');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440010', 'Bulldog Francés');

--usuario
INSERT INTO usuario (id, email, username, password, registration_date, enabled, activation_token, created_at)
VALUES ('550e8400-e29b-41d4-a716-446655440000', 'admin@example.com', 'admin', '{noop}admin', '2025-02-05',  TRUE, '986541', NOW());
INSERT INTO usuario (id, email, username, password, registration_date, enabled, activation_token, created_at)
VALUES ('550e8400-e29b-41d4-a716-446655440001', 'user1@example.com', 'user1', '{noop}1234', '2025-02-01', TRUE, '023654', NOW());
INSERT INTO usuario (id, email, username, password, registration_date, enabled, activation_token, created_at)
VALUES ('550e8400-e29b-41d4-a716-446655440002', 'user2@example.com', 'user2', '{noop}9865432', '2025-02-02', TRUE, '654321', NOW());
INSERT INTO usuario (id, email, username, password, registration_date, enabled, activation_token, created_at)
VALUES ('550e8400-e29b-41d4-a716-446655440003', 'user3@example.com', 'user3', '{noop}789563', '2025-02-03', TRUE, '987654', NOW());
INSERT INTO usuario (id, email, username, password, registration_date, enabled, activation_token, created_at)
VALUES ('550e8400-e29b-41d4-a716-446655440004', 'user4@example.com', 'user4', '{noop}12345678', '2025-02-04', TRUE, '456123', NOW());

--userRoles
INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440000', 'ADMIN');
INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440001', 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440002', 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440003', 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440004', 'USER');

--especie
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440000', 'Canino', '2025-01-01');
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440001', 'Felino', '2025-01-01');
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440002', 'Aves', '2022-07-22');
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440003', 'Reptiles', '2025-01-11');
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440004', 'Anfibios', '2022-01-01');
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440005', 'Peces', '2023-01-01');
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440006', 'Invertebrados', '2024-06-22');
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440007', 'Equino', '2025-02-01');
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440008', 'Rumiantes', '2025-01-01');
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440009', 'Roedores', '2025-01-01');
INSERT INTO especie(id, nombre, fecha_registro) VALUES ('550e8400-e29b-41d4-a716-446655440010', 'Carnívoros', '2025-01-01');

--mascota
INSERT INTO mascota (id, nombre, fecha_nacimiento, biografia, avatar, raza_id, especie_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440100', 'Max', '2020-05-15', 'Un perro muy juguetón y amigable.', 'https://example.com/avatars/max.jpg', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440000', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO mascota (id, nombre, fecha_nacimiento, biografia, avatar, raza_id, especie_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440101', 'Luna', '2019-08-20', 'Gata persa tranquila y cariñosa.', 'https://example.com/avatars/luna.jpg', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO mascota (id, nombre, fecha_nacimiento, biografia, avatar, raza_id, especie_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440102', 'Rocky', '2021-01-10', 'Beagle aventurero y curioso.', 'https://example.com/avatars/rocky.jpg', '550e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440000', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO mascota (id, nombre, fecha_nacimiento, biografia, avatar, raza_id, especie_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440103', 'Nala', '2022-03-05', 'Bengalí activa y juguetona.', 'https://example.com/avatars/nala.jpg', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440004');
INSERT INTO mascota (id, nombre, fecha_nacimiento, biografia, avatar, raza_id, especie_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440104', 'Thor', '2018-07-21', 'Husky siberiano con mucha energía.', 'https://example.com/avatars/thor.jpg', '550e8400-e29b-41d4-a716-446655440006', '550e8400-e29b-41d4-a716-446655440000', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO mascota (id, nombre, fecha_nacimiento, biografia, avatar, raza_id, especie_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440105', 'Milo', '2023-01-15', 'Un pez dorado que adora nadar.', 'https://example.com/avatars/milo.jpg', '550e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440003');

--publicacion
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id)
VALUES ('550e8400-e29b-41d4-a716-446655440200', 'Image', 'Max disfrutando del parque en un día soleado.', '2025-02-20', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100');
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id)
VALUES ('550e8400-e29b-41d4-a716-446655440201', 'Image', 'Luna se escondió en una caja hoy, ¡es tan adorable!', '2025-02-21', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101');
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id)
VALUES ('550e8400-e29b-41d4-a716-446655440202', 'Image', 'Rocky participará en una carrera de perros este fin de semana.', '2025-02-22', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102');
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id)
VALUES ('550e8400-e29b-41d4-a716-446655440203', 'Image', 'Nala cazando una pelota en el jardín.', '2025-02-23', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103');
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id)
VALUES ('550e8400-e29b-41d4-a716-446655440204', 'Image', 'Thor ladrando a la nieve como si fuera la primera vez.', '2025-02-24', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440104');
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id)
VALUES ('550e8400-e29b-41d4-a716-446655440205', 'Image', 'Milo nadando en su nueva pecera decorada.', '2025-02-19', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440105');
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id)
VALUES ('550e8400-e29b-41d4-a716-446655440206', 'Image', 'Max irá a una sesión de entrenamiento mañana.', '2025-02-23', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100');
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id)
VALUES ('550e8400-e29b-41d4-a716-446655440207', 'Image', 'Luna durmiendo en el sofá, parece una reina.', '2025-02-18', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101');

--likes
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440200', '550e8400-e29b-41d4-a716-446655440002', '2025-02-20');
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440200', '550e8400-e29b-41d4-a716-446655440003', '2025-02-21');
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440200', '550e8400-e29b-41d4-a716-446655440004', '2025-02-22');
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440201', '550e8400-e29b-41d4-a716-446655440001', '2025-02-21');
INSERT INTO likes(publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440201', '550e8400-e29b-41d4-a716-446655440004', '2025-02-23');
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440202', '550e8400-e29b-41d4-a716-446655440001', '2025-02-22');
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440202', '550e8400-e29b-41d4-a716-446655440002', '2025-02-23');
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440203', '550e8400-e29b-41d4-a716-446655440003', '2025-02-23');
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440203', '550e8400-e29b-41d4-a716-446655440002', '2025-02-24');
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440204', '550e8400-e29b-41d4-a716-446655440001', '2025-02-24');
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440204', '550e8400-e29b-41d4-a716-446655440003', '2025-02-24');
INSERT INTO likes (publicacion_id, usuario_id, fecha_realizada)
VALUES ('550e8400-e29b-41d4-a716-446655440205', '550e8400-e29b-41d4-a716-446655440002', '2025-02-19');

--Comentarios
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440300', '¡Max se ve súper feliz en el parque!', '2025-02-20', '550e8400-e29b-41d4-a716-446655440200', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440301', 'Qué energía tiene Max, ¡increíble!', '2025-02-21', '550e8400-e29b-41d4-a716-446655440200', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440302', 'Max siempre robándose el show.', '2025-02-22', '550e8400-e29b-41d4-a716-446655440200', '550e8400-e29b-41d4-a716-446655440004');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440303', 'Luna en una caja, ¡qué ternura!', '2025-02-21', '550e8400-e29b-41d4-a716-446655440201', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440304', '¡Luna es la reina de las cajas!', '2025-02-22', '550e8400-e29b-41d4-a716-446655440201', '550e8400-e29b-41d4-a716-446655440004');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440305', '¿Cómo hace Luna para ser tan adorable?', '2025-02-23', '550e8400-e29b-41d4-a716-446655440201', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440306', '¡Suerte a Rocky en la carrera!', '2025-02-22', '550e8400-e29b-41d4-a716-446655440202', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440307', 'Rocky va a arrasar este fin de semana.', '2025-02-23', '550e8400-e29b-41d4-a716-446655440202', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440308', 'Rocky es todo un atleta, ¡increíble!', '2025-02-24', '550e8400-e29b-41d4-a716-446655440202', '550e8400-e29b-41d4-a716-446655440004');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440309', 'Nala cazando es lo más divertido.', '2025-02-23', '550e8400-e29b-41d4-a716-446655440203', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440310', '¡Qué ágil es Nala! Me encanta.', '2025-02-24', '550e8400-e29b-41d4-a716-446655440203', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440311', 'Nala es una cazadora nata.', '2025-02-24', '550e8400-e29b-41d4-a716-446655440203', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440312', 'Thor y la nieve, ¡qué combinación!', '2025-02-24', '550e8400-e29b-41d4-a716-446655440204', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440313', 'Thor parece un cachorro con la nieve.', '2025-02-24', '550e8400-e29b-41d4-a716-446655440204', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440314', 'Thor ladrando a la nieve es épico.', '2025-02-24', '550e8400-e29b-41d4-a716-446655440204', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440315', 'La pecera de Milo está genial.', '2025-02-19', '550e8400-e29b-41d4-a716-446655440205', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440316', 'Milo parece muy feliz nadando.', '2025-02-20', '550e8400-e29b-41d4-a716-446655440205', '550e8400-e29b-41d4-a716-446655440004');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440317', '¡Max va a aprender nuevos trucos!', '2025-02-23', '550e8400-e29b-41d4-a716-446655440206', '550e8400-e29b-41d4-a716-446655440003');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440318', 'Qué bien que Max entrene mañana.', '2025-02-24', '550e8400-e29b-41d4-a716-446655440206', '550e8400-e29b-41d4-a716-446655440002');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440319', 'Luna durmiendo es un amor.', '2025-02-18', '550e8400-e29b-41d4-a716-446655440207', '550e8400-e29b-41d4-a716-446655440001');
INSERT INTO comentario (id, comentario, fecha_realizada, publicacion_id, usuario_id)
VALUES ('550e8400-e29b-41d4-a716-446655440320', '¡Luna parece tan cómoda en el sofá!', '2025-02-19', '550e8400-e29b-41d4-a716-446655440207', '550e8400-e29b-41d4-a716-446655440004');