import entities.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class App {


    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        Gerenciador gerenciador = new Gerenciador();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(java.time.format.ResolverStyle.STRICT);
 
        String opcao;
        do {
            System.out.println("\nFILA DE ATENDIMENTO");
            System.out.println("1 - Cadastrar pessoa na fila");
            System.out.println("2 - Chamar próximo");
            System.out.println("3 - Listar fila");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
 
            opcao = teclado.nextLine();
 
            switch (opcao) {
                case "1":
                    System.out.print("Nome: ");
                    String nome = teclado.nextLine();
                    System.out.print("CPF: ");
                    String cpf = teclado.nextLine();
                

                    System.out.print("Telefone: ");
                    String telefone = teclado.nextLine();
                    System.out.print("Data de nascimento (dd/mm/aaaa): ");
                    String dataTexto = teclado.nextLine();
 
                    LocalDate data = null;

                    while (data == null) {
                        System.out.print("Data de nascimento (dd/mm/aaaa): ");
                        dataTexto = teclado.nextLine();

                        try {
                            data = LocalDate.parse(dataTexto, formato);
                        } catch (DateTimeParseException e) {
                        System.out.println("Data inválida! Use o formato dd/mm/aaaa, por exemplo 10/05/1990.");
                        }
                    }

                    System.out.println(gerenciador.cadastrarPessoa(nome, cpf, telefone, data));
                    break;
 
                case "2":
                    Pessoa proxima = gerenciador.chamarProximo();
                    if (proxima == null) {
                        System.out.println("Fila vazia!");
                    } else {
                        System.out.println("Chamando: " + proxima);
                    }
                    break;
 
                case "3":
                    System.out.println(gerenciador.listarFila());
                    break;
 
                case "0":
                    System.out.println("Encerrando...");
                    break;
 
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != "0");
 
        teclado.close();
    }     
}

