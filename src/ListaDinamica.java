public class ListaDinamica implements ListaOperacoes{
    No inicio;

    public ListaDinamica() {
        this.inicio = new No(null);
        System.out.println("Lista Dinâmica criada com sucesso!");
    }

    public void adicionarElemento(String conteudo) {
        if(!this.existeInicio()) {
            this.inicio.setConteudo(conteudo);
        } else {
            No novoNo = new No(conteudo);
            No aux = this.inicio;
            while(aux.getProx() != null) {
                aux = aux.getProx();
            }
            aux.setProx(novoNo);
        }
    }

    private boolean existeInicio() {
        if(this.inicio.getConteudo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public void exibirElementos() {
        if(existeInicio()) {
            No aux = this.inicio;
            while(aux.getProx() != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
            System.out.println(aux.getConteudo());
        } else {
            System.out.println("Não existem elementos na Lista Dinâmica.");
        }
    }

    public void removerElemento(String elemento) {
        if(existeInicio()) {
            if(buscarElemento(elemento)) {
                //removendo primeiro
                if(this.inicio.getConteudo().equals(elemento)) {
                    this.inicio = this.inicio.getProx();
                } else if(this.inicio.getProx() != null) {
                    No aux = this.inicio;
                    do {
                        if(aux.getProx().getConteudo().equals(elemento)) {
                            aux.setProx(aux.getProx().getProx());
                            return;
                        }
                        aux = aux.getProx();
                    } while (aux != null);
                } else {
                    this.inicio.setConteudo(null);
                }

                //removendo intermediário
                //método de busca
            }

        } else {
            System.out.println("Não existem elementos na lista.");
        }
    }

    public boolean buscarElemento(String elemento) {
        No aux = this.inicio;

        do {
            if(aux.getConteudo().equals(elemento)) {
                System.out.println("Elemento " + elemento + " encontrado.");
                return true;
            }
            aux = aux.getProx();
        } while(aux != null);
        System.out.println("Elemento " + elemento + " não encontrado!");
        return false;
    }

    @Override
    public int removerTodas(String elemento) {
        int removidos = 0;
        while (existeInicio() && this.inicio.getConteudo().equals(elemento)) {
            if(this.inicio.getProx() != null) {
                this.inicio = this.inicio.getProx();
            } else {
                limpar();
            }
            removidos++;
        }
        No aux = this.inicio;
        while (aux != null && aux.getProx() != null) {
            if (aux.getProx().getConteudo().equals(elemento)) {
                aux.setProx(aux.getProx().getProx());
                removidos++;
            } else {
                aux =  aux.getProx();
            }
        }
        System.out.println("Foram removidos" +  removidos);
        return removidos;
    }

    @Override
    public int contar() {
        int cont = 0;
        if(existeInicio()) {
            No aux = this.inicio;
            while (aux != null) {
                cont++;
                aux = aux.getProx();
            }
        }
        return cont;
    }

    @Override
    public int adicionarVarios(String[] elementos) {
        int cont = 0;
        for (int i = 0; i < elementos.length; i++) {
            this.adicionarElemento(elementos[i]);
            cont++;
        }
        return cont;
    }

    @Override
    public String obter(int indice) {
        int cont = 0;
        if (!existeInicio() && indice < 0) {
            return null;
        } else {
            No aux = this.inicio;
            while (aux != null && cont < indice) {
                cont++;
                aux = aux.getProx();
            }
            if (aux == null) {
                System.out.println("Não existem elementos na lista.");
                return null;
            } else {
                System.out.println("Elemento " + aux.getConteudo());
                return aux.getConteudo();
            }
        }
    }

    @Override
    public boolean inserir(int indice, String elemento) {
        if (indice < 0) return false;

        No novo = new No(elemento);

        if (indice == 0) {
            novo.setProx(inicio);
            inicio = novo;
            return true;
        }

        No aux = inicio;
        for (int i = 0; i < indice - 1 && aux != null; i++) {
            aux = aux.getProx();
        }

        if (aux != null) {
            novo.setProx(aux.getProx());
            aux.setProx(novo);
            return true;
        }

        return false;
    }

    @Override
    public String removerPorIndice(int indice) {
        if (!existeInicio() || indice < 0) {
            return null;
        }

        if (indice == 0) {
            String removido = this.inicio.getConteudo();
            if (this.inicio.getProx() != null) {
                this.inicio = this.inicio.getProx();
            } else {
                limpar();
            }
            return removido;
        }

        No aux = this.inicio;
        int cont = 0;

        while (aux != null && aux.getProx() != null && cont < (indice - 1)) {
            aux = aux.getProx();
            cont++;
        }

        if (aux != null && aux.getProx() != null) {
            String removido = aux.getProx().getConteudo();
            aux.setProx(aux.getProx().getProx());
            return removido;
        }

        return null;
    }

    @Override
    public void limpar() {
        this.inicio.setConteudo(null);
        this.inicio.setProx(null);
    }

    @Override
    public int ultimoIndiceDe(String elemento) {
        int indiceAtual = 0;
        int ultimoIndice= -1;
        if(!existeInicio()) {
            return -1;
        } else {
            No aux = this.inicio;
            while(aux != null) {
                if(aux.getConteudo().equals(elemento)) {
                    ultimoIndice = indiceAtual;
                }
                indiceAtual++;
                aux = aux.getProx();
            }
        }
        System.out.println("Ultimo indice: " + ultimoIndice);
        return ultimoIndice;
    }

    @Override
    public int contarOcorrencias(String elemento) {
        int cont = 0;
        if(!existeInicio()) {
            return 0;
        }  else {
            No aux = this.inicio;
            while (aux != null) {
                if(aux.getConteudo().equals(elemento)) {
                    cont += 1;
                }
                aux = aux.getProx();
            }
        }
        System.out.println("Total de ocorrencias: " + cont);
        return cont;
    }

    @Override
    public int substituir(String antigo, String novo) {
        int cont = 0;
        if(!existeInicio()) {
            return 0;
        } else {
            No aux = this.inicio;
            while (aux != null) {
                if (aux.getConteudo().equals(antigo)) {
                    aux.setConteudo(novo);
                    cont++;
                }
                aux = aux.getProx();
            }
        }
        return cont;
    }
}
