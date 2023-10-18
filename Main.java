public class Main {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();
        TabelaHashComEnderecamentoAberto tabelaEnderecamentoAberto = new TabelaHashComEnderecamentoAberto();

         //Tabela Hash com Encadeamento
        tabelaHash.inserir(43, "Maria");
        tabelaHash.inserir(1, "Bia");
        tabelaHash.inserir(11, "Emilly");

        //Imprime tabela
        tabelaHash.imprimirTabelaCompleta();

        //Busca valor pela chave
        tabelaHash.buscar(43);

        //Remove valor pela chave
        tabelaHash.remove(43);

        //Busca o valor que foi removido
        tabelaHash.buscar(43);

        //Imprime a tabela depois da remoção
        tabelaHash.imprimirTabelaCompleta();


        
        //Tabela Hash com Enderaçamento Aberto
        tabelaEnderecamentoAberto.inserir(43, "Maria");
        tabelaEnderecamentoAberto.inserir(1, "Bia");
        tabelaEnderecamentoAberto.inserir(11, "Emilly");

        //Imprime tabela
        tabelaEnderecamentoAberto.imprimirTabelaCompleta();

        //Busca valor pela chave
        tabelaEnderecamentoAberto.buscar(43);

        //Remove valor pela chave
        tabelaEnderecamentoAberto.remove(43);

        //Busca o valor que foi removido
        tabelaEnderecamentoAberto.buscar(43);

        //Imprime a tabela depois da remoção
        tabelaEnderecamentoAberto.imprimirTabelaCompleta();
    }
}
