public class ListaSimples implements ListaOperacoes{
    String[] lista;

    public ListaSimples(int tamanho) {
        this.lista = new String[tamanho];
    }

    public void exibirElementos() {
        for (int i = 0; i < this.lista.length; i++) {
            System.out.println("Lista[" + i + "] = " + this.lista[i]);
        }
    }

    public void adicionarElemento(String elemento) {
        if (!estaCheia()) {
            this.lista[encontrarPosicaoVazia()] = elemento;
            System.out.println("Elemento " + elemento + " adicionado com sucesso!");
        }
    }


    private boolean estaCheia() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return false;
            }
        }
        System.out.println("A lista está cheia!");
        return true;
    }

    private boolean estaVazio() {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null) {
                return false;
            }
        }
        System.out.println("A lista está vazia!");
        return true;
    }

    private int encontrarPosicaoVazia() {
        int i;
        for (i = 0; i < this.lista.length; i++) {
            if (this.lista[i] == null) {
                return i;
            }
        }
        return i;
    }

    public void removerElemento(String elemento) {
        if (!estaVazio()) {
            if (this.buscarElemento(elemento) >= 0) {
                this.lista[this.buscarElemento(elemento)] = null;
                System.out.println("Elemento " + elemento + " removido com sucesso!");
            }
        }
    }

    public int buscarElemento(String elemento){
        int i;
        if (!estaVazio()) {
            for (i = 0; i < this.lista.length; i++) {
                if (this.lista[i].equals(elemento)) {
                    return i;
                }
            }
        }
        System.out.println("Elemento não encontrado na lista.");
        return -1;
    }

    public void alterarElemento(String elementoASerAlterado, String alteracao) {
        if(buscarElemento(elementoASerAlterado) >= 0) {
            this.lista[buscarElemento(elementoASerAlterado)] = alteracao;
            System.out.println("Elemento " + elementoASerAlterado + " alterado com sucesso para " + alteracao);
        }
    }

    public void quantidadeElementos() {
        int cont = 0;
        if(!estaVazio()) {
            for (int i = 0; i < this.lista.length; i++) {
                if(this.lista[i] != null) {
                    cont++;
                }
            }
        }
        System.out.println("A lista possui " + cont + " elementos!");
    }

    @Override
    public int removerTodas(String elemento) {
        int cont = 0;
        if (estaVazio()) {
            System.out.println("Lista vazia!");
            return 0;
        }
        for (int i = lista.length - 1; i >= 0; i--) {
            if (lista[i] != null && lista[i].equals(elemento)) {
                removerPorIndice(i);
                cont++;
            }
        }
        System.out.println("Elementos removidos com sucesso!" + elemento + "\n" + cont + "vezes!");
        return cont;
    }

    @Override
    public int contar() {
            int i;
            int cont = 0;
            for (i = 0; i < this.lista.length; i++) {
                if (lista[i] != null) {
                    cont += 1;
                }
            }
            System.out.println("A lista possui " + cont + " elementos!");
            return cont;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int cont = 0;
        for (int i = 0; i < elementos.length; i++) {
            boolean existe = false;
            for (int j = 0; j < this.lista.length; j++) {
                if (lista[j] == null) {
                    this.lista[j] = elementos[i];
                    cont += 1;
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                break;
            }
        }
        return cont;
    }

    @Override
    public String obter(int indice) {
        if (indice < 0 || indice >= lista.length) {
            return null;
        }
        System.out.println("Elemento " + indice + " encontrado com sucesso!");
        return lista[indice];
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0 || indice >= lista.length || estaCheia() ) {
            return false;
            } else  {
            for (int i = lista.length - 1; i > indice; i--) {
                lista[i] = lista[i - 1];
        }
            }
            System.out.println("Elemento " + elemento + " inserido com sucesso!");
            lista[indice] = elemento;
            return true;
    }

    @Override
    public String removerPorIndice(int indice) {
        String elementoRemovido = obter(indice);
        if (elementoRemovido != null) {
            for (int i = indice; i < lista.length - 1; i++) {
                lista[i] = lista[i + 1];
            }
            lista[lista.length - 1] = null;
        }
        System.out.println("Elemento " + elementoRemovido + " removido com sucesso!");
        return elementoRemovido;
    }

    @Override
    public void limpar() {
        for (int i = 0; i < this.lista.length; i++) {
            this.lista[i] = null;
        }
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        if (estaVazio()) {
            System.out.println("Lista vazia!");
            return -1;
        }
        for (int i = this.lista.length - 1; i >= 0; i--) {
            if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                System.out.println("Ultimo indice: " + i);
                return i;
            }
        }
        return -1;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int cont = 0;
        if (estaVazio()) { System.out.println("A lista possui " + cont + " ocorrências!");
            return cont;
        } else {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null && this.lista[i].equals(elemento)) {
                cont += 1;
            }
        }
        }
        System.out.println("A lista possui " + cont + " ocorrências!");
        return cont;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int cont = 0;
        if (estaVazio()) {
            System.out.println("Total de: " + cont + "elementos substituídos.");
            return cont;
        } else {
        for (int i = 0; i < this.lista.length; i++) {
            if (this.lista[i] != null && this.lista[i].equals(antigo)) {
                this.lista[i] = novo;
                cont += 1;
            }
        }
        }
        System.out.println("Total de: " + cont + "elementos substituídos.");
        return cont;
    }
}
