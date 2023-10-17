public class Main {
    public static void main(String[] args) {
        TabelaHash tabelaHash = new TabelaHash();
        TabelaHashComEnderecamentoAberto tabelaEnderecamentoAberto = new TabelaHashComEnderecamentoAberto();
        tabelaEnderecamentoAberto.inserir(1, "Um");
        tabelaEnderecamentoAberto.inserir(2, "Dois");
        tabelaEnderecamentoAberto.inserir(11, "Onze");
        tabelaHash.inserir(1, "Um");
        tabelaHash.inserir(2, "Dois");
        tabelaHash.inserir(11, "Onze");

        //busca 
        System.out.println(tabelaHash.buscar(1));  // Saída: Um
        System.out.println(tabelaHash.buscar(11)); // Saída: Onze

        System.out.println(tabelaEnderecamentoAberto.buscar(1));  // Saída: Um
        System.out.println(tabelaEnderecamentoAberto.buscar(11)); // Saída: Onze

        //remove
        System.out.println(tabelaHash.remove(2)); // Saída: Dois

        System.out.println(tabelaEnderecamentoAberto.remove(2)); // Saída: Dois

        //busca elemento que não existe
        System.out.println(tabelaHash.buscar(2));  // Saída: null (não encontrado)
        System.out.println(tabelaEnderecamentoAberto.buscar(2));  // Saída: null (não encontrado)
    }
}
