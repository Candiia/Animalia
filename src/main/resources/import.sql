--raza
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440000', 'Podenco');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440001', 'Labrador Retriever');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440002', 'Siames');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440003', 'Persa');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440004', 'Bengali');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440005', 'Beagle');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440006', 'Husky Siberiano');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440007', 'Rottweiler');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440008', 'Dalmata');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440009', 'Golden Retriever');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440010', 'Bulldog Frances');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440011', 'Chihuahua');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440012', 'Maine Coon');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440013', 'Doberman');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440014', 'Pastor Aleman');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440015', 'Appaloosa');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440016', 'Himalayo');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440017', 'Loro Eclectus');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440018', 'Conejo Rex');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440019', 'Persa Azul');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440020', 'Labradoodle');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440021', 'Abisinio');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440022', 'Husky Alaskano');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440023', 'Yorkshire Terrier');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440024', 'Periquito Australiano');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440025', 'Gran Danes');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440026', 'Arabian Horse');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440027', 'Manx');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440028', 'Cacatúa Ninfa');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440029', 'Pastor Belga');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440030', 'Conejo Cabeza de Leon');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440031', 'Burmes');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440032', 'Scottish Fold');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440033', 'Fox Terrier');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440034', 'Loro Amazonas');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440035', 'Pastor Australiano');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440036', 'Conejo Holandes');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440037', 'Sphynx');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440038', 'Ragdoll');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440039', 'Cavalier King Charles');
INSERT INTO raza(id, nombre) VALUES ('550e8400-e29b-41d4-a716-446655440040', 'Pavo Real');


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
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id)
VALUES
    ('550e8400-e29b-41d4-a716-446655440208', 'Image', 'Rocky aprendió a dar la pata hoy. ¡Estamos orgullosos!', '2025-02-25', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102'),
    ('550e8400-e29b-41d4-a716-446655440209', 'Image', 'Nala se trepó al sofá aunque no debería... pero mírenla.', '2025-02-26', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103'),
    ('550e8400-e29b-41d4-a716-446655440210', 'Image', 'Thor encontró un nuevo amigo en el parque hoy.', '2025-02-26', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440104'),
    ('550e8400-e29b-41d4-a716-446655440211', 'Image', 'Milo investigando su castillo de burbujas como un verdadero explorador.', '2025-02-27', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440105'),
    ('550e8400-e29b-41d4-a716-446655440212', 'Image', 'Max jugando con otros perros en la plaza.', '2025-02-27', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100'),
    ('550e8400-e29b-41d4-a716-446655440213', 'Image', 'Luna posando junto a la ventana como una modelo felina.', '2025-02-28', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101'),
    ('550e8400-e29b-41d4-a716-446655440214', 'Image', 'Rocky corriendo detrás de su pelota favorita.', '2025-02-28', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102'),
    ('550e8400-e29b-41d4-a716-446655440215', 'Image', 'Nala aprendió un nuevo truco: girar sobre sí misma.', '2025-03-01', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103'),
    ('550e8400-e29b-41d4-a716-446655440216', 'Image', 'Thor y Luna compartiendo un momento juntos, ¡qué dulzura!', '2025-03-01', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440104'),
    ('550e8400-e29b-41d4-a716-446655440217', 'Image', 'Milo se asustó con su reflejo, ¡pobrecito!', '2025-03-02', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440105');
-- Publicaciones Enero
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440300', 'Image', 'Max corriendo en la playa.', '2025-01-05', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440301', 'Image', 'Luna descubriendo una caja nueva.', '2025-01-08', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440302', 'Image', 'Rocky y su juguete favorito.', '2025-01-10', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440303', 'Image', 'Nala mirando por la ventana.', '2025-01-12', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440304', 'Image', 'Thor ladrando a su reflejo.', '2025-01-15', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440104');

-- Febrero
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440305', 'Image', 'Milo con su nueva pecera.', '2025-02-01', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440105'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440306', 'Image', 'Max durmiendo después de jugar.', '2025-02-05', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440307', 'Image', 'Luna trepando la cortina.', '2025-02-07', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440308', 'Image', 'Rocky dando un paseo por el parque.', '2025-02-10', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440309', 'Image', 'Nala aprendiendo un truco nuevo.', '2025-02-12', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103');

-- Marzo
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440310', 'Image', 'Thor bajo la lluvia.', '2025-03-03', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440104'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440311', 'Image', 'Milo jugando con burbujas.', '2025-03-04', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440105'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440312', 'Image', 'Max olfateando flores.', '2025-03-06', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440313', 'Image', 'Luna escondida en el armario.', '2025-03-08', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440314', 'Image', 'Rocky en el veterinario.', '2025-03-10', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102');

-- Abril
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440315', 'Image', 'Nala cazando mariposas.', '2025-04-01', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440316', 'Image', 'Thor corriendo por el campo.', '2025-04-04', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440104'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440317', 'Image', 'Milo investigando una planta.', '2025-04-06', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440105'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440318', 'Image', 'Max jugando a atrapar la pelota.', '2025-04-07', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440319', 'Image', 'Luna y su siesta diaria.', '2025-04-09', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101');

-- Mayo
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440320', 'Image', 'Rocky saludando a nuevos amigos.', '2025-05-01', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440321', 'Image', 'Nala disfrutando del sol.', '2025-05-03', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440324', 'Image', 'Max y Luna compartiendo un snack.', '2025-05-10', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100');

-- Junio
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440325', 'Image', 'Luna explorando el jardín.', '2025-06-01', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440326', 'Image', 'Rocky aprendiendo a sentarse.', '2025-06-03', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440327', 'Image', 'Nala y su peluche favorito.', '2025-06-06', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103');



-- Julio
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
    ('550e8400-e29b-41d4-a716-446655440330', 'Image', 'Max en la piscina por primera vez.', '2025-07-03', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100'),
    ('550e8400-e29b-41d4-a716-446655440331', 'Image', 'Luna observando pájaros desde la ventana.', '2025-07-08', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101'),
    ('550e8400-e29b-41d4-a716-446655440332', 'Image', 'Rocky corriendo por la playa.', '2025-07-15', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102');

-- Agosto
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440333', 'Image', 'Nala dormida en la hamaca.', '2025-08-02', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440334', 'Image', 'Thor corriendo detrás de mariposas.', '2025-08-06', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440104'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440335', 'Image', 'Milo comiendo su comida favorita.', '2025-08-09', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440105'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440336', 'Image', 'Max en un paseo nocturno.', '2025-08-12', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440337', 'Image', 'Luna y sus aventuras en el jardín.', '2025-08-17', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101');

-- Septiembre
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440338', 'Image', 'Rocky estrenando su collar nuevo.', '2025-09-03', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440339', 'Image', 'Nala jugando con hojas secas.', '2025-09-07', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440340', 'Image', 'Thor descansando bajo el sol.', '2025-09-12', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440104'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440341', 'Image', 'Milo mirando la lluvia caer.', '2025-09-15', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440105');

-- Octubre
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440342', 'Image', 'Max disfrazado para Halloween.', '2025-10-01', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440343', 'Image', 'Luna jugando con calabazas.', '2025-10-04', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440344', 'Image', 'Rocky con su nuevo abrigo.', '2025-10-08', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440345', 'Image', 'Nala visitando el veterinario.', '2025-10-12', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440346', 'Image', 'Thor disfrutando de una caminata otoñal.', '2025-10-16', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440104'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440347', 'Image', 'Milo persiguiendo sombras.', '2025-10-20', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440105');

-- Noviembre
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440348', 'Image', 'Max esperando en la ventana.', '2025-11-02', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440349', 'Image', 'Luna y el árbol sin hojas.', '2025-11-07', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440101'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440350', 'Image', 'Rocky tomando siesta en la alfombra.', '2025-11-11', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440102');

-- Diciembre
INSERT INTO publicacion (id, image, descripcion, fecha_publicacion, usuario_id, mascota_id) VALUES
                                                                                                ('550e8400-e29b-41d4-a716-446655440351', 'Image', 'Nala entre regalos navideños.', '2025-12-01', '550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440103'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440352', 'Image', 'Thor con gorro de navidad.', '2025-12-05', '550e8400-e29b-41d4-a716-446655440002', '550e8400-e29b-41d4-a716-446655440104'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440353', 'Image', 'Milo mirando las luces navideñas.', '2025-12-10', '550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440105'),
                                                                                                ('550e8400-e29b-41d4-a716-446655440354', 'Image', 'Max y Luna junto al árbol.', '2025-12-24', '550e8400-e29b-41d4-a716-446655440001', '550e8400-e29b-41d4-a716-446655440100');

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