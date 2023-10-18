public class Main {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();
        TabelaHashComEnderecamentoAberto tabelaEnderecamentoAberto = new TabelaHashComEnderecamentoAberto();
        tabelaEnderecamentoAberto.inserir(1, "Um");
        tabelaEnderecamentoAberto.inserir(2, "Dois");
        tabelaEnderecamentoAberto.inserir(11, "Onze");
        tabelaHash.inserir(43, "Maria");
        tabelaHash.inserir(1, "bia");
        tabelaHash.inserir(11, "Alice");

        tabelaHash.imprimirTabelaCompleta();
        
    }
}
