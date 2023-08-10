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








