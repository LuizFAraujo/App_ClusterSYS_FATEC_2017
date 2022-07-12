/*
------------------------------------------------------------------
 Criação de tabelas, para cadastro de produtos
------------------------------------------------------------------
*/
-- tabela produtos
CREATE TABLE public.produtos (
	id_produto SERIAL PRIMARY KEY NOT NULL, -- chave primária
	descricao VARCHAR(100) NOT NULL,
	preco_custo NUMERIC(7,2) NOT NULL, 
	fornecedor VARCHAR(100) NOT NULL,
	localizacao VARCHAR(100) NOT NULL,
	qtde_estoque INTEGER NOT NULL,
	unidade VARCHAR(5) NOT NULL
);


------------------------------------------------------------------
-- Inserts nas tabelas de usuários
------------------------------------------------------------------
-- não informar o id da tabela acesso, é auto-incremento

-- 01
INSERT INTO 
	public.produtos(descricao, preco_custo, fornecedor, localizacao, qtde_estoque, unidade)
	values ('Martelo', 10.20, 'Araujo', 'B5', 10, 'PC');

-- 02
INSERT INTO 
	public.produtos(descricao, preco_custo, fornecedor, localizacao, qtde_estoque, unidade)
	values ('Martelo', 10.20, 'Araujo', 'B5', 10, 'PC');

-- 03
INSERT INTO 
	public.produtos(descricao, preco_custo, fornecedor, localizacao, qtde_estoque, unidade)
	values ('Martelo', 10.20, 'Araujo', 'B5', 10, 'PC');

-- 04
INSERT INTO 
	public.produtos(descricao, preco_custo, fornecedor, localizacao, qtde_estoque, unidade)
	values ('Martelo', 10.20, 'Araujo', 'B5', 10, 'PC');

-- 05
INSERT INTO 
	public.produtos(descricao, preco_custo, fornecedor, localizacao, qtde_estoque, unidade)
	values ('Martelo', 10.20, 'Araujo', 'B5', 10, 'PC');

-- 06
INSERT INTO 
	public.produtos(descricao, preco_custo, fornecedor, localizacao, qtde_estoque, unidade)
	values ('Martelo', 10.20, 'Araujo', 'B5', 10, 'PC');

-- 07
INSERT INTO 
	public.produtos(descricao, preco_custo, fornecedor, localizacao, qtde_estoque, unidade)
	values ('Martelo', 10.20, 'Araujo', 'B5', 10, 'PC');

-- 08
INSERT INTO 
	public.produtos(descricao, preco_custo, fornecedor, localizacao, qtde_estoque, unidade)
	values ('Martelo', 10.20, 'Araujo', 'B5', 10, 'PC');

-- 09
INSERT INTO 
	public.produtos(descricao, preco_custo, fornecedor, localizacao, qtde_estoque, unidade)
	values ('Martelo', 10.20, 'Araujo', 'B5', 10, 'PC');

-- 10
INSERT INTO 
	public.produtos(descricao, preco_custo, fornecedor, localizacao, qtde_estoque, unidade)
	values ('Martelo', 10.20, 'Araujo', 'B5', 10, 'PC');


------------------------------------------------------------------
-- Select, para confirmar
------------------------------------------------------------------

SELECT * FROM public.produtos
	ORDER BY id_produto ASC -- ordena em ordem crescente (ASC / DESC)

-- se não ouve erro, é exibido uma tabela do SELECT acima

