CREATE SEQUENCE empresa_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 999999
    CACHE 1;

CREATE TABLE empresa (
    id INTEGER DEFAULT nextval('empresa_id_seq') PRIMARY KEY,
    razao_social VARCHAR(64) NOT NULL,
    cnpj VARCHAR(32) NOT NULL UNIQUE,
    logradouro VARCHAR(64),
    numero VARCHAR(10),
    complemento VARCHAR(64),
    bairro VARCHAR(64),
    cep VARCHAR(16),
    telefone VARCHAR(32),
    email VARCHAR(256) NOT NULL,
    site VARCHAR(254),
    usuario VARCHAR(20) NOT NULL UNIQUE,
    senha VARCHAR(128),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE SEQUENCE leilao_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 999999
    CACHE 1;

CREATE TABLE leilao (
    id INTEGER DEFAULT nextval('leilao_id_seq') PRIMARY KEY,
    codigo INTEGER,
    descricao VARCHAR(60) NOT NULL,
    vendedor INTEGER NOT NULL,
    FOREIGN KEY (vendedor) REFERENCES empresa(id),
    inicio_previsto TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE TABLE comprador (
    empresa INTEGER NOT NULL,
    leilao INTEGER NOT NULL,
    FOREIGN KEY (empresa) REFERENCES empresa(id),
    FOREIGN KEY (leilao) REFERENCES leilao(id),
    PRIMARY KEY (empresa, leilao)
);

CREATE SEQUENCE lote_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 999999
    CACHE 1;

CREATE TABLE lote (
    id INTEGER DEFAULT nextval('lote_id_seq') PRIMARY KEY,
    numero_lote INTEGER,
    descricao VARCHAR(60) NOT NULL,
    quantidade NUMERIC NOT NULL,
    valor_inicial NUMERIC,
    unidade VARCHAR(128) NOT NULL,
    leilao INTEGER NOT NULL,
    FOREIGN KEY (leilao) REFERENCES leilao(id),
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);

CREATE SEQUENCE unidade_id_seq
    START 1
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 999999
    CACHE 1;

CREATE TABLE unidade (
    id INTEGER DEFAULT nextval('unidade_id_seq') PRIMARY KEY,
    nome VARCHAR(128) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);