public class MainPilhaSimples {
    public static void main(String[] args) {
        PilhaSimples pilha = new PilhaSimples(4);
        pilha.empilhar("Arroz");
        pilha.empilhar("Feijão");
        pilha.empilhar("Macarrão");
        pilha.empilhar("Arroz");
        pilha.empilhar("Farinha");
        pilha.exibir();
        pilha.verTopo();
        pilha.tamanho();
        pilha.contem("Feijão");
        pilha.contem("Frango");
        pilha.contarOcorrencias("Arroz");
        pilha.desempilhar();
        pilha.desempilhar();
        pilha.exibir();
        pilha.limpar();
        pilha.desempilhar();
    }
}