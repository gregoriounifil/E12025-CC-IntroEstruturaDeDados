public class Main {
    public static void main(String[] args) {
        ListaSimples listaSimples = new ListaSimples(5);
        ListaDinamica listaDinamica = new ListaDinamica();
        listaSimples.exibirElementos();
        listaSimples.adicionarElemento("Arroz");
        listaSimples.adicionarElemento("Feijão");
        listaSimples.adicionarElemento("Batata");
        listaSimples.adicionarElemento("Arroz2");
        listaSimples.adicionarElemento("Feijão2");
        listaSimples.removerElemento("Batata");
        listaSimples.quantidadeElementos();
        listaSimples.exibirElementos();
        listaSimples.buscarElemento("Batata");
        listaSimples.removerTodas("Feijão");
        listaSimples.exibirElementos();
        listaSimples.removerPorIndice(0);
        listaSimples.exibirElementos();
        listaDinamica.exibirElementos();
        listaDinamica.adicionarElemento("Arroz");
        listaDinamica.adicionarElemento("Feijão");
        listaDinamica.adicionarElemento("Batata");
        listaDinamica.adicionarElemento("Arroz2");
        listaDinamica.adicionarElemento("Feijão2");
        listaDinamica.removerElemento("Batata");
        listaDinamica.exibirElementos();
        listaDinamica.buscarElemento("Batata");
        listaDinamica.removerTodas("Feijão");
        listaDinamica.exibirElementos();
        listaDinamica.removerPorIndice(0);
        listaDinamica.exibirElementos();
    }
}