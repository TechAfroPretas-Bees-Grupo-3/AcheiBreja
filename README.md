# AcheiBreja
<div align="center"> 

![logoAcheiBreja](https://github.com/TechAfroPretas-Bees-Grupo-3/AcheiBreja/assets/100984525/0cd20119-a56b-4f53-9404-5101284d074b)

</div>

## Visão geral

   O projeto consiste em dar assistência ao usuário a comprar sua cerveja favorita no próprio aplicativo de acordo com a localização desejada. 
   
## Documentação 📄

- [Problema social a ser trabalhado](#problema-social-a-ser-trabalhado)
	- [Experiência social do consumidor](#experiência-social-do-consumidor)
- [Impacto e consequência do problema social na sociedade](#impacto-e-consequência-do-problema-social-na-sociedade)
	- [Economia](#economia)	 	
- [A solução](#a-solução)
- [Software](#software)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Tabelas do banco de dados](#tabelas-do-banco-de-dados)
	- [Tabela de usuários](#tabela-de-usuários) 
	- [Tabela de categorias](#tabela-de-categorias)
	- [Tabela de produtos](#tabela-de-produtos)
	- [Tabela de estabelecimentos](#tabela-de-estabelecimentos)
	- [Tabela de requisições](#tabela-de-requisições)
	- [Tabela produto estabelecimento](#tabela-produto-estabelecimento)
- [Rotas](#rotas)
	- [Rotas de usuários](#rotas-de-usuários) 
	- [Rotas de categorias](#rotas-de-categorias)
	- [Rotas de produto](#rotas-de-produto)
	- [Rotas de estabelecimentos](#rotas-de-estabelecimentos)
	- [Rotas de requisição](#rotas-de-requisição)
- [Implementações Futuras](#implementações-futuras)
- [Autoras](#autoras)
- [Referência](#referência)


## Problema social a ser trabalhado

   **Experiência social do consumidor:** O Brasil é um dos maiores consumidores de cerveja do mundo, o que por sua vez faz com que a cerveja seja uma parte importante da cultura e da tradição dos brasileiros.

## Impacto e consequência do problema social na sociedade

   **Economia:** Primeiramente, pode haver um impacto na economia local, uma vez que o consumidor pode optar por comprar a cerveja de outra marca ou mesmo deixar de consumi-la, o que pode afetar a demanda e, consequentemente, a produção e distribuição da cerveja em questão. Isso pode prejudicar os negócios locais que comercializam essa cerveja, incluindo bares, restaurantes e lojas de bebidas.

## A solução

   Visando as deficiências encontradas, nossa proposta é a de trazer para o consumidor a facilidade de encontrar a partir de sua preferência ou de acordo com a preferência de seus amigos, um estabelecimento que sirva a cerveja que mais lhe agrada, podendo inclusive já verificar o preço e optar pela melhor escolha, visando seu custo e benefício.
  
## Software

   Esse aplicativo foi projetado para permitir que os consumidores pesquisem por cervejas específicas e encontrem locais de venda próximos que oferecem essas cervejas, permitindo que os usuários pesquisem por nome de marca, estilo de cerveja e região de origem.  O aplicativo utiliza informações de geolocalização para mostrar aos usuários os locais de venda mais próximos que oferecem a cerveja procurada.
   Para incentivar o uso do aplicativo, os fabricantes de cerveja e os locais de venda poderiam oferecer promoções exclusivas para os usuários ou reversão do valor dessa promoção para entidades sem fins lucrativos.
   
## Tecnologias utilizadas
- [X] IDE Utilizada: Spring Tool Suite / Eclipse;
- [X] Banco de dados utilizado: Oracle;
- [X] Interface do banco de dados: SQL Developer;
- [X] Arquitetura MVC.

## Tabelas do banco de dados

Para as tabelas desenvolvidas neste projeto foi preciso usar um identificador único, que no banco de dados é chamado de **chaves primárias (PK)**. É importante ressaltar que as chaves primárias não podem receber valores repeditos e tão pouco nulos.

Pode-se observar ainda que nas tabelas de produtos, requisiões e produto/estabelecimento utiliza-se as chaves primárias de outras tabelas e elas são denominadas **chaves estrengeiras (FK)** e tem como objetivo identificar a relação entre elas.

### Tabela de usuários

| idUsuario (PK) | nomeCompleto             | e-mail                  | senha | 
| -------------- | -------------------------| ------------------------|-------|
|      1         | Aisla Alcântara          | aisla@gmail.com	      | 123   |                                 
|      2         | Carolaine Marquezini     | carol@gmail.com         | 1234  |
|      3         | Daiane Goncalves         | daiane@gmail.com	      | 123   |                                 
|      4         | Marília Fileto           | marilia@gmail.com	      | 123   |                                 
|      5         | Viviane NeresAisla       | viviane@gmail.com	      | 123   |                                 


### Tabela de categorias

| iidCategoria (PK) |	tipoCategoria       |  
| ----------------- | ----------------------| 
|      1            | pilsen                |   
|      2            | lager                 | 
|      3            | ipa                   |                                  


### Tabela de produtos

|idProduto (PK)| idCategoria (FK)     |	nomeProduto	   | precoProduto | volume  |
|--------------|----------------------|--------------------|--------------|---------|
|1	       | 1             	      | Patagonia Bohemian |	5,79	  | 350 ml  |
|2	       | 2	              | Quilmes	           |    7,90 	  | 473 ml  |
|3	       | 2	              | Budweiser zero     |    3,99	  | 269 ml  |
|4 	       | 3 	              | Colorado Indica    |    4,72   	  | 350 ml  |


### Tabela de estabelecimentos

|idEstabelecimento (PK) | Logradouro	           | Bairro	            | nomeBar        |
|-----------------------|--------------------------|------------------------|----------------|
|1	                | Rua Américo Brasiliense  | Cambui	            | Tatu Bola      |
|2	                | Rua Dr. Heitor Penteado  | Joaquim Egídio	    | Bar do Caixote |
|3	                | Av. Barão de Itapura	   | Taquaral	            | Dom Brejas     |
|4	                | Rua Horácio Leonardi	   | Barão Geraldo	    | Estação Barão  |


### Tabela de requisições

|IdRequisicao (PK) | idUsuario (FK) | IdProduto (FK) | idEstabelecimento (FK) | quantidadeRequisicao | dataRequisicao |
|------------------|----------------|----------------|------------------------|----------------------|----------------|
|1	           | 1       	    | 1 	     | 1	              | 1	             | 01/01/2023     |
|2	           | 2	            | 2	             | 2	              | 1	             | 01/01/2023     |
|3	           | 3	            | 3	             | 3	              | 1	             | 01/01/2023     |
|4	           | 4	            | 2	             | 4	              | 1	             | 01/01/2023     |


## Tabela produto estabelecimento

|IdProduto PK FK | idEstabelecimento PK FK |
|----------------|-------------------------|
| 1	         | 1                       |
| 2		 | 1                       |
| 4		 | 1                       |
| 2		 | 2                       |
| 4		 | 2                       |
| 1		 | 3                       |
| 3		 | 3                       |
| 1		 | 4                       |
| 2		 | 4                       |
| 3		 | 4                       |

## Rotas

Nesta API Rest FULL foi utilizado os métodos HTTP para realizar as rotas da aplicação por meio do CRUD (Create, Read, Update, Delete).

### Rotas de usuários:

| Método HTTP | Endpoint             | Descrição                                                   | 
| ----------- | ---------------------| ------------------------------------------------------------|
| GET         | `/usuarios/all`      | Retorna todos os cadastrados                                |
| POST        | `/usuarios/cadastrar`| Logar um usuário                                            | 
| POST        | `/usuarios/logar `   | Logar um usuário                                            | 

### Rotas de categorias:

| Método HTTP | Endpoint                                   | Descrição                     | 
| ----------- | -------------------------------------------| ------------------------------|
| GET         | `/categoria`                               | Retorna todas as categorias   |
| GET         | `/categoria/{idCategoria}`                 | Retorna categorias por id     |
| GET         | `/categoria/tipoCategoria/{tipoCategoria}` | Retorna por tipo de categoria |
| POST        | `/categoria`                               | Cria categoria                |
| PUT         | `/categoria/atualizar/{id}`                | Atualiza categoria por id     |
| DELETE      | `/categoria/{id}`.                         | Retorna todos os cadastrados  |



### Rotas de estabelecimentos:

| Método HTTP | Endpoint                                     | Descrição                                  | 
| ----------- | ---------------------------------------------| -------------------------------------------|
| GET         | `/estabelecimentos/buscar/all`               | Retorna todos os estabelecimentos          |
| GET         | `/estabelecimentos/buscar/{id}`              | Retorna estabelecimentos por id            |
| GET         | `/estabelecimento/buscar/produto/{idProduto}`| Retorna estabelecimentos por id do produto |
| POST        | `/estabelecimentos/criar`                    | Retorna todos os cadastrados               |
| PUT         | `/estabelecimentos/atualizar/{id}`           | Atualiza estabelecimento por id            |
| DELETE      | `/estabelecimentos/deletar/{id}`             | Retorna todos os cadastrados               |


## Autoras
- Aisla Alcântara 
- Carolaine Marquezini
- Daiane Gonçalves
- Marília Fileto 
- Viviane Neres

## Referência
https://github.com/rafaelq80/cookbook_spring_v3/blob/main/03_spring/README.md
