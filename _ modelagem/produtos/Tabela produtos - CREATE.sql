/*
------------------------------------------------------------------
 CREATEs da tabela produtos
------------------------------------------------------------------
*/

------------------------------------------------------------------
-- tabela produtos
CREATE TABLE public.produtos (
	id_produto SERIAL PRIMARY KEY NOT NULL, -- chave primária
	nome VARCHAR(100) NOT NULL,
	categoria VARCHAR(100) NOT NULL,
	preco numeric(7,2) NOT NULL,
	fornecedor_id INTEGER NOT NULL, -- FK
	
	
	-- FK, faz referência da coluna fornecedor_id desta tabela
	-- com a coluna id_fornecedor da tabela fornecedores
	FOREIGN KEY(fornecedor_id) REFERENCES public.fornecedores (id_fornecedor)
);

------------------------------------------------------------------
-- SELECT, para confirmar
------------------------------------------------------------------

SELECT * FROM public.produtos;

-- se não ouve erro, é exibido o cabeçalho das tabelas

------------------------------------------------------------------
------------------------------------------------------------------


