package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {
	
	public static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		int opcao,numero,agencia,tipo,aniversario;
		String titular;
		float saldo, limite;
		
		//criando alguns Objetos Conta para alimentar a Collection listaContas
		System.out.println("\nCriar Contas\n");
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		
		
		while(true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
			           	   	+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			
			if(opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD +"\nBanco do Brasil com Z - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);	
			}
			
			switch(opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE +"Criar Conta\n");
				
				System.out.println("Digite o Número da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o Nome do Titular: ");
				leia.skip("\\R?"); // O Método skip ignora a entrada que corresponde ao padrão especificado. 
				                   //Estamos ignorando \r (quebra de linha) para permitir que o comando nextLine() leia palavras compostas.
				titular = leia.nextLine();
				
				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = leia.nextInt();
				} while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();
				
				switch(tipo) {
					case 1 -> {
						System.out.println("Digite o limite de Crédito (R$): ");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversário da Conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE +"Listar todas as Contas\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE +"Consultar dados da Conta - por número\n");
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE +"Atualizar dados da Conta\n");
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE +"Apagar a Conta\n");
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE +"Saque\n");
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE +"Depósito\n");
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE +"Transferência entre Contas\n");
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED +"\nOpção inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;		
			}
		}
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET+"\n\nPressione ENTER para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("\nVocê pressionou uma tecla diferente de Enter!");
		}
	}
}
