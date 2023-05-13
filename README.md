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
- [Rotas](#rotas)
 - [Rotas de usuários](#Rotas-de-usuários) 
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

## Rotas

**Rotas de usuários:**

| Método HTTP | Endpoint             | Descrição                                                   | 
| ----------- | ---------------------| ------------------------------------------------------------|
| GET         | `/usuarios/all`      | Retorna todos os cadastrados                                |
| POST        | `/usuarios/cadastrar`| Logar um usuário                                            | 
| POST        | `/usuarios/logar `   | Logar um usuário                                            | 

**Rotas de categorias:**

| Método HTTP | Endpoint                                   | Descrição                     | 
| ----------- | -------------------------------------------| ------------------------------|
| GET         | `/categoria`                               | Retorna todas as categorias   |
| GET         | `/categoria/{idCategoria}`                 | Retorna categorias por id     |
| GET         | `/categoria/tipoCategoria/{tipoCategoria}` | Retorna por tipo de categoria |
| POST        | `/categoria`                               | Cria categoria                |
| PUT         | `/categoria/atualizar/{id}`                | Atualiza categoria por id     |
| DELETE      | `/categoria/{id}`.                         | Retorna todos os cadastrados  |



**Rotas de estabelecimentos:**

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
