/*
------------------------------------------------------------------
 CREATEs da tabela usuarios e acesso, para cadastro de usuarios
------------------------------------------------------------------
*/

------------------------------------------------------------------
-- tabela acessos
CREATE TABLE public.acessos (
	id_acesso SERIAL PRIMARY KEY NOT NULL, -- chave primária
	login VARCHAR(100) UNIQUE NOT NULL, -- login único
	senha VARCHAR(100) NOT NULL
);

------------------------------------------------------------------
-- tabela usuarios
CREATE TABLE public.usuarios (
	id_usuario INTEGER PRIMARY KEY NOT NULL, -- PK e FK
	nome VARCHAR(100) NOT NULL,
	nivel_acesso VARCHAR(50) NOT NULL,
	
	-- FK, faz referência da coluna id_usuario desta tabela
	-- com a coluna id_acesso da tabela acesso
	FOREIGN KEY(id_usuario) REFERENCES public.acessos (id_acesso)
);


------------------------------------------------------------------
-- SELECT, para confirmar
------------------------------------------------------------------

SELECT * FROM public.usuarios, public.acessos;

-- se não ouve erro, é exibido o cabeçalho das tabelas

------------------------------------------------------------------
------------------------------------------------------------------


