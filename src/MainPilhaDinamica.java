public class MainPilhaDinamica {
    public static void main(String[] args) {
        PilhaDinamica pilha = new PilhaDinamica();
        pilha.empilhar("Azul");
        pilha.empilhar("Verde");
        pilha.empilhar("Amarelo");
        pilha.empilhar("Azul");
        pilha.exibirElementos();
        pilha.verTopo();
        pilha.tamanho();
        pilha.contem("Verde");
        pilha.contem("Roxo");
        pilha.contarOcorrencias("Azul");
        pilha.desempilhar();
        pilha.desempilhar();
        pilha.exibirElementos();
        pilha.limpar();
        pilha.desempilhar();
        pilha.empilhar("Rosa");
        pilha.exibirElementos();
    }
}