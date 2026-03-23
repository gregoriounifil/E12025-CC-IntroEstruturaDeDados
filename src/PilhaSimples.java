public class PilhaSimples {

    String[] pilha;
    int topo;

    public PilhaSimples(int capacidade) {
        this.pilha = new String[capacidade];
        this.topo = -1;
    }

    public void empilhar(String elemento) {
        if (!estaCheia()) {
            topo++;
            pilha[topo] = elemento;
            System.out.println("Elemento " + elemento + " empilhado com sucesso.");
        }
    }

    public String desempilhar() {
        if (!estaVazio()) {
            String removido = pilha[topo];
            pilha[topo] = null;
            topo--;
            System.out.println("Elemento " + removido + " desempilhado com sucesso.");
            return removido;
        }
        return null;
    }

    public String verTopo() {
        if (!estaVazio()) {
            System.out.println("Topo da pilha: " + pilha[topo]);
            return pilha[topo];
        }
        return null;
    }

    private boolean estaCheia() {
        if (topo == pilha.length - 1) {
            System.out.println("A pilha está cheia!");
            return true;
        }
        return false;
    }

    private boolean estaVazio() {
        if (topo == -1) {
            System.out.println("A pilha está vazia!");
            return true;
        }
        return false;
    }

    public void exibir() {
        if (!estaVazio()) {
            for (int i = topo; i >= 0; i--) {
                System.out.println("pilha[" + i + "] = " + pilha[i]);
            }
        }
    }

    public int tamanho() {
        int quantidade = topo + 1;
        System.out.println("A pilha possui " + quantidade + " elemento(s).");
        return quantidade;
    }

    public void limpar() {
        for (int i = 0; i <= topo; i++) {
            pilha[i] = null;
        }
        topo = -1;
        System.out.println("Pilha limpa com sucesso.");
    }

    public boolean contem(String elemento) {
        if (!estaVazio()) {
            for (int i = topo; i >= 0; i--) {
                if (pilha[i].equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado na pilha.");
                    return true;
                }
            }
        }
        System.out.println("Elemento " + elemento + " não encontrado na pilha.");
        return false;
    }

    public int contarOcorrencias(String elemento) {
        int cont = 0;
        for (int i = topo; i >= 0; i--) {
            if (pilha[i].equals(elemento)) {
                cont++;
            }
        }
        System.out.println("O elemento " + elemento + " aparece " + cont + " vez(es) na pilha.");
        return cont;
    }
}