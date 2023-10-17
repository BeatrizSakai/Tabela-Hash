public class TesteEficiencia {
    public static void main(String[] args) {
        int numberOfElements = 10000; // Número de elementos a serem inseridos
        int maxChave = 1000; // Valor máximo das chaves
        TabelaHash tabelaEncadeamento = new TabelaHash();
        TabelaHashComEnderecamentoAberto tabelaEnderecamentoAberto = new TabelaHashComEnderecamentoAberto();

        // Inserção de elementos nas duas tabelas (encadeamento e endereçamento aberto)
        for (int i = 0; i < numberOfElements; i++) {
            int chave = (i * 2); // Chaves ímpares para evitar colisões
            tabelaEncadeamento.inserir(chave, "Valor" + chave);
            tabelaEnderecamentoAberto.inserir(chave, "Valor" + chave);
        }

        // Medição de tempo para buscar elementos na tabela com encadeamento
        long startTimeEncadeamento = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            int chave = (i * 2) + 1;
            tabelaEncadeamento.buscar(chave);
        }
        long endTimeEncadeamento = System.nanoTime();
        long durationEncadeamento = (endTimeEncadeamento - startTimeEncadeamento) / 1000000; // Convertendo para milissegundos

        // Medição de tempo para buscar elementos na tabela com endereçamento aberto
        long startTimeEnderecamentoAberto = System.nanoTime();
        for (int i = 0; i < numberOfElements; i++) {
            int chave = (i * 2) + 1;
            tabelaEnderecamentoAberto.buscar(chave);
        }
        long endTimeEnderecamentoAberto = System.nanoTime();
        long durationEnderecamentoAberto = (endTimeEnderecamentoAberto - startTimeEnderecamentoAberto) / 1000000; // Convertendo para milissegundos

        System.out.println("Tempo de busca (encadeamento): " + durationEncadeamento + " milissegundos");
        System.out.println("Tempo de busca (endereçamento aberto): " + durationEnderecamentoAberto + " milissegundos");
    }
}

