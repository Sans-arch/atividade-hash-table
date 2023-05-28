package catolica.negreira.santiago;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void exibirMenu() {
        System.out.println("Menu");
        System.out.println("1 - Cadastrar funcionário");
        System.out.println("2 - Conceder aumento percentual para todos os funcionários");
        System.out.println("3 - Consultar a soma salarial dos funcionários com salário superior a 500");
        System.out.println("4 - Consultar todos os funcionários");
        System.out.println("5 - Excluir por nome");
        System.out.println("6 - Sair");
    }

    public static void main(String[] args) {
        HashTable tabela = new HashTable(20);
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            exibirMenu();
            System.out.print("Digite a opção desejada: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1": {
                    System.out.print("Digite o nome do funcionário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o salário do funcionário: ");
                    double salario = Double.parseDouble(scanner.nextLine());
                    Funcionario funcionario = new Funcionario(nome, salario);
                    tabela.cadastrarFuncionario(funcionario);
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;
                }
                case "2":
                    System.out.print("Digite o percentual de aumento: ");
                    double percentual = Double.parseDouble(scanner.nextLine());
                    tabela.concederAumento(percentual);
                    System.out.println("Aumento concedido para todos os funcionários.");
                    break;
                case "3":
                    double soma = tabela.consultarSomaSalarial();
                    System.out.println("A soma salarial dos funcionários com salário superior a 500 é: " + soma);
                    break;
                case "4":
                    List<Funcionario> funcionarios = tabela.consultarFuncionarios();
                    System.out.println("Funcionários cadastrados:");
                    for (Funcionario funcionario : funcionarios) {
                        System.out.println("Nome: " + funcionario.getNome() + "\nSalário: R$" + String.format(
                                "%.2f", funcionario.getSalario()));
                    }
                    break;
                case "5": {
                    System.out.print("Digite o nome do funcionário a ser excluído: ");
                    String nome = scanner.nextLine();
                    tabela.excluirPorNome(nome);
                    System.out.println("Funcionário " + nome + " excluído.");
                    break;
                }
                case "6":
                    System.out.println("Saindo do programa...");
                    break label;
                default:
                    System.out.println("Opção inválida. Por favor, digite uma opção válida.");
                    break;
            }
        }
        scanner.close();
    }
}