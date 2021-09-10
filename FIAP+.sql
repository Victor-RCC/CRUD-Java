
DROP TABLE T_CP_FILMES;

CREATE TABLE T_CP_FILMES (
    id                NUMBER  NOT NULL,
    titulo            VARCHAR(30),
    ano_lancamento    NUMBER(4),
    sinopse           VARCHAR(200),
    nota              NUMBER(2),
    assistido         VARCHAR(4),
    onde_assistir     VARCHAR(20)
);


ALTER TABLE T_CP_FILMES ADD CONSTRAINT CK_T_CP_FILMES CHECK (assistido IN ('sim','não'));
ALTER TABLE T_CP_FILMES ADD CONSTRAINT PK_T_CP_FILMES PRIMARY KEY (id);
ALTER TABLE T_CP_FILMES ADD CONSTRAINT CK_T_CP_NOTA CHECK (nota > 0 AND nota <= 10);