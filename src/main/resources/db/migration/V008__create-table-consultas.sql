CREATE TABLE consultas (
                                       id BIGINT auto_increment NOT NULL,
                                       id_medico BIGINT NOT NULL,
                                       id_paciente BIGINT NOT NULL,
                                       `data` DATETIME NOT NULL,
                                       ativo BOOL NOT NULL,
                                       CONSTRAINT consultas_pk PRIMARY KEY (id),
                                       CONSTRAINT consultas_medicos_FK FOREIGN KEY (id_medico) REFERENCES vollmed_api.medicos(id),
                                       CONSTRAINT consultas_pacientes_FK FOREIGN KEY (id_paciente) REFERENCES vollmed_api.pacientes(id)
)
    ENGINE=InnoDB
    DEFAULT CHARSET=utf8mb4
    COLLATE=utf8mb4_0900_ai_ci
    COMMENT='Guarda as consultas agendadas';
