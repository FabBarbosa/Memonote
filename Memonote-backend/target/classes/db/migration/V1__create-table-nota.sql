CREATE TABLE nota(
    id INT not null auto_increment,
    titulo VARCHAR(100),
    texto_nota VARCHAR(255),
    status_nota VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
)