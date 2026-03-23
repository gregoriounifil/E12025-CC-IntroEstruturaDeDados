public class PilhaDinamica {

    No topo;

    public PilhaDinamica() {
        this.topo = null;
    }

    public void empilhar(String elemento) {
        No novoNo = new No(elemento);
        novoNo.setProx(topo);
        topo = novoNo;
        System.out.println("Elemento " + elemento + " empilhado com sucesso.");
    }

    public String desempilhar() {
        if (!estaVazio()) {
            String removido = topo.getConteudo();
            topo = topo.getProx();
            System.out.println("Elemento " + removido + " desempilhado com sucesso.");
            return removido;
        }
        return null;
    }

    public String verTopo() {
        if (!estaVazio()) {
            System.out.println("Topo da pilha: " + topo.getConteudo());
            return topo.getConteudo();
        }
        return null;
    }

    private boolean estaVazio() {
        if (topo == null) {
            System.out.println("A pilha está vazia!");
            return true;
        }
        return false;
    }

    public void exibirElementos() {
        if (!estaVazio()) {
            No aux = topo;
            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }

    public int tamanho() {
        int cont = 0;
        No aux = topo;
        while (aux != null) {
            cont++;
            aux = aux.getProx();
        }
        System.out.println("A pilha possui " + cont + " elemento(s).");
        return cont;
    }

    public void limpar() {
        topo = null;
        System.out.println("Pilha limpa com sucesso.");
    }

    public boolean contem(String elemento) {
        if (!estaVazio()) {
            No aux = topo;
            while (aux != null) {
                if (aux.getConteudo().equals(elemento)) {
                    System.out.println("Elemento " + elemento + " encontrado na pilha.");
                    return true;
                }
                aux = aux.getProx();
            }
        }
        System.out.println("Elemento " + elemento + " não encontrado na pilha.");
        return false;
    }

    public int contarOcorrencias(String elemento) {
        int cont = 0;
        No aux = topo;
        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                cont++;
            }
            aux = aux.getProx();
        }
        System.out.println("O elemento " + elemento + " aparece " + cont + " vez(es) na pilha.");
        return cont;
    }
}