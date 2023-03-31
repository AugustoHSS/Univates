public class App {
    public static void main(String[] args) {

        Pilha pilha = new Pilha(3);
        pilha.push(2);
        pilha.push(4);
        pilha.push(3);
        pilha.list();
        pilha.pop();
        pilha.list();
    }
}
