# Projeto de Estrutura de Dados em Java

Este é um projeto simples de uma tabela hash em Java com implementações de tratamento de colisão por encadeamento e endereçamento aberto. O projeto foi criado como parte de um curso de estrutura de dados e tem como objetivo demonstrar a implementação dessas duas estratégias de tratamento de colisão.

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

