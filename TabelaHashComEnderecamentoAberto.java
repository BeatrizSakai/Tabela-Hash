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

        while (tabela.get(index) != null) {
            if (tabela.get(index).getChave() == chave) {
                tabela.get(index).setValor(valor);
                return;
            }
            index = (index + 1) % tabela.size();
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
                return tabela.get(index).getValor();
            }
            index = (index + 1) % tabela.size();
        }

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

                return valorRemovido;
            }
            index = (index + 1) % tabela.size();
        }

        return null;
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
}
