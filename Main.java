public class Main {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();
        TabelaHashComEnderecamentoAberto tabelaEnderecamentoAberto = new TabelaHashComEnderecamentoAberto();
        
        tabelaHash.inserir(43, "Maria");
        tabelaHash.inserir(1, "bia");
        tabelaHash.inserir(11, "Alice");

        tabelaHash.imprimirTabelaCompleta();

        tabelaEnderecamentoAberto.inserir(1, "Amanda");
        tabelaEnderecamentoAberto.inserir(2, "Thais");
        tabelaEnderecamentoAberto.inserir(11, "Lucas");
        tabelaEnderecamentoAberto.inserir(21, "Julia");
        
        tabelaEnderecamentoAberto.imprimirTabelaCompleta();
    }
}
