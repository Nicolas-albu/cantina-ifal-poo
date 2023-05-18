# :fries:	Cantina do IFAL
:rocket: Projeto da disciplina de POO (Programação Orientado a Objetos) do Curso Desenvolvimento de Sistemas do Campus Maceió - IFAL. O motivo desse projeto é servir como nota do 4° bimestre do 2° ano do curso técnico. O projeto é um CLI de uma necessidade de um sistema de controle de estoque da cantina do Insituto Federal de Alagoas (IFAL).

## **Integrantes**
- Nícolas Albuquerque Ramos.

## **Perguntas**
**Conseguiu ou não realizar tudo o que foi proposto? Se não conseguiu, detalhe o que faltou.**

Não consegui fazer tudo no prazo. O que faltou:
- desenvolver soluções para as operações com funcionários (adicionar e remover), 
- não permitir o cadastro de preços menor que o preço de venda,
- guardar o preço de compra do produto na tabela TBL_ITENS,
- guardar o preço da venda dos itens na tabela TBL_VENDA,
- guardar a quantidade comprada do produto na tabela TBL_ITENS,
- guardar a quantidade vendida dos itens na tabela TBL_VENDA,
- resumo de lucro/prejuízo.

**Quais os possíveis problemas que se identifica no código?**

Além da não implementação dos requisitos citados na resposta da 1° pergunta, acredito que apenas que o menu não é mostrado novamente quando terminado uma operação.

**Sentiu dificuldade para desenvolver o projeto? Quais?**

Sim,
- aplicar completamente os príncipios de projetos, principalmente o princípio "fechado para modificação e aberto para extensão", 
- aplicar a arquitetura MVC.

## **Configurações**
- Foi utilizado o Gradle para automação de compilação e gerenciamento de dependência.
- O script do banco de dados (MySQL) se encontra [na pasta docs](docs/script_database.sql).
- A porta, nome do usuário e senha do banco estão no [arquivo config.properties em resources](app/src/main/resources/config.properties).

## :warning: **Observação**
Leve em consideração os seguintes tópicos:
- Esse projeto ainda está em desenvolvimento.
- Esse projeto também não tem implicação real, apenas para nota de curso.
- O script do banco de dados foi construido no MySQL Workbench.

## :pushpin: **Tasks**
- [x] Criar todas as tabelas do Modelo relacional no MYSQL.
- [ ] O programa deve:
	- [x] Fornecer um menu de opções.
	- [ ] Operacoes com funcionarios:
		- [ ] Adicionar funcionario.
		- [ ] Remover funcionario.
	- [ ] Não permitir que sejam cadastrados itens com preços inválidos, inclusive preço de venda menor que o preço de
	compra.
	- [ ] Guardar a informação dos itens do estoque da cantina: 
      - [x] nome do produto.
      - [x] descrição do produto.
      - [ ] preço de compra do produto.
      - [x] preço unitário do produto.
      - [ ] preço da venda.
      - [ ] quantidade comprada.
      - [ ] quantidade vendida.
      - [x] Não permitir que a quantidade de itens disponíveis seja inválida.
      - [x] Permitir que o administrador da cantina:
      	- [x] cadastre itens no estoque.
	- [x] altere itens no estoque.
	- [x] exclua itens no estoque.
      - [x] * Dar baixa nos itens vendidos do estoque.  **(refazer para retirar quantidade de produto na TBL_PRODUTO, inserir em TBL_ITENS e TBL_VENDA)**
      - [x] Permitir resumo de itens:
      	- [x] Suas quantidades disponíveis ordenado pela: 
      	  - [x] descrição, ou
      	  - [x] quantidade disponível, a critério do usuário.
        - [x] * Mostrar resumo dos itens com quantidade baixa no estoque (abaixo de 50 itens). **(refazer para mostrar o resumo dos itens na tabela TBL_ITENS, e não para TBL_PRODUTO)**
	- [ ] Permitir resumo de lucros:
		- [ ] Mostrar resumo do lucro/prejuízo de acordo com a baixa dos produtos no estoque.
		- [ ] Mostrar o total vendido por dia.
		- [ ] Mostrar o valor total por mês.

## **Referências**
- [Diferença entre os patterns PO, POJO, BO, DTO e VO](https://www.devmedia.com.br/diferenca-entre-os-patterns-po-pojo-bo-dto-e-vo/28162)
- [O que é DTO?](https://pt.stackoverflow.com/questions/31362/o-que-%C3%A9-um-dto)
- [Uma rápida introdução à injeção de dependências: o que é e quando usá-la](https://www.freecodecamp.org/portuguese/news/uma-rapida-introducao-a-injecao-de-dependencias-o-que-e-e-quando-usa-la/#:~:text=Em%20engenharia%20de%20software%2C%20a,ser%20usado%20(um%20servi%C3%A7o))
- [ASCII Table](https://github.com/vdmeer/asciitable/tree/master#gradle-grails)
- [Gradle dependencies](https://www.jetbrains.com/help/idea/work-with-gradle-dependency-diagram.html)
- [Java Custom Annotations](https://nglauber.medium.com/java-custom-annotations-49b2418b75e1)
- [Entendendo Anotações em Java](https://www.devmedia.com.br/entendendo-anotacoes-em-java/26772)
- [Which tag should be used as paragraph separator in Javadoc?](https://stackoverflow.com/questions/5260368/which-tag-should-be-used-as-paragraph-separator-in-javadoc)
- [JDBC](https://github.com/Nicolas-albu/JDBC/blob/master/src/main/java/org/Resources/ConfigDatas.java)
- [Design-Patterns](https://github.com/Nicolas-albu/Design-Patterns/tree/main/Java)
- [Explore o novo tipo "var" do Java 10](https://www.infoq.com/br/articles/java-10-var-type/)
