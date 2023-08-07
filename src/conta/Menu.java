package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leia = new Scanner(System.in);
		int opcao;
		
		while(true) {
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("              BANCO DO BRAZIL COM Z                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("\t\t1 - Criar Conta"
					+ "\n\t\t2 - Criar Conta"
					+ "\n\t\t1 - Listar todas as Contas"
					+ "\n\t\t3 - Buscar Conta por Número"
					+ "\n\t\t4 - Atualizar Dados da Conta"
					+ "\n\t\t5 - Apagar Conta"
					+ "\n\t\t6 - Sacar"
					+ "\n\t\t7 - Depositar"
					+ "\n\t\t8 - Transferir Valores entre Contas"
					+ "\n\t\t9 - Sair");
			System.out.println("\n*****************************************************");
			System.out.println("Entre com a opção desejada: ");
			System.out.println();
			
			opcao = leia.nextInt();
			
			if(opcao == 9) {
				System.out.println("\nBanco do Brasil com Z - O seu Futuro começa aqui!");
				leia.close();
				System.exit(0);	
			}
			switch(opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");
				break;
			case 6:
				System.out.println("Saque\n\n");
				break;
			case 7:
				System.out.println("Depósito\n\n");
				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");
				break;
			default:
				System.out.println("\nOpção inválida!\n");
				break;		
			}
		}
	}
}
