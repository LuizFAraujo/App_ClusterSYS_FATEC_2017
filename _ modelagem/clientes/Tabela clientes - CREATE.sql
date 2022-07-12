/*
------------------------------------------------------------------
 CREATEs da tabela clientes
------------------------------------------------------------------
*/

------------------------------------------------------------------
-- tabela clientes
CREATE TABLE public.clientes (
	id_cliente SERIAL PRIMARY KEY NOT NULL, -- chave primária
	nome VARCHAR(100) NOT NULL,
	cpf VARCHAR(20) UNIQUE NOT NULL, -- cpf único
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

SELECT * FROM public.clientes;

-- se não ouve erro, é exibido o cabeçalho das tabelas

------------------------------------------------------------------
------------------------------------------------------------------


