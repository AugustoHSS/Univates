public class Minions {
  private int vida;
  private int dano;
  private int velocidadeMovimento;

  public void atacar() {
    System.out.println("Ataquei");
  }

  public void mover() {
    System.out.println("Movi");
  }

  public int getVida() {
    return vida;
  }

  public void setVida(int vida) {
    this.vida = vida;
  }

  public int getDano() {
    return dano;
  }

  public void setDano(int dano) {
    this.dano = dano;
  }

  public int getVelocidadeMovimento() {
    return velocidadeMovimento;
  }

  public void setVelocidadeMovimento(int velocidadeMovimento) {
    this.velocidadeMovimento = velocidadeMovimento;
  }

}
