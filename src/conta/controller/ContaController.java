package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.ContaRepository;

public class ContaController implements ContaRepository { //implementando a Interface ContaRepository na Classe ContaController
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>(); //Collection que irá armazenar os dados de todas as Contas, funcionando como um Banco de dados em Memória da nossa aplicação.
	int numero = 0;
	
	@Override
	public void procuparPorNumero(int numero) {
		var conta = buscarNaCollection(numero);// Por inferência, a palavra reservada var entende que a variável conta deve ser um Objeto da Classe Conta.
		if(conta != null)
			conta.visualizar();
		else
			System.out.println("\nA Conta número: "+numero+" não foi encontrada!");
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
	public void atualizar(Conta conta) {//O parâmetro 'conta' é um objeto da Classe Conta que terá os seus dados atualizados na Collection listaContas.
		var buscaConta = buscarNaCollection(conta.getNumero());
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\nA Conta número: "+conta.getNumero()+" foi atualizada com sucesso!");
			//listaContas.indexOf(buscaConta): Método que identifica o índice (posição) do Objeto conta encontrado na Collection listaContas, ou seja, os dados atuais.
			//conta: O Objeto conta, que foi enviado como parâmetro do Método (dados obtidos via teclado), onde estão os novos dados da conta, que substituirão os dados atuais.
		}else 
			System.out.println("\nA Conta número "+conta.getNumero()+" não foi encontrada!");	
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			if(listaContas.remove(conta) == true) //Se a conta foi encontrada, o Objeto conta será apagado na Collection listaContas através do Método remove(). 
				System.out.println("\nA Conta número: "+numero+" foi deletada com sucesso!");
		}else 
			System.out.println("\nA Conta número: "+numero+" não foi encontrada!");
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
	
	//métodos auxiliares
	
	public int gerarNumero() { //método criado para retornar o número da conta todas as vezes que uma nova conta for cadastrada
		return ++ numero;//a variável numero foi inicializada com zero e vai incrementando de 1 em 1, a cada nova conta que for criada
	}
	
	public Conta buscarNaCollection(int numero) { //método para localizar uma conta através do número (o número que é gerado automaticamente toda vez que uma nova conta é criada)
		for (var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	
	public int retornaTipo(int numero) {//método para retornar o tipo da conta (se é corrente ou poupança) que será atualizada
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta.getTipo();
			}
		}
		return 0;
	}

}
