package conta.repository;

import conta.model.Conta;

public interface ContaRepository {
	
	//Assinamos os Métodos do CRUD (Create, Read, Update e Delete), dos Objetos das Classes ContaCorrente e ContaPoupanca.
	public void procuparPorNumero(int numero);
	public void listarTodas();
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void deletar(int numero);
	
	//Métodos de Operações Bancárias
	public void sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);
	
}
