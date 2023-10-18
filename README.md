<img src="/assets/Tabela hash.png">

# Projeto de Estrutura de Dados em Java

Este é um projeto simples de uma tabela hash em Java com implementações de tratamento de colisão por encadeamento e endereçamento aberto. O projeto foi criado como parte de um curso de estrutura de dados e tem como objetivo demonstrar a implementação dessas duas estratégias de tratamento de colisão.

## Tabela Hash
Uma tabela hash, também conhecida como mapa hash, é uma estrutura de dados fundamental em ciência da computação. Ela desempenha um papel essencial na organização eficiente de dados, permitindo o armazenamento e a recuperação rápidos de informações com base em chaves correspondentes.

## Funcionamento Básico
A ideia central por trás de uma tabela hash é utilizar uma função de hash para converter uma chave, que pode ser uma string ou qualquer outra informação identificadora, em um valor numérico único. Esse valor numérico, chamado de "hash code," é usado como um índice para acessar um local de armazenamento na tabela. A principal vantagem desse método é a capacidade de acessar os dados em tempo constante, o que torna as tabelas hash extremamente eficientes para operações de leitura e escrita.

## Resolução de Colisões
No entanto, é importante mencionar que colisões podem ocorrer, ou seja, duas chaves diferentes podem ser mapeadas para o mesmo índice na tabela. Para lidar com isso, existem diversas técnicas, como o encadeamento separado (manter uma lista ligada de valores no mesmo índice) e a resolução de colisões por sondagem (tentativa de encontrar o próximo índice disponível na tabela).

## Funcionalidades

O projeto possui as seguintes funcionalidades:

- **Tratamento de Colisão por Encadeamento**: A tabela hash usa listas encadeadas para lidar com colisões. Isso permite que várias entradas com chaves diferentes compartilhem o mesmo compartimento.

- **Tratamento de Colisão por Endereçamento Aberto**: A tabela hash usa endereçamento aberto para lidar com colisões. Quando ocorre uma colisão, a tabela é percorrida até encontrar um compartimento vazio para inserir a entrada.

- Inserção de elementos na tabela hash.
- Busca de elementos na tabela hash.
- Remoção de elementos na tabela hash.

## Estrutura de Arquivos

O projeto é organizado da seguinte forma:

- `TabelaHash.java`: Implementação da tabela hash com tratamento de colisão (encadeamento).
- `TabelaHashComEnderecamentoAberto.java`: Implementação da tabela hash com tratamento de colisão (endereçamento).
- `ParChaveValor.java`: Classe que representa um par chave-valor.
- `Main.java`: Classe principal que demonstra o uso da tabela hash.
- `TesteEficiencia.java`: Classe de teste comparitivo entre as duas tabelas.

