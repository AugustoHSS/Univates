public class Pilha {
  private int maxLength;
  private int head;
  private int[] elements;

  public Pilha(int maxLength) {
    this.maxLength = maxLength;
    this.head = -1;
    this.elements = new int[maxLength];
  }

  public boolean isFull() {
    return head == maxLength - 1;
  }

  public boolean isEmpty() {
    return head == -1;
  }

  public void push(int elemento) {
    if (isFull()) {
      System.out.println("pilha cheia.");
      return;
    }
    elements[++head] = elemento;
  }

  public int pop() {
    if (isEmpty()) {
      System.out.println("pilha vazia.");
      return -1;
    }
    return elements[head--];
  }

  public void list() {
    if (isEmpty()) {
      System.out.println("pilha vazia.");
      return;
    }
    System.out.println("Elementos da pilha:");
    for (int i = head; i >= 0; i--) {
      System.out.println(elements[i]);
    }
  }
}