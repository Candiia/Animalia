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


INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440000', 'ADMIN');
INSERT INTO usuario_roles (usuario_id, roles) VALUES('550e8400-e29b-41d4-a716-446655440001', 'USER');

