# PegStock  

PegStock é um sistema de gerenciamento de estoque desenvolvido para o subsistema de controle de bens da **PegAzuls AeroDesign**. Ele permite o controle eficiente de materiais, empréstimos e compras, garantindo uma melhor organização e rastreabilidade dos itens utilizados pela equipe.  

## Funcionalidades  

- **Controle de empréstimos**: Registro de saídas e devoluções de materiais.  
- **Gerenciamento de materiais**: Cadastro, edição e exclusão de itens do estoque.  
- **Histórico de movimentações**: Registro do consumo, adição e empréstimos de materiais.
- **Lista de compras**: Organização dos itens necessários para aquisição.
- **Notificações**: Alertas para itens com estoque baixo, esgotados ou próximos da data de validade.
- **Relatórios de estoque**: Geração de relatórios para controle e planejamento.  

## Tecnologias utilizadas  

O PegStock foi desenvolvido utilizando as seguintes tecnologias:  

- **Java** – Linguagem principal do projeto.  
- **Spring Boot** – Framework para construção da aplicação backend.  
- **Maven** – Gerenciador de dependências.  
- **JavaFX** – Biblioteca para criação da interface gráfica.  
- **Scene Builder** – Ferramenta para construção visual de interfaces JavaFX.  
- **PostgreSQL** – Banco de dados utilizado.  

## Clonando o repositóro
Para utilizar o projeto, siga os passos abaixo:  

```bash
# Clone o repositório
git clone https://github.com/PegAzuls-Aerodesign/PegStock.git

# Acesse o diretório do projeto
cd PegStock
```

## Instalando as dependências
Para instalar as dependências do projeto, execute o comando abaixo:  

```bash
mvn install
```


## Estrutura do projeto
```
.vscode/
src/
├── main/
│   ├── java/
│   │   ├── com/pegazuls/aerodesign/PegStock/
│   │   │   ├── infra/
│   │   │   ├── model/
│   │   │   ├── principal/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── PegStockApplication.java
│   │   └── front/
│   │       ├── PegStockConfig.java
│   │       ├── PegStockFront.java
│   │       └── PegStockFrontController.java
│   ├── resources/
│   │   ├── application.properties
│   │   └── front/
│   │       ├── assets/
│   │       ├── fxml/
│   │       │   └── PegStock.fxml
│   │       └── styles/
└── test/
    └── java/
        └── com/pegazuls/aerodesign/PegStock/
            └── PegStockApplicationTests.java
READEME.md
```

