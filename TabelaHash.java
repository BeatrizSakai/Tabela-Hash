import java.util.ArrayList;


public class TabelaHash {
    private static final int capacidadeMaxima = 10;
    private static final double fatorCarga = 0.75;

    private ArrayList<ParChaveValor>[] tabela;
    private int tamanho;

    public TabelaHash() {
        tabela = new ArrayList[capacidadeMaxima];
        for (int i = 0; i < capacidadeMaxima; i++) {
            tabela[i] = new ArrayList<>();
        }
    }

    public void inserir(int chave, Object valor) {
        int index = hash(chave);
        ArrayList<ParChaveValor> compartimento = tabela[index];
        
        for (ParChaveValor parChaveValor : compartimento) {
            if (parChaveValor.getChave() == chave) {
                parChaveValor.setValor(valor); // Se a chave já existe, atualiza o valor
                return;
            }
        }
        
        compartimento.add(new ParChaveValor(chave, valor));
        tamanho++;
        
        // Verifica o fator de carga e redimensiona se necessário
        if ((double) tamanho / tabela.length > fatorCarga) {
            resizeTabela();
        }
    }

    public Object buscar(int chave) {
        int index = hash(chave);
        ArrayList<ParChaveValor> compartimento = tabela[index];
        
        for (ParChaveValor parChaveValor : compartimento) {
            if (parChaveValor.getChave() == chave) {
                return parChaveValor.getValor();
            }
        }
        
        return null; // Chave não encontrada
    }

    public Object remove(int chave) {
        int index = hash(chave);
        ArrayList<ParChaveValor> compartimento = tabela[index];
        
        for (ParChaveValor parChaveValor : compartimento) {
            if (parChaveValor.getChave() == chave) {
                compartimento.remove(parChaveValor);
                tamanho--;
                return parChaveValor.getValor();
            }
        }
        
        return null; // Chave não encontrada
    }


    private int hash(int chave) {
        // Função de hash simples para chaves inteiras
        return chave % tabela.length;
    }

    private void resizeTabela() {
        int novaCapacidade = tabela.length * 2;
        ArrayList<ParChaveValor>[] newTabela = new ArrayList[novaCapacidade];

        for (int i = 0; i < novaCapacidade; i++) {
            newTabela[i] = new ArrayList<>();
        }

        for (ArrayList<ParChaveValor> compartimento : tabela) {
            for (ParChaveValor parChavevalor : compartimento) {
                int newIndex = hash(parChavevalor.getChave());
                newTabela[newIndex].add(parChavevalor);
            }
        }

        tabela = newTabela;
    }

    public void imprimirTabelaCompleta() {
        for (int i = 0; i < tabela.length; i++) {
            ArrayList<ParChaveValor> compartimento = tabela[i];
            if (compartimento.isEmpty()) {
                System.out.println("[" + i + "] Vazio");
            } else {
                StringBuilder valores = new StringBuilder();
                for (ParChaveValor parChaveValor : compartimento) {
                    Object valor = parChaveValor.getValor();
                    if (valores.length() > 0) {
                        valores.append(", ");
                    }
                    valores.append(valor);
                }
                System.out.println("[" + i + "] " + valores.toString());
            }
        }
    }
    
    

}
