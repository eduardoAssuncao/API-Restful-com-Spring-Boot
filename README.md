<a name="readme-top"></a>
<div align="center">

  <a href="https://github.com/eduardoAssuncao/API-Restful-com-Spring-Boot/blob/master">
    <img src="https://i.imgur.com/TvRH9Lc.png" alt="API RESTful" width="150" height="98">
  </a>
  

<h3 align="center">API RESTful com Spring Boot</h3>

  [![License: CC BY-NC-SA 4.0](https://img.shields.io/badge/License-CC_BY--NC--SA_4.0-lightgrey.svg)](https://creativecommons.org/licenses/by-nc-sa/4.0/)
  <p align="center">
    Guia prático para iniciantes
    <br />
    <br />
    <a href="https://github.com/github_username/repo_name/issues">Reportar Erro</a>
    ·
    <a href="https://github.com/github_username/repo_name/issues">Tirar dúvida</a>
  </p>
</div>


<!-- ABOUT THE PROJECT -->
## Sobre o projeto

O API RESTful - Guia prático para iniciantes é um e-book destinado a todos que desejam aprender a construir sua primeira API RESTful. Estruturado com explicações acessíveis, o material é dividido em 4 módulos, otimizando o processo de aprendizado. Os tópicos abordados abrangem desde os conceitos básicos até a implementação prática, proporcionando uma compreensão abrangente.
Ao longo do guia, exploramos aspectos cruciais, como a configuração do ambiente de desenvolvimento, operações CRUD e a integração com bancos de dados. As explicações são claras e complementadas por exemplos relevantes, capacitando os leitores a desenvolverem suas próprias APIs com confiança.

Este repositório contém todo o código desenvolvido no e-book, que pode ser acessado [aqui.](link)

### Descrição do projeto

Para ilustrar os conceitos principais de uma REST API com Spring Boot, nós vamos criar uma aplicação simples de To-Do List. Nesta aplicação, teremos duas entidades principais: `Tarefa` e `Usuario`. 

O diagrama de entidade-relacionamento abaixo mostra a relação entre essas entidades.

![](https://i.imgur.com/V5xXWwZ.png)


A aplicação To-Do List permitirá criar, atualizar, deletar e listar tarefas e usuários. Nossa API terá os seguintes endpoints:

    POST /usuarios: cria um usuário
        
O body da requisição deverá ser:

```json
{
  "nome": "Edu"
}
   ```

O retorno deve ser 201 em caso de sucesso e o body de resposta deve ser o próprio objeto criado:

```json
{
  "id": 1,
  "nome": "Edu",
  "tarefas": []
}
```

    PUT /usuarios/{id}: modifica um usuário
    
Devemos passar o id do usuário a ser modificado e o body da requisição deve conter os novos dados:

```json
{
  "nome": "Ana"
}
```

Retorna 200 em caso de sucesso e o objeto criado. 

    DELETE /usuarios/{id}: remove um usuário

Devemos passar o id do usuário a ser excluído e um body vazio. Retorna 204 em caso de sucesso e 404 caso o não exista o id.

    GET /usuarios: retorna todos os usuários criados

Retorna 200 e a lista de usuários criados. Caso não exista usuários cadastrados, retorna uma lista vazia.

    POST /tarefas: cria uma tarefa.

O body da requisição deverá ser:
```json
{
  "descricao": "Desenvolver uma API",
  "usuario": {
    "id": 1
  }
}
```

Deve conter a descrição da tarefa e o id do usuário associado à ela.

O retorno deve ser 201 em caso de sucesso e o body de resposta deve ser o próprio objeto criado:

```json
{
  "id": 1,
  "descricao": "Desenvolver uma API"
}
```

Retorna 500 caso o id do usuário não exista.
    PUT /tarefas/{id}: modifica uma tarefa

Devemos passar o id da tarefa a ser modificada e o body da requisição deve conter os novos dados:

```json
{
  "descricao": "Desenvolver uma API RESTful",
  "usuario": {
    "id": 1
  }
}
```

Retorna 200 em caso de sucesso e o objeto criado.

    DELETE /tarefas/{id}: remove uma tarefa

Devemos passar o id da tarefa a ser excluída e um body vazio. Retorna 204 em caso de sucesso e 404 caso o não exista o id.

    GET /tarefas: retorna todos as tarefas criadas

Retorna 200 e a lista de tarefas criadas. Caso não exista tarefas cadastradas, retorna uma lista vazia.

### Tecnologias Utilizadas

* ![Spring Boot](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
* ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
* ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
* ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
* ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)
* ![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)


<!-- GETTING STARTED -->
## Começando

### Pré-requisitos


### Instalação

1. Clone o repositório
   ```sh
   git clone https://github.com/eduardoAssuncao/API-Restful-com-Spring-Boot.git
   ```
2. Com o projeto aberto, execute o comando no terminal
   ```sh
   mvn spring-boot:run
   ```
   Caso o comando não funcione, você poderá utilizar o run java do VScode
3. Você pode utilizar o swagger:
   ```js
   http://localhost:8080/swagger-ui/index.html
   ```

   Ou utilizar o Postman para realizar as requisições.

<!-- CONTRIBUTING -->
## Contribuição

As contribuições são o que torna a comunidade de código aberto um lugar incrível para aprender, inspirar e criar. Qualquer contribuição que você fizer será **muito apreciada**.

Se você tiver alguma sugestão que possa melhorar o projeto, faça um fork do repositório e crie uma solicitação pull. Você também pode simplesmente abrir um problema com a tag "aprimoramento".
Não se esqueça de dar uma estrela para o projeto! Mais uma vez, obrigado!

1. Faça o fork do projeto
2. Crie sua ramificação de recurso (`git checkout -b feature/AmazingFeature`)
3. Faça o commit de suas alterações (`git commit -m 'Add some AmazingFeature'`)
4. Faça push para a ramificação (`git push origin feature/AmazingFeature`)
5. Abra uma solicitação pull


<!-- LICENSE -->
## Licença

Distribuído sob a licença **CreativeCommons**. Consulte `LICENSE.txt` para obter mais informações.


 [![General badge](https://licensebuttons.net/l/by-nc-sa/3.0/88x31.png)](https://creativecommons.org/licenses/by-nc-sa/4.0/)

<!-- <img src="https://br.creativecommons.net/wp-content/uploads/sites/30/2020/09/by-nc-sa.jpg" width="180" height="100"> -->

<!-- [![License: CC BY-NC-SA 4.0](https://img.shields.io/badge/License-CC_BY--NC--SA_4.0-lightgrey.svg)](https://creativecommons.org/licenses/by-nc-sa/4.0/) -->

### Você tem o direito de:
**Compartilhar** — copiar e redistribuir o material em qualquer suporte ou formato.

**Adaptar** — remixar, transformar, e criar a partir do material.

O licenciante não pode revogar estes direitos desde que você respeite os termos da licença.

### De acordo com os termos seguintes:

**Atribuição** - Você deve dar o crédito apropriado , prover um link para a licença e indicar se mudanças foram feitas . Você deve fazê-lo em qualquer circunstância razoável, mas de nenhuma maneira que sugira que o licenciante apoia você ou o seu uso.

**NãoComercial** - Você não pode usar o material para fins comerciais .

**CompartilhaIgual** - Se você remixar, transformar, ou criar a partir do material, tem de distribuir as suas contribuições sob a mesma licença que o original.

**Sem restrições adicionais** - Você não pode aplicar termos jurídicos ou medidas de caráter tecnológico que restrinjam legalmente outros de fazerem algo que a licença permita.

<!-- CONTACT -->
## Contatos

Ana Paula Rabelo de Freitas  [![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/ana-rabelo)  [![General badge](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](ana.freitas@acad.ifma.edu.br)

Eduardo Assunção de Sousa  [![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/eduardoAssuncao)  [![General badge](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](eduardo.assuncao@acad.ifma.edu.br)

Halex Miranda  [![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/halexMiranda)  [![General badge](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](halex.miranda@acad.ifma.edu.br)

Regiana Barbosa  [![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/RegianaBarbosa)  [![General badge](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](regiana.cruz@acad.ifma.edu.br)

Gabriel  [![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/GabrielAl)  [![General badge](https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](@acad.ifma.edu.br)
