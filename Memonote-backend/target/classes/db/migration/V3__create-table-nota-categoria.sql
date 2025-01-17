CREATE TABLE nota_categoria(
    id INT NOT NULL AUTO_INCREMENT,
    id_nota INT NOT NULL, 
    id_categoria INT NOT NULL, 
    CONSTRAINT fk_nota FOREIGN KEY (id_nota) REFERENCES nota(id),
    CONSTRAINT fk_categoria FOREIGN KEY (id_categoria) REFERENCES categoria(id),
    PRIMARY KEY (id)
)