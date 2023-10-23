INSERT INTO usuarios (id, login, senha)
VALUES(1, 'fsanchesbr001@gmail.com', '$2a$10$9ZXe.ETY407dCIOgT6PJLO1WMYxXgOy0zi2rWnU3wClVjI/8IJpF6');

INSERT INTO medicos
(id, nome, especialidade, crm, email, logradouro, numero, complemento, bairro, cidade, uf, cep, telefone, ativo)
VALUES(1, 'Fabricio Sanches', 'ORTOPEDIA', '123456', 'fsanchesbr001@gmail.com', 'Avenida Nossa Senhora do Sabara', '4350', 'Bloco 14 apto 13', 'Vila Emir', 'São Paulo', 'SP', '04447011', '11918425322', 1);

INSERT INTO medicos
(id, nome, especialidade, crm, email, logradouro, numero, complemento, bairro, cidade, uf, cep, telefone, ativo)
VALUES(3, 'Teste Alteracao via postman Sanches', 'ORTOPEDIA', '678943', 'teste@gmail.com', 'Rua A', '1', 'Teste', 'Vila Teste', 'São Paulo', 'SP', '05767908', '1198997654', 0);

INSERT INTO medicos
(id, nome, especialidade, crm, email, logradouro, numero, complemento, bairro, cidade, uf, cep, telefone, ativo)
VALUES(4, 'Teste Sanches', 'ORTOPEDIA', '678943', 'teste@gmail.com', 'Rua A', '1', 'Teste', 'Vila Teste', 'São Paulo', 'SP', '05767908', '1198997654', 1);

INSERT INTO medicos
(id, nome, especialidade, crm, email, logradouro, numero, complemento, bairro, cidade, uf, cep, telefone, ativo)
VALUES(5, 'Teste Alteracao  2 via postman Sanches', 'GINECOLOGIA', '678912', 'ysasanches@gmail.com', 'Rua Professor Monjardino', '131', 'apto 54', 'Vila Sonia', 'São Paulo', 'SP', '05625160', '11989919518', 0);

INSERT INTO medicos
(id, nome, especialidade, crm, email, logradouro, numero, complemento, bairro, cidade, uf, cep, telefone, ativo)
VALUES(6, 'teste 5 Sanches', 'GINECOLOGIA', '678912', 'ysasanches@gmail.com', 'Rua Professor Monjardino', '131', 'apto 54', 'Vila Sonia', 'São Paulo', 'SP', '05625160', '11989919518', 1);

INSERT INTO pacientes
(id, nome, cpf, email, telefone, logradouro, numero, complemento, bairro, cidade, uf, cep, ativo)
VALUES(1, 'Luciana Sanches', '16891292808', 'luasssbr@gmail.com', '11998868456', 'Avenida Professor Monjardino', '131', 'apto 54', 'Vila Sonia', 'São Paulo', 'SP', '05625160', 1);

INSERT INTO pacientes
(id, nome, cpf, email, telefone, logradouro, numero, complemento, bairro, cidade, uf, cep, ativo)
VALUES(2, 'Fabricio Sanches', '81127260197', 'fsanchesbr001@gmail.com', '11918425322', 'Avenida Nossa Senhora do Sabara', '4350', 'Bloco 14 apto 13', 'Vila Emir', 'São Paulo', 'SP', '04447011', 0);

INSERT INTO pacientes
(id, nome, cpf, email, telefone, logradouro, numero, complemento, bairro, cidade, uf, cep, ativo)
VALUES(3, 'Fabricio Sanches', '81127260197', 'fsanchesbr001@gmail.com', '11918425322', 'Avenida Nossa Senhora do Sabara', '4350', 'Bloco 14 apto 13', 'Vila Emir', 'São Paulo', 'SP', '04447011', 1);

INSERT INTO pacientes
(id, nome, cpf, email, telefone, logradouro, numero, complemento, bairro, cidade, uf, cep, ativo)
VALUES(4, 'Teste Alteracao via postman Isabela Sanches', '81127260197', 'fsanchesbr001@gmail.com', '11918425322', 'Avenida Nossa Senhora do Sabara', '4350', 'Bloco 14 apto 13', 'Vila Emir', 'São Paulo', 'SP', '04447011', 0);

INSERT INTO pacientes
(id, nome, cpf, email, telefone, logradouro, numero, complemento, bairro, cidade, uf, cep, ativo)
VALUES(5, 'Fabricio Sanches Paciente', '81127260197', 'fsanchesbr001@gmail.com', '11918425322', 'Avenida Nossa Senhora do Sabara', '4350', 'Bloco 14 apto 13', 'Vila Emir', 'São Paulo', 'SP', '04447011', 1);

INSERT INTO consultas
(id, id_medico, id_paciente, `data`, ativo)
VALUES(1, 1, 1, '2023-10-19 09:00:00', 1);

INSERT INTO consultas
(id, id_medico, id_paciente, `data`, ativo)
VALUES(2, 1, 1, '2023-10-20 09:00:00', 1);
