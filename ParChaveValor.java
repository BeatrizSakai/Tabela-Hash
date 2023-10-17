public class ParChaveValor {
    private int chave;
    private Object valor;

    ParChaveValor(int chave, Object valor) {
        this.chave = chave;
        this.valor = valor;
        }
    
        public int getChave() {
            return chave;
        }
    
        public Object getValor() {
            return valor;
        }
    
        public void setValor(Object valor) {
            this.valor = valor;
        }
    }

