import java.util.List;

public class Time {
  private int codigo;
  private String nome;
  private String tecnico;
  private Jogador[] jogadores;

  public Time(int codigo, String nome, String tecnico, Jogador[] jogadores) {
    this.codigo = codigo;
    this.nome = nome;
    this.tecnico = tecnico;
    this.jogadores = jogadores;
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

  public String getTecnico() {
    return tecnico;
  }

  public void setTecnico(String tecnico) {
    this.tecnico = tecnico;
  }

  public Jogador[] getJogadores() {
    return jogadores;
  }

  public void setJogadores(Jogador[] jogadores) {
    this.jogadores = jogadores;
  }

}
