# testes-junit-conta-magica

Um banco possui um produto diferenciado chamado “conta mágica”. Nesta conta,
quanto mais dinheiro o cliente tem depositado mais o banco valoriza seus depósitos.
Todos os clientes iniciam na categoria “Silver”. Clientes “Silver” não têm seus depósitos
valorizados, ou seja, o valor creditado é exatamente o valor depositado pelo cliente.

Quando o saldo da conta atinge ou ultrapassa R$ 50.000,00, o cliente passa para a
categoria “Gold”. Clientes “Gold” têm seus depósitos valorizados em 1%. Neste caso se
o cliente depositar R$ 1.000,00 o valor creditado será de R$ 1.010,00. Finalmente se o
saldo da conta atinge ou supera os R$ 200.000,00 o cliente passa para a categoria
“Platinum”. Clientes “Platinum” têm seus depósitos valorizados em 2,5%. A verificação
de “upgrade” da conta se dá via operação de depósito.

Quando o saldo da conta diminui, em função de uma operação de retirada/saque, a
categoria também pode retroceder. Os limites, porém, não são os mesmos ao
verificados quando uma conta sofre “upgrade”. Um cliente só perde sua categoria
“Platinum”, e passa para “Gold”, se o saldo cair abaixo de R$ 100.000,00. O cliente só
perde a categoria “Gold”, e passa para “Silver”, se o saldo cair para menos de R$
25.000,00. Note que um cliente nunca perde duas categorias em uma única operação
de retirada mesmo que o saldo caia abaixo de R$ 25.000,00. Se ele era “Platinum”, cai
para “Gold”. Só poderá cair para “Silver” na próxima operação de retirada.

A classe ContaMagica é usada para implementar esse tipo de conta no sistema de um
banco. A interface da classe pode ser vista abaixo. Utilize uma enumeração “Categorias”
para indicar o estado atual da conta.

Escreva um conjunto de casos de teste que procura identificar defeitos na classe
ContaMagica
