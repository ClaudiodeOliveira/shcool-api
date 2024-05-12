CREATE TABLE IF NOT EXISTS uf(
    CD_UF SERIAL PRIMARY KEY,
    NM_SIGLA CHAR(2),
    NM_UF VARCHAR(20),
    TS_INCLUSAO timestamp  NOT NULL,
    TS_ALTERACAO timestamp
);

COMMENT ON TABLE uf IS 'TABELA DE REGISTRO DA UF.';
COMMENT ON COLUMN uf.CD_UF IS 'NÚMERO DE IDENTIFICAÇÃO DA UF.';
COMMENT ON COLUMN uf.NM_SIGLA IS 'SIGLA DA UF.';
COMMENT ON COLUMN uf.NM_UF IS 'NOME DA UD.';
COMMENT ON COLUMN uf.TS_INCLUSAO IS 'DATA DE INCLUSÃO DO REGISTRO';
COMMENT ON COLUMN uf.TS_ALTERACAO IS 'DATA DA ULTIMA ALTERAÇÃO DO REGISTRO.';

INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(11, 'RO', 'Rondônia', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(12, 'AC', 'Acre', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(13, 'AM', 'Amazonas', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(14, 'PR', 'Roraima', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(15, 'PA', 'Pará', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(16, 'AP', 'Amapá', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(17, 'TO', 'Tocantins', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(21, 'MA', 'Maranhão', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(22, 'PI', 'Piauí', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(23, 'CE', 'Ceará', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(24, 'RN', 'Rio Grande do Norte',
                                                                            CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(25, 'PB', 'Paraíba',CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(26, 'PE', 'Pernambuco',CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(27, 'AL', 'Alagoas',CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(28, 'SE', 'Sergipe',CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(29, 'BA', 'Bahia',CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(31, 'MG', 'Minas Gerais',CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(32, 'ES', 'Espírito Santo',
                                                                            CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(33, 'RJ', 'Rio de Janeiro',
                                                                            CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(35, 'SP', 'São Paulo', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(41, 'PR', 'Paraná', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(42, 'SC', 'Santa Catarina',
                                                                            CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(43, 'RS', 'Rio Grande do Sul',
                                                                            CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(50, 'MS', 'Mato Grosso do Sul',
                                                                            CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(51, 'MT', 'Mato Grosso', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(52, 'GO', 'Goiás', CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);
INSERT INTO UF(CD_UF, NM_SIGLA, NM_UF, TS_INCLUSAO, TS_ALTERACAO)VALUES(53, 'DF', 'Distrito Federal',
                                                                            CURRENT_TIMESTAMP,
                                                                            CURRENT_TIMESTAMP);

CREATE TABLE IF NOT EXISTS ENDERECO(
    CD_ENDERECO SERIAL PRIMARY KEY,
    NO_CEP VARCHAR NOT NULL,
    NM_LOGRADOURO VARCHAR(150) NOT NULL,
    NM_COMPLEMENTO VARCHAR(150),
    NM_BAIRRO VARCHAR(100),
    NM_LOCALIDADE VARCHAR(100) NOT NULL,
    NO_NUMERO INTEGER NOT NULL,
    TS_INCLUSAO timestamp  NOT NULL,
    TS_ALTERACAO timestamp,
    CD_UF INTEGER NOT NULL,
    CONSTRAINT FK_UF
        FOREIGN KEY(CD_UF)
            REFERENCES UF(CD_UF)
                ON DELETE SET NULL
    );

COMMENT ON TABLE ENDERECO IS 'TABELA DE REGISTRO DO ENDEREÇO.';
COMMENT ON COLUMN ENDERECO.CD_ENDERECO IS 'NÚMERO DE IDENTIFICAÇÃO DO ENDEREÇO.';
COMMENT ON COLUMN ENDERECO.NO_CEP IS 'NÚMERO DO CEP DO ENDEREÇO.';
COMMENT ON COLUMN ENDERECO.NM_LOGRADOURO IS 'LOGRADOURO DO ENDEREÇO.';
COMMENT ON COLUMN ENDERECO.NM_COMPLEMENTO IS 'COMPLEMENTO DO ENDEREÇO.';
COMMENT ON COLUMN ENDERECO.NM_BAIRRO IS 'BAIRRO DO ENDEREÇO.';
COMMENT ON COLUMN ENDERECO.NO_NUMERO IS 'NÚMERO DO ENDEREÇO.';
COMMENT ON COLUMN ENDERECO.NM_LOCALIDADE IS 'CIDADE DO ENDEREÇO.';
COMMENT ON COLUMN ENDERECO.TS_INCLUSAO IS 'DATA DE INCLUSÃO DO REGISTRO';
COMMENT ON COLUMN ENDERECO.TS_ALTERACAO IS 'DATA DA ULTIMA ALTERAÇÃO DO REGISTRO.';


CREATE TABLE IF NOT EXISTS ALUNO(
    CD_ALUNO SERIAL PRIMARY KEY,
    NM_ALUNO VARCHAR(100) UNIQUE NOT NULL,
    NM_EMAIL VARCHAR(100) UNIQUE NOT NULL,
    CD_ENDERECO INTEGER NOT NULL,
    DT_NASCIMENTO DATE NOT NULL,
    TS_INCLUSAO timestamp  NOT NULL,
    TS_ALTERACAO timestamp,
    CONSTRAINT FK_ENDERECO
        FOREIGN KEY(CD_ENDERECO)
            REFERENCES ENDERECO(CD_ENDERECO)
                ON DELETE SET NULL
    );

COMMENT ON TABLE ALUNO IS 'TABELA DE REGISTRO DE ALUNOS.';
COMMENT ON COLUMN ALUNO.CD_ALUNO IS 'NÚMERO DE IDENTIFICAÇÃO DO ALUNO.';
COMMENT ON COLUMN ALUNO.NM_ALUNO IS 'NOME DO ALUNO.';
COMMENT ON COLUMN ALUNO.NM_EMAIL IS 'E-MAIL DO ALUNO.';
COMMENT ON COLUMN ALUNO.CD_ENDERECO IS 'NÚMERO DO ENDEREÇO DO ALUNO.';
COMMENT ON COLUMN ALUNO.DT_NASCIMENTO IS 'DATA DE NASCIMENTO DO ALUNO';
COMMENT ON COLUMN ALUNO.TS_INCLUSAO IS 'DATA DE INCLUSÃO DO REGISTRO';
COMMENT ON COLUMN ALUNO.TS_ALTERACAO IS 'DATA DA ULTIMA ALTERAÇÃO DO REGISTRO.';



