/*
------------------------------------------------------------------
 SELECTs da tabela produtos
------------------------------------------------------------------
*/

 -- ordena em ordem crescente (ASC / DESC)
------------------------------------------------------------------
------------------------------------------------------------------

SELECT * FROM public.produtos
	ORDER BY id_produto ASC;



SELECT p.nome, f.nome
	FROM produtos p 
	JOIN fornecedores f
	ON p.fornecedor_id = f.id_fornecedor 

	
	
------------------------------------------
SELECT p.*, f.id_fornecedor, f.nome
	FROM produtos p 
	JOIN fornecedores f
	ON p.fornecedor_id = f.id_fornecedor 
	ORDER BY p.id_produto ASC;


	
SELECT * FROM public.produtos, public.fornecedores
	WHERE fornecedor_id = id_fornecedor
	ORDER BY id_produto ASC;

	
	
SELECT p.nome, f.nome FROM public.produtos p, public.fornecedores f
	WHERE p.fornecedor_id = f.id_fornecedor
	ORDER BY id_produto ASC;
	

	
SELECT p.nome, f.nome
	FROM produtos p 
	JOIN fornecedores f
	ON p.fornecedor_id = f.id_fornecedor 
	

------------------------------------------------------------------
------------------------------------------------------------------


