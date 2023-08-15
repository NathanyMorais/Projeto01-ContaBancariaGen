package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository { //implementando a Interface ContaRepository na Classe ContaController
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>(); //Collection que irá armazenar os dados de todas as Contas, funcionando como um Banco de dados em Memória da nossa aplicação.
	int numero = 0;
	
	@Override
	public void procuparPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodas() {
		for(var conta : listaContas) { //var define o tipo da variável através do valor de inicialização da variável. Nesse caso, o var entende que a variável conta deve ser criada como um Objeto da Classe Conta
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta número: "+conta.getNumero()+" foi criada com sucesso!" );
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	public int gerarNumero() { //método auxiliar criado para retornar o número da conta todas as vezes que uma nova conta for cadastrada
		return ++ numero;//a variável numero foi inicializada com zero e vai incrementando de 1 em 1, a cada nova conta que for criada
	}

}
