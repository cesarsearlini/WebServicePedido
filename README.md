## WebServicePedido
  
  Serviço que recebe e lista pedidos em JSON e XML.
  
  * Framework's utilizado. 
    > Spring Boot</br>
    > Spring RESTful</br>
    > Spring Data</br>
    > Flyway</br>
  * Banco de Dados 
    > Mysql</br> 
    
  
## Configurações do Projeto
  
  Aterar as Informaçoes do Banco de Dados no Pacote <i>br.com.eicon</i> classe: <b>PropertiesConfig.java</b>.

  ```sh
    protected static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    protected static final String DB_HOST = "jdbc:mysql://localhost:3306/";
    protected static final String DB_NAME = "pedido";
    protected static final String DB_USER = "root";
    protected static final String DB_PASS = "";
  ```
  
  Ao iniciar o projeto o Banco de Dados sera criado Automaticamente e Tabela cliente Será populada pela Flyway, 
Script em SQL que popula o banco esta dentro de <i>resources/db/migration</i> script: <b>V02__insert_cliente.sql</b>.

## JSON

  - Url`s - Controller JSON
    
    * Cadastrar pedidos : [http://localhost:8080/json/pedido/salvar](http://localhost:8080/json/pedido/salvar)
        ```sh
          {
             "pedido":[
                {
                   "numeroControle":7,
                   "produto":"Cafe",
                   "valor":2,
                   "cliente":1
                },
                {
                   "numeroControle":2,
                   "dataCadastro":"2017-03-25",
                   "produto":"Refrigerante",
                   "valor":8,
                   "quantidade":6,
                   "cliente":2
                },
                {
                   "numeroControle":1,
                   "dataCadastro":"2017-03-25",
                   "produto":"Agua",
                   "valor":5,
                   "quantidade":10,
                   "cliente":3
                }
             ]
          }
        ```
    * Listar pedidos: [http://localhost:8080/json/pedidos](http://localhost:8080/json/pedidos)
    * Buscar pedido pelo número de controle - [http://localhost:8080/json/pedido/numeroControle/{numeroControle}](http://localhost:8080/json/pedido/numeroControle/1)
    * Buscar pedido pela data de cadastro - Formato: "yyyy-mm-dd" [http://localhost:8080/json/pedido/dataCadastro/{dataCadastro}](http://localhost:8080/json/pedido/dataCadastro/2017-03-26)

# XML
  
  - Url`s - Controller XML

    * Cadastrar pedidos : [http://localhost:8080/xml/pedido/salvar](http://localhost:8080/xml/pedido/salvar)
        ```sh
             <pedidos>
                <pedido>
                   <cliente>1</cliente>
                   <numeroControle>7</numeroControle>
                   <produto>Cafe</produto>
                   <valor>2</valor>
                </pedido>
                <pedido>
                   <cliente>2</cliente>
                   <dataCadastro>2017-03-25</dataCadastro>
                   <numeroControle>2</numeroControle>
                   <produto>Refrigerante</produto>
                   <quantidade>6</quantidade>
                   <valor>8</valor>
                </pedido>
                <pedido>
                   <cliente>2</cliente>
                   <dataCadastro>2017-03-25</dataCadastro>
                   <numeroControle>1</numeroControle>
                   <produto>Agua</produto>
                   <quantidade>10</quantidade>
                   <valor>5</valor>
                </pedido>
             </pedidos>
        ```
    * Listar pedidos: [http://localhost:8080/xml/pedidos](http://localhost:8080/xml/pedidos)
    * Buscar pedido pelo número de controle - [http://localhost:8080/xml/pedido/numeroControle/{numeroControle}](http://localhost:8080/xml/pedido/numeroControle/1)
    * Buscar pedido pela data de cadastro - Formato: "yyyy-mm-dd" [http://localhost:8080/xml/pedido/dataCadastro/{dataCadastro}](http://localhost:8080/xml/pedido/dataCadastro/2017-03-26)
