# Desafio-AME-DIGITAL-REST-API-STAR-WARS
Este é um repositório que contém uma API REST desenvolvida como parte do desafio da Ame Digital https://github.com/AmeDigital/challenge-back-end-hit.


🛠️Tecnologias utilizadas
#
  1-java 17
  
  2-Spring boot 3.1.2
  
  3-Lombok 1.18.28
  
  4-Postgree 42.6.0
  
  5-Google Gson 2.10.1

🎉 Funcionalidades

 **1- Listagem de planetas**

 Enviando uma requisição GET para http://localhost:8080/planetas, a API retornará um JSON com informações de todos os planetas, incluindo seu nome, clima, terreno e quantidade de aparições em filmes.

 Exemplo de resposta:

  "content": [
		{
			"id": 3,
			"nome": "Coruscant",
			"Clima": "arido",
			"terreno": "desertico",
			"QuantidadeDeAparicoesEmFilmes": 4
		},
		{
			"id": 2,
			"nome": "Naboo",
			"Clima": "arido",
			"terreno": "desertico",
			"QuantidadeDeAparicoesEmFilmes": 4
		}
	]


**2- Detalhar as informações de um planeta com base no nome**

 Enviando uma requisição GET para http://localhost:8080/planetas/nome/NomeDoPlaneta, a API retornará um JSON com detalhes do planeta correspondente ao nome fornecido.

 Exemplo de resposta:

  {
	"id": 2,
	"nome": "Naboo",
	"Clima": "arido",
	"terreno": "desertico",
	"QuantidadeDeAparicoesEmFilmes": 4
  }

**3- Detalhar as informações de um planeta com base no nome**

  Enviando uma requisição do tipo get para http://localhost:8080/planetas/id/idDoPlanete a api irá devolver um json com detalhes do planeta, exemplo:

  {
	"id": 2,
	"nome": "Naboo",
	"Clima": "arido",
	"terreno": "desertico",
	"QuantidadeDeAparicoesEmFilmes": 4
  }

  **4- Deletar um planeta do banco de dados**

  Enviando uma requisição do tipo DELETE para http://localhost:8080/planetas/IdDoPlaneta a api irá deletar o planeta do banco de dados.

  
  **5- Cadastra um planeta no banco de dados**

  Enviando uma requisição do tipo POST para http://localhost:8080/planetas com um json no corpo a api irá cadastra o planeta no banco de dados e caso seu nome seja igual a algum planeta real da Franquia star wars um     
  atributo que define a quantidade de aparições desse planeta irá ser preenchido, exemplo de json:

{
	"nome" : "Coruscant",
	"clima" : "arido",
	"terreno" : "desertico"
}

 **6- Atualizar um planeta no banco de dados**

 Enviando uma requisição do tipo PUT para http://localhost:8080/planetas com um json no corpo a api irá atualiza aquele planeta

{
  "id" : 2,
	"nome" : "Coruscant",
	"clima" : "arido",
	"terreno" : "desertico"
}

#

**Como executar o projeto?**

1- Baixe o projeto como arquivo ZIP e descompacte-o.

2- Abra o projeto em uma IDE Java com integração com o Gradle, como Eclipse ou IntelliJ.

3- Execute o reload do Gradle para baixar as dependências necessárias.

4- Crie três variáveis de ambiente:

USER_STARWARS: o valor deve ser o nome de usuário do seu banco de dados PostgreSQL.
PASSWORD_STARWARS: o valor deve ser a senha do seu usuário do banco de dados.
DATABASE_STARWARS: o valor dessa variável de ambiente é o nome do esquema que você deseja utilizar.
Antes de executar o projeto, crie o esquema definido na variável do DATABASE_STARWARS.

5-Após criar o banco de dados, execute o projeto.
  
