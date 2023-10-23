CREATE TABLE pacientes (
                                  id BIGINT auto_increment NOT NULL,
                                  nome varchar(255) NOT NULL,
                                  cpf varchar(11) NOT NULL,
                                  email varchar(255) NOT NULL,
                                  telefone varchar(11) NOT NULL,
                                  logradouro varchar(255) NOT NULL,
                                  numero varchar(100) NULL,
                                  complemento varchar(100) NULL,
                                  bairro varchar(100) NOT NULL,
                                  cidade varchar(100) NOT NULL,
                                  uf varchar(2) NOT NULL,
                                  cep varchar(9) NOT NULL,
                                  CONSTRAINT pacientes_pk PRIMARY KEY (id)
                                )
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_0900_ai_ci
    COMMENT='Tabela com pacientes';
