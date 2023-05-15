# :fries:	Cantina do IFAL
:rocket: Projeto da disciplina de POO (Programação Orientado a Objetos) do Curso Desenvolvimento de Sistemas do Campus Maceió - IFAL. O motivo desse projeto é servir como nota do 4° bimestre do 2° ano do curso técnico. O projeto é um CLI de uma necessidade de um sistema de controle de estoque da cantina do Insituto Federal de Alagoas (IFAL).

## :warning: **Observação**
Leve em consideração os seguintes tópicos:
- Esse projeto ainda está em desenvolvimento na branch develop.
- Esse projeto também não tem implicação real, apenas para nota de curso.

## :pushpin: **Tasks**
- [x] Criar todas as tabelas do Modelo relacional no MYSQL;
- [ ] O programa deve:
	- [x] Fornecer um menu de opções.
	- [ ] Operacoes com funcionarios:
		- [ ] Adicionar funcionario
		- [ ] Remover funcionario
	- [ ] Não permitir que sejam cadastrados itens com preços inválidos, inclusive preço de venda menor que o preço de
	compra.
	- [ ] Guardar a informação dos itens do estoque da cantina: 
      - [x] nome do produto, 
      - [x] descrição do produto, 
      - [ ] preço de compra do produto,
      - [x] preço unitário do produto
      de venda e quantidade comprada, quantidade vendida).
	- [x] Não permitir que a quantidade de itens disponíveis seja inválida.
	- [x] Permitir que o administrador da cantina:
		- [x] cadastre itens no estoque.
		- [x] altere itens no estoque.
		- [x] exclua itens no estoque.
	- [ ] Dar baixa nos itens vendidos do estoque.
	- [ ] Permitir resumo de itens:
		- [ ] Mostrar um resumo dos itens e
		- [ ] Suas quantidades disponíveis ordenado pela descrição 
		- [ ] ou quantidade disponível, a critério do usuário.
		- [ ] Mostrar resumo dos itens com quantidade baixa no estoque (abaixo de 50 itens).
	- [ ] Permitir resumo de lucros:
		- [ ] Mostrar resumo do lucro/prejuízo de acordo com a baixa dos produtos no estoque.
		- [ ] Mostrar o total vendido por dia.
		- [ ] Mostrar o valor total por mês.
