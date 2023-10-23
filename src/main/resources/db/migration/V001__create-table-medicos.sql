CREATE TABLE medicos (
                                  id BIGINT auto_increment NOT NULL,
                                  nome varchar(255) NOT NULL,
                                  especialidade varchar(100) NOT NULL,
                                  crm varchar(100) NOT NULL,
                                  email varchar(255) NOT NULL,
                                  logradouro varchar(255) NOT NULL,
                                  numero varchar(100) NULL,
                                  complemento varchar(100) NULL,
                                  bairro varchar(100) NOT NULL,
                                  cidade varchar(100) NOT NULL,
                                  uf varchar(2) NOT NULL,
                                  cep varchar(9) NOT NULL,
                                  telefone varchar(11) NOT NULL,
                                  CONSTRAINT medicos_pk PRIMARY KEY (id)
                                )
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_0900_ai_ci
    COMMENT='Tabela com médicos';
