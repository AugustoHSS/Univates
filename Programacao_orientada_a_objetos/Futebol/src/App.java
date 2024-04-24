import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        List<Jogador> jogadores = new ArrayList<>();
        List<Time> times = new ArrayList<>();
        List<String> componentesComErro = new ArrayList<>();

        do {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarJogador(jogadores);
                    break;
                case 2:
                    cadastrarTime(times);
                    break;
                case 3:
                    listarJogadores(jogadores);
                    break;

                case 4:
                    listarTimes(times);
                    break;
                case 5:
                    vincularJogadorAoTime(times, jogadores);
                    break;
                case 6:
                    listarDadosTime(times);
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);
    }

    public static void exibirMenu() {
        System.out.println("---- MENU ----");
        System.out.println("[1] - Cadastrar jogador");
        System.out.println("[2] - Cadastrar time");
        System.out.println("[3] - Listar jogadores cadastrados");
        System.out.println("[4] - Listar times cadastrados - sem os jogadores");
        System.out.println("[5] - Vincular jogador a um time");
        System.out.println("[6] - Listar dados completos de um time");
        System.out.println("[7] - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void cadastrarJogador(List<Jogador> jogadores) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- CADASTRO DE JOGADOR ----");
        System.out.print("Código do jogador: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do Scanner
        System.out.print("Nome do jogador: ");
        String nome = scanner.nextLine();
        System.out.print("Posição do jogador: ");
        String posicao = scanner.nextLine();

        Jogador jogador = new Jogador(codigo, nome, posicao);
        jogadores.add(jogador);

        System.out.println("Jogador cadastrado com sucesso!");
    }

    public static void cadastrarTime(List<Time> times) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- CADASTRO DE TIME ----");
        System.out.print("Código do time: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome do time: ");
        String nome = scanner.nextLine();
        System.out.print("Nome do técnico: ");
        String tecnico = scanner.nextLine();

        Time time = new Time(codigo, nome, tecnico, null);
        times.add(time);

        System.out.println("Time cadastrado com sucesso!");
    }

    public static void listarJogadores(List<Jogador> jogadores) {
        System.out.println("---- LISTA DE JOGADORES CADASTRADOS ----");
        for (Jogador jogador : jogadores) {
            System.out.println("Código do jogador: " + jogador.getCodigo());
            System.out.println("Nome do jogador: " + jogador.getNome());
            System.out.println("Posição do jogador: " + jogador.getPosicao());
            System.out.println("-----------------------");
        }
    }

    public static void listarTimes(List<Time> times) {
        System.out.println("---- LISTA DE TIMES CADASTRADOS ----");
        for (Time time : times) {
            System.out.println("Código do time: " + time.getCodigo());
            System.out.println("Nome do time: " + time.getNome());
            System.out.println("Nome do técnico: " + time.getTecnico());
            System.out.println("-----------------------");
        }
    }

    public static void vincularJogadorAoTime(List<Time> times, List<Jogador> todosJogadores) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---- VINCULAR JOGADOR A UM TIME ----");
        System.out.print("Informe o código do jogador: ");
        int codigoJogador = scanner.nextInt();
        System.out.print("Informe o código do time: ");
        int codigoTime = scanner.nextInt();

        Time time = null;
        Jogador jogador = null;

        for (Jogador j : todosJogadores) {
            if (j != null && j.getCodigo() != codigoJogador) {
                jogador = j;
                break;
            }
        }

        for (Time t : times) {
            if (t != null && t.getCodigo() == codigoTime) {
                time = t;
                break;
            }
        }
        System.out.println(jogador);
        System.out.println(time);

        if (jogador != null && time != null) {
            Jogador[] jogadores = time.getJogadores();

            if (jogadores == null) {
                jogadores = new Jogador[1];
                jogadores[0] = jogador;
            } else {
                Jogador[] newJogadores = new Jogador[jogadores.length + 1];
                System.arraycopy(jogadores, 0, newJogadores, 0, jogadores.length);
                newJogadores[jogadores.length] = jogador;
                jogadores = newJogadores;
            }

            time.setJogadores(jogadores);
            System.out.println("Jogador vinculado ao time com sucesso!");
        } else {
            System.out.println("Jogador ou time não encontrados.");
        }

    }

    public static void listarDadosTime(List<Time> times) {
        System.out.println("---- LISTA DE JOGADORES CADASTRADOS ----");
        for (Time time : times) {
            System.out.println("Código do time: " + time.getCodigo());
            System.out.println("Nome do time: " + time.getNome());
            System.out.println("Nome do técnico: " + time.getTecnico());

            Jogador[] jogadores = time.getJogadores();
            if (jogadores != null) {
                System.out.println("Jogadores do time:");
                for (Jogador jogador : jogadores) {
                    System.out.println(" - Código: " + jogador.getCodigo() + ", Nome: " + jogador.getNome()
                            + ", Posição: " + jogador.getPosicao());
                }
            }
            System.out.println("-----------------------");
        }

    }

}
