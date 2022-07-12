/*
------------------------------------------------------------------
 CREATEs da tabela fornecedores
------------------------------------------------------------------
*/

------------------------------------------------------------------
-- tabela fornecedores
CREATE TABLE public.fornecedores (
	id_fornecedor SERIAL PRIMARY KEY NOT NULL, -- chave primária
	nome VARCHAR(100) NOT NULL,
	cnpj VARCHAR(20) UNIQUE NOT NULL, -- cnpj único
	telefone VARCHAR(20) NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL, -- email único
	rua VARCHAR(100) NOT NULL,
	numero VARCHAR(10) NOT NULL,
	cidade VARCHAR(100) NOT NULL,
	estado VARCHAR(20) NOT NULL
);

------------------------------------------------------------------
-- SELECT, para confirmar
------------------------------------------------------------------

SELECT * FROM public.fornecedores;

-- se não ouve erro, é exibido o cabeçalho das tabelas

------------------------------------------------------------------
------------------------------------------------------------------


