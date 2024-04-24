import java.util.List;

public class Champion {
  private String nome;
  private int nivel;
  private int vida;
  private int mana;
  private List<String> habilidades;

  public void atacar() {
    System.out.println("ataquei");
  }

  public void usarHabilidade() {
    System.out.println("usei");
  }

  public void mover() {
    System.out.println("mover");
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getNivel() {
    return nivel;
  }

  public void setNivel(int nivel) {
    this.nivel = nivel;
  }

  public int getVida() {
    return vida;
  }

  public void setVida(int vida) {
    this.vida = vida;
  }

  public int getMana() {
    return mana;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public List<String> getHabilidades() {
    return habilidades;
  }

  public void setHabilidades(List<String> habilidades) {
    this.habilidades = habilidades;
  }

}