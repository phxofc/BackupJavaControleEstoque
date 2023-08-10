create database dbvendas;

create table tbl_cliente(
id_cliente int not null auto_increment,
cli_nome varchar(50),
cli_endereco varchar(300),
cli_bairro varchar (50),
cli_cidade varchar (100),
cli_uf varchar (2),
cli_cep varchar(9),
cli_telefone varchar(15),
primary key(id_cliente)
);

insert into tbl_cliente (cli_nome,cli_endereco,cli_bairro,cli_cidade,
cli_uf,cli_cep,cli_telefone) values ('pedro','rau wanderley agras azevedo'
,'saudade','serra caiada','RN','59245000','40028922');



create table tbl_usuario(
id_usuario int not null auto_increment,
usu_nome varchar(50),
usu_login varchar(50),
usu_senha varchar(50),
primary key(id_usuario)
);

create table tbl_produto(
id_produto int not null auto_increment,
pro_nome varchar(300),
pro_valor double,
pro_estoque int,
primary key(id_produto)
);

insert into tbl_produto (pro_nome,pro_valor,pro_estoque) values ('camisinha',
'5','10');


create table tbl_vendas(
id_vendas int not null auto_increment,
fk_cliente int not null,
fk_produto int not null,
ven_data_venda date,
ven_valor_liquido double,
ven_valor_bruto double,
ven_valor_desconto double,
FOREIGN KEY (fk_cliente) REFERENCES tbl_cliente(id_cliente),
FOREIGN KEY (fk_produto) REFERENCES tbl_produto(id_produto),
primary key(id_vendas)
);

insert into tbl_vendas (fk_cliente,fk_produto, ven_data_venda,ven_valor_liquido,ven_valor_bruto
,ven_valor_desconto) values ('1',
'1','2023-06-28','100','150','75');


create table tbl_vendas_prudutos(
id_vendas_prudutos int not null auto_increment,
fk_produto int not null,
fk_vendas int not null,
ven_pro_valor double,
ven_pro_quantidade int,
FOREIGN KEY (fk_produto) REFERENCES tbl_produto(id_produto),
FOREIGN KEY (fk_vendas) REFERENCES tbl_vendas(id_vendas),
primary key(id_vendas_prudutos)
);





SELECT * FROM tbl_produto;

INSERT INTO tbl_produto (pro_nome, pro_valor, pro_estoque)
SELECT
  CONCAT('Produto', id) AS pro_nome,
  FLOOR(RAND() * 100) + 1 AS pro_valor,
  FLOOR(RAND() * 100) + 1 AS pro_estoque
FROM
  (SELECT 1 AS id UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5 UNION ALL
   SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10 UNION ALL
   SELECT 11 UNION ALL SELECT 12 UNION ALL SELECT 13 UNION ALL SELECT 14 UNION ALL SELECT 15 UNION ALL
   SELECT 16 UNION ALL SELECT 17 UNION ALL SELECT 18 UNION ALL SELECT 19 UNION ALL SELECT 20 UNION ALL
   SELECT 21 UNION ALL SELECT 22 UNION ALL SELECT 23 UNION ALL SELECT 24 UNION ALL SELECT 25 UNION ALL
   SELECT 26 UNION ALL SELECT 27 UNION ALL SELECT 28 UNION ALL SELECT 29 UNION ALL SELECT 30 UNION ALL
   SELECT 31 UNION ALL SELECT 32 UNION ALL SELECT 33 UNION ALL SELECT 34 UNION ALL SELECT 35 UNION ALL
   SELECT 36 UNION ALL SELECT 37 UNION ALL SELECT 38 UNION ALL SELECT 39 UNION ALL SELECT 40 UNION ALL
   SELECT 41 UNION ALL SELECT 42 UNION ALL SELECT 43 UNION ALL SELECT 44 UNION ALL SELECT 45 UNION ALL
   SELECT 46 UNION ALL SELECT 47 UNION ALL SELECT 48 UNION ALL SELECT 49 UNION ALL SELECT 50) AS dummy;
