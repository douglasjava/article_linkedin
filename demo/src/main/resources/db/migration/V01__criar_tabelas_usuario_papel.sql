
CREATE TABLE papel (
    codigo IDENTITY NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE usuario (
    codigo IDENTITY NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(120) NOT NULL,
    ativo BOOLEAN DEFAULT true,
    codigo_papel BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_papel) REFERENCES papel(codigo)
);

