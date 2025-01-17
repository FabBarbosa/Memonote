CREATE TABLE topicos_notas(
    id INT NOT NULL AUTO_INCREMENT,
    topico VARCHAR(255) NOT NULL,
    paragrafo INT NOT NULL,
    id_nota INT NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_id_nota FOREIGN KEY (id_nota) REFERENCES nota(id)
)