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

INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440000', 'ADMIN');
INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440001', 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440002', 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440003', 'USER');
INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440004', 'USER');

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
VALUES ('550e8400-e29b-41d4-a716-446655440105', 'Milo', '2023-01-15', 'Un pez dorado que adora nadar.', 'https://example.com/avatars/milo.jpg', NULL, '550e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440003');
