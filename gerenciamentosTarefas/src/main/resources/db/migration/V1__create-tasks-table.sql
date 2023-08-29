CREATE TABLE tasks (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    titulo TEXT NOT NULL,
    descricao TEXT NOT NULL,
    data_inicio DATE NOT NULL,
    data_limite DATE NOT NULL,
    status INTEGER NOT NULL
);