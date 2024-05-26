package com.mycompany.projetointegrador;
import java.util.Scanner;

public class ProjetoIntegrador {

    static String[] tipoFerramenta = new String[3];
    static String[] objetos = new String[3];
    static String[][] clientes = new String[3][3];
    public static void main(String[] args) {
        inicializaVetores();
        menu();
    }
    
    static void inicializaVetores() {
        int i;
        int j;
        
        for (i = 0; i < 3; i++) {
            tipoFerramenta[i] = "";
            objetos[i] = "";
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                clientes[i][j] = "";
            }
        }
    }
    
    static void menu() {
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\n\nSistema de Controle de Ferramentas");
            System.out.println("1 - Cadastro de Clientes");
            System.out.println("2 - Cadastro de Tipos");
            System.out.println("3 - Cadastro de Objetos");
            //System.out.println("4 - Manutenções");
            System.out.println("0 - Sair\n");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: {
                    clientes();
                    break;
                }
                case 2: {
                    tipos();
                    break;
                }
                case 3: {
                    objetos();
                    break;
                }
                case 4: {
                    //manutencoes();
                    break;
                }
                case 0: {
                    System.out.println("Saindo");
                    System.exit(0);
                }
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }
        
        
    static int verificaPosicaoLivreNoVetor(String vetor[]) {
        int i = 0;
        int posicaoLivreNoVetor = -1;
        while (i < vetor.length) {
            if ("".equals(vetor[i])) {
                posicaoLivreNoVetor = i;
                i = vetor.length;
            }
            i++;
        }
        return posicaoLivreNoVetor;
    }
    
    static int verificaPosicaoLivreNaMatriz(String matriz[][]) { 
        int i = 0;
        int posicaoLivreNaMatriz = -1;
        while (i < matriz.length) {
            if (matriz[i][0] == "") {
                    
                posicaoLivreNaMatriz = i;
                i = matriz.length;
            }
            i++;
        }
        return posicaoLivreNaMatriz;
    }
    
    static void tipos() {
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        int pos;
        do {
            System.out.println("\nCadastro de Tipos de Ferramentas");
            System.out.println(" 1 - Cadastrar");
            System.out.println(" 2 - Alterar");
            System.out.println(" 3 - Excluir");
            System.out.println(" 4 - Listar");
            System.out.println(" 0 - Sair");
            System.out.println("\n");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: {
                    System.out.println("\nCadastro");
                    pos = verificaPosicaoLivreNoVetor(tipoFerramenta);
                    if (pos == -1) {
                        System.out.println("Não há posições livres no vetor de tipos");
                    } else {
                        System.out.println("Informe o tipo de ferramenta");
                        scanner.nextLine();
                        tipoFerramenta[pos] = scanner.nextLine();
                        System.out.println("=> Tipo cadastrado com sucesso! <=");
                    }
                    break;
                }
                case 2: {
                    System.out.println("\nAlterar");
                    System.out.println("Existem estes tipos de ferramentas cadastradas:");
                    System.out.println("Cód.   Tipo");
                    int i;
                    for (i = 0; i < tipoFerramenta.length; i++) {
                        System.out.println(i + "   -    " + tipoFerramenta[i]);
                    }
                    System.out.print("Informe o código para ser alterado: ");
                    pos = scanner.nextInt();
                    if(tipoFerramenta[pos] == ""){
                        System.out.print("\nVocê nao pode alterar um tipo que nao existe!\n");
                        break;
                    }
                    System.out.print("Informe o novo nome para " + tipoFerramenta[pos] + ": ");
                    tipoFerramenta[pos] =  scanner.next();
                    System.out.println("Alteração efetuada com sucesso!");
                    break;
                }
                case 3: {
                    System.out.println("\nExcluir");
                    System.out.println("Existem estes tipos de ferramentas cadastradas:");
                    System.out.println("Cód.   Tipo");
                    int i;
                    for (i = 0; i < tipoFerramenta.length; i++) {
                        System.out.println(i + "   -    " + tipoFerramenta[i]);
                    }
                    System.out.println("Informe o código para ser excluido: ");
                    pos = scanner.nextInt();
                    tipoFerramenta[pos] = "";
                    System.out.println("Exclusão efetuada com sucesso!");
                    break;
                }
                case 4: {
                    System.out.println("Existem estes tipos de ferramentas cadastradas:");
                    System.out.println("Cód.   Tipo");
                    int i;
                    for (i = 0; i < tipoFerramenta.length; i++) {
                        System.out.println(i + "   -    " + tipoFerramenta[i]);
                    }            
                    break;
                }

                case 0: {
                }
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
    
    static void clientes() {
        int opcao = 0;
        int linha;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nCadastro de Clientes");
            System.out.println(" 1 - Cadastrar");
            System.out.println(" 2 - Alterar");
            System.out.println(" 3 - Excluir");
            System.out.println(" 4 - Listar");
            System.out.println(" 0 - Sair");

            opcao = scanner.nextInt();
            System.out.print("\n");

            switch (opcao) {
                case 1: {
                    System.out.println("\nCadastro");
                    linha = verificaPosicaoLivreNaMatriz(clientes);
                    if (linha == -1) {
                        System.out.println("Não há posições livres na matriz de clientes");
                    } else {
                        System.out.print("Nome: ");
                        clientes[linha][0] = scanner.next();
                        System.out.print("E-mail: ");
                        clientes[linha][1] = scanner.next();
                        System.out.print("Cidade: ");
                        clientes[linha][2] = scanner.next();
                        System.out.println("Cliente cadastrado com sucesso!");
                    }
                    break;
                }
                case 2: {
                    System.out.println("\nAlterar");
                    System.out.println("Existem estes clientes cadastrados:");
                    System.out.println("Cód.   Nome           Email          Cidade");
                    int i;
                    int j;
                    for (i = 0; i < clientes.length; i++) {
                        System.out.print(i);
                        for (j = 0; j < clientes.length; j++) {
                            System.out.print("       " + clientes[i][j]);
                        }
                        System.out.println("");
                    }
                    System.out.println("Informe o codigo para ser alterado: ");
                    linha = scanner.nextInt();
                    if(clientes[linha][0] == ""){
                        System.out.println("Cliente "+ linha +" nao existe!");
                        break;
                    }
                    System.out.println("Informe o novo nome");
                    clientes[linha][0] = scanner.next();
                    System.out.println("Informe o novo e-mail");
                    clientes[linha][1] = scanner.next();
                    System.out.println("Informe a nova cidade");
                    clientes[linha][2] = scanner.next();
                    System.out.println("Cliente alterado com sucesso!");
                    break;
                }
                case 3: {
                    System.out.println("\nExcluir");
                    System.out.println("Existem estes clientes cadastrados:");
                    System.out.println("Cód.   Nome           Email          Cidade");
                    int i;
                    int j;
                    for (i = 0; i < clientes.length; i++) {
                        System.out.print(i);
                        for (j = 0; j < clientes.length; j++) {
                            System.out.print("       " + clientes[i][j]);
                        }
                        System.out.println("");
                    }
                    System.out.println("Informe o código para ser excluído: ");
                    linha = scanner.nextInt();                 
                    if(clientes[linha][0] == ""){
                        System.out.println("Cliente "+ linha +" nao existe!");
                        break;
                    }
                    
                    clientes[linha][0] = "";
                    clientes[linha][1] = "";
                    clientes[linha][2] = "";
                    System.out.println("Exclusão efetuada com sucesso!");
                    break;
                }
                case 4: {
                    System.out.println("Existem estes clientes cadastrados:");
                    System.out.println("Cód.   Nome           Email          Cidade");
                    int i;
                    int j;
                    for (i = 0; i < clientes.length; i++) {
                        System.out.print(i);
                        for (j = 0; j < clientes.length; j++) {
                            System.out.print("       " + clientes[i][j]);
                        }
                        System.out.println("");
                    }
                    break;
                }
                case 0: {
                    System.out.println("Saindo");
                    System.exit(0);
                }
                default:
                    System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);
    }
    
    
    static void objetos() {
       int opcao = 0;
       Scanner scanner = new Scanner(System.in);

       do {
           System.out.println("\nCadastro de Objetos");
           System.out.println(" 1 - Cadastrar");
           System.out.println(" 2 - Alterar");
           System.out.println(" 3 - Excluir");
           System.out.println(" 4 - Listar");
           System.out.println(" 0 - Sair");

           opcao = scanner.nextInt();
           System.out.print("\n");

           switch (opcao) {
               case 1: {
                   System.out.println("\nCadastrar Objeto");
                   int pos = verificaPosicaoLivreNoVetor(objetos);
                   if (pos == -1) {
                       System.out.println("Não há posições livres no vetor de objetos.");
                   } else {
                       System.out.print("Informe o nome do objeto: ");
                       scanner.nextLine();
                       objetos[pos] = scanner.nextLine();
                       System.out.println("Objeto cadastrado com sucesso!");
                   }
                   break;
               }
               case 2: {
                   System.out.println("\nAlterar Objeto");
                   
                   System.out.println("Existem estes tipos de objetos cadastradas:");
                    System.out.println("Cód.   objeto");
                    int i;
                    for (i = 0; i < objetos.length; i++) {
                        System.out.println(i + "   -    " + objetos[i]);
                    }
                   
                   
                   System.out.print("Informe o código do objeto a ser editado: ");
                   int codigo = scanner.nextInt();
                   if (codigo >= 0 && codigo < objetos.length) {
                       if (!"".equals(objetos[codigo])) {
                           System.out.print("Informe o novo nome para o objeto: ");
                           scanner.nextLine();
                           objetos[codigo] = scanner.nextLine();
                           System.out.println("Objeto editado com sucesso!");
                       } else {
                           System.out.println("Você nao pode alterar um objeto que nao existe!.");
                       }
                   } else {
                       System.out.println("Código inválido.");
                   }
                   break;
               }
               case 3: {
                   System.out.println("\nExcluir Objeto");
                   System.out.print("Informe o código do objeto a ser excluído: ");
                   
                    System.out.println("Existem estes tipos de objetos cadastradas:");
                    System.out.println("Cód.   objeto");
                    int i;
                    for (i = 0; i < objetos.length; i++) {
                        System.out.println(i + "   -    " + objetos[i]);
                    }
                   
                   int codigo = scanner.nextInt();
                   if (codigo >= 0 && codigo < objetos.length) {
                       if (!"".equals(objetos[codigo])) {
                           objetos[codigo] = "";
                           System.out.println("Objeto excluído com sucesso!");
                       } else {
                           System.out.println("Você nao pode excluir um objeto que nao existe!");
                       }
                   } else {
                       System.out.println("Código inválido.");
                   }
                   break;
               }
              case 4: {
                   System.out.println("\nListar Objeto");
                   System.out.println("Lista de Objetos Cadastrados:");
                   for (int i = 0; i < objetos.length; i++) {
                       if (!"".equals(objetos[i])) {
                           System.out.println(i + " - " + objetos[i]);
                       }
                   }
                   break;
               }
               case 0: {
                   System.out.println("Saindo");
                   System.exit(0);
               }
               default:
                   System.out.println("Opção Inválida!");
           }
       } while (opcao != 0);
    }
    
}
