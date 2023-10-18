import java.util.ArrayList;

public class TabelaHashComEnderecamentoAberto {
    private static final int capacidadeInicial = 10;
    private static final double fatorCarga = 0.75;

    private ArrayList<ParChaveValor> tabela;
    private int tamanho;
    private int capacidadeMaxima;

    public TabelaHashComEnderecamentoAberto() {
        tabela = new ArrayList<>(capacidadeInicial);
        for (int i = 0; i < capacidadeInicial; i++) {
            tabela.add(null);
        }
        capacidadeMaxima = (int) (capacidadeInicial * fatorCarga);
    }

    public void inserir(int chave, Object valor) {
        int index = hash(chave);
        int originalIndex = index;

        while (tabela.get(index) != null) {
            if (tabela.get(index).getChave() == chave) {
                tabela.get(index).setValor(valor);
                System.out.println("Colisão: " + valor + " colidiu com " + tabela.get(index).getValor() + " e foi para o índice " + index);
                return;
            }
            index = (index + 1) % tabela.size();
            if (index == originalIndex) {
                System.out.println("Tabela cheia, não é possível inserir.");
                return;
            }
        }

        if (index != originalIndex) {
            System.out.println("Colisão: " + valor + " colidiu com " + tabela.get(originalIndex).getValor() + " e foi para o índice " + index);
        }

        tabela.set(index, new ParChaveValor(chave, valor));
        tamanho++;

        if (tamanho > capacidadeMaxima) {
            resizeTable();
        }
    }    

    public Object buscar(int chave) {
        int index = hash(chave);

        while (tabela.get(index) != null) {
            if (tabela.get(index).getChave() == chave) {
                System.out.println("Encontrada: [" + index + "] " + tabela.get(index).getValor());
                return tabela.get(index).getValor();
            }
            index = (index + 1) % tabela.size();
        }
        System.out.println("Chave não encontrada");
        return null;
    }

    public Object remove(int chave) {
        int index = hash(chave);

        while (tabela.get(index) != null) {
            if (tabela.get(index).getChave() == chave) {
                Object valorRemovido = tabela.get(index).getValor();
                tabela.set(index, null);
                tamanho--;

                // Reorganize a tabela para preencher o espaço vazio
                int i = (index + 1) % tabela.size();
                while (tabela.get(i) != null) {
                    int newHash = hash(tabela.get(i).getChave());
                    if (newHash != i) {
                        tabela.set(index, tabela.get(i));
                        tabela.set(i, null);
                    }
                    i = (i + 1) % tabela.size();
                }
                
                System.out.println("Encontrada: [" + i + "] " + valorRemovido);
                return valorRemovido;
            }
            index = (index + 1) % tabela.size();
        }

        System.out.println("Chave não encontrada");
        return null; // Chave não encontrada
    }

    private int hash(int chave) {
        return chave % tabela.size();
    }

    private void resizeTable() {
        int novaCapacidade = tabela.size() * 2;
        ArrayList<ParChaveValor> novaTabela = new ArrayList<>(novaCapacidade);

        for (int i = 0; i < novaCapacidade; i++) {
            novaTabela.add(null);
        }

        capacidadeMaxima = (int) (novaCapacidade * fatorCarga);

        for (ParChaveValor par : tabela) {
            if (par != null) {
                int index = hash(par.getChave());

                while (novaTabela.get(index) != null) {
                    index = (index + 1) % novaTabela.size();
                }

                novaTabela.set(index, par);
            }
        }

        tabela = novaTabela;
    }
    
    public void imprimirTabelaCompleta() {
        for (int i = 0; i < tabela.size(); i++) {
            ParChaveValor par = tabela.get(i);
            if (par == null) {
                System.out.println("[" + i + "] Vazio");
            } else {
                System.out.println("[" + i + "] " + par.getValor());
            }
        }
    }

}
