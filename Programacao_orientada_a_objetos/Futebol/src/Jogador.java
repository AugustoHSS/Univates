import java.util.List;

public class Jogador {
  private int codigo;
  private String nome;
  private String posicao;

  public Jogador(int codigo, String nome, String posicao) {
    this.codigo = codigo;
    this.nome = nome;
    this.posicao = posicao;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getPosicao() {
    return posicao;
  }

  public void setPosicao(String posicao) {
    this.posicao = posicao;
  }

}
