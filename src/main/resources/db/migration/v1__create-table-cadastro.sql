CREATE TABLE cadastro (
    id INTEGER PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    cpf VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    regis VARCHAR NOT NULL,
    adress VARCHAR NOT NULL,
    fone VARCHAR NOT NULL,
    prof VARCHAR NOT NULL,
    especialidade VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    coments TEXT
);