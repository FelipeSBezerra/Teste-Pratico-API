INSERT INTO empresa (razao_social, cnpj, logradouro, numero, complemento, bairro, cep, telefone, email, site, usuario, senha, created_at, updated_at) VALUES
('Empresa A - LTDA', '31.663.972/0001-90', 'Rua A', '123', 'Sala 1', 'Bairro A', '12345-000', '(00) 1234-5678', 'empresaa@email.com', 'www.empresaa.com', 'usuarioA', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Empresa B - ME', '57.732.007/0001-15', 'Rua B', '456', 'Sala 2', 'Bairro B', '12345-001', '(00) 2345-6789', 'empresab@email.com', 'www.empresab.com', 'usuarioB', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Empresa C - LTDA', '90.775.754/0001-06', 'Rua C', '789', 'Sala 3', 'Bairro C', '12345-002', '(00) 3456-7890', 'empresac@email.com', 'www.empresac.com', 'usuarioC', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Empresa D - LTDA', '79.115.440/0001-44', 'Rua D', '012', 'Sala 4', 'Bairro D', '12345-003', '(00) 4567-8901', 'empresad@email.com', 'www.empresad.com', 'usuarioD', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Empresa E - MEI', '54.686.146/0001-61', 'Rua E', '345', 'Sala 5', 'Bairro E', '12345-004', '(00) 5678-9012', 'empresae@email.com', 'www.empresae.com', 'usuarioE', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Empresa F - ME', '71.832.992/0001-61', 'Rua F', '678', 'Sala 6', 'Bairro F', '12345-005', '(00) 6789-0123', 'empresaf@email.com', 'www.empresaf.com', 'usuarioF', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Empresa G - ME', '31.980.457/0001-33', 'Rua G', '901', 'Sala 7', 'Bairro G', '12345-006', '(00) 7890-1234', 'empresag@email.com', 'www.empresag.com', 'usuarioG', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Empresa H - LTDA', '05.380.518/0001-11', 'Rua H', '234', 'Sala 8', 'Bairro H', '12345-007', '(00) 8901-2345', 'empresah@email.com', 'www.empresah.com', 'usuarioH', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Empresa I - LTDA', '02.081.932/0001-31', 'Rua I', '567', 'Sala 9', 'Bairro I', '12345-008', '(00) 9012-3456', 'empresai@email.com', 'www.empresai.com', 'usuarioI', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Empresa J - LTDA', '88.880.813/0001-64', 'Rua J', '890', 'Sala 10', 'Bairro J', '12345-009', '(00) 0123-4567', 'empresaj@email.com', 'www.empresaj.com', 'usuarioJ', '123456', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO leilao (codigo, descricao, vendedor, inicio_previsto, created_at, updated_at) VALUES
(1, 'Leilão A', 1, '2024-04-10 12:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Leilão B', 2, '2024-04-15 12:45:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Leilão C', 3, '2024-04-20 10:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Leilão D', 4, '2024-04-25 11:30:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Leilão E', 5, '2024-04-30 09:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 'Leilão F', 6, '2024-05-06 09:50:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 'Leilão G', 7, '2024-05-07 12:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 'Leilão H', 8, '2024-05-12 10:45:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 'Leilão I', 9, '2024-05-15 12:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 'Leilão J', 10, '2024-05-25 11:00:00', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO comprador (empresa, leilao) VALUES
(10, 1),
(9, 2),
(8, 3),
(7, 4),
(6, 5),
(5, 6),
(4, 7),
(3, 8),
(2, 9),
(1, 10);

INSERT INTO lote (numero_lote, descricao, quantidade, valor_inicial, unidade, leilao, created_at, updated_at) VALUES
(1, 'Lote 1', 25, 100.00, 'Unidade 1', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Lote 2', 20, 200.00, 'Unidade 2', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Lote 3', 15, 300.00, 'Unidade 3', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Lote 4', 10, 400.00, 'Unidade 4', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Lote 5', 5, 500.00, 'Unidade 5', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(6, 'Lote 6', 25, 600.00, 'Unidade 6', 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 'Lote 7', 20, 700.00, 'Unidade 7', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 'Lote 8', 15, 800.00, 'Unidade 8', 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 'Lote 9', 10, 900.00, 'Unidade 9', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 'Lote 10', 5, 1000.00, 'Unidade 10', 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(11, 'Lote 11', 25, 1100.00, 'Unidade 11', 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(12, 'Lote 12', 20, 1200.00, 'Unidade 12', 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(13, 'Lote 13', 15, 1300.00, 'Unidade 13', 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(14, 'Lote 14', 10, 1400.00, 'Unidade 14', 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(15, 'Lote 15', 5, 1500.00, 'Unidade 15', 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(16, 'Lote 16', 25, 1600.00, 'Unidade 16', 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(17, 'Lote 17', 20, 1700.00, 'Unidade 17', 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(18, 'Lote 18', 15, 1800.00, 'Unidade 18', 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(19, 'Lote 19', 10, 1900.00, 'Unidade 19', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(20, 'Lote 20', 5, 2000.00, 'Unidade 20', 10, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO unidade (nome, created_at, updated_at) VALUES
('Unidade A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Unidade B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Unidade C', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Unidade D', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Unidade E', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Unidade F', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Unidade G', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Unidade H', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Unidade I', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Unidade J', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);