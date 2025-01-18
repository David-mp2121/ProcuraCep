package br.com.davi.procuraCep.principal;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import com.google.gson.Gson;

import br.com.davi.procuraCep.conexoes.ConexaoApi;
import br.com.davi.procuraCep.exceptions.InvalidCepException;
import br.com.davi.procuraCep.modelos.Endereco;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner scann = new Scanner(System.in);

		String cep = null;

		while (true) {
			Endereco endereco = null;

			try {
				cep = perguntaCep();
				endereco = pesquisaCep(cep);
				System.out.println("Endereço procurado : " + endereco + "\n\n");

			} catch (InvalidCepException e) {
				System.out.println("O cep digitado na foi encontrado, tente novamente");
				e.getMessage();

			} catch (IOException | URISyntaxException | InterruptedException e) {

				System.out.println("Não foi possivel se conectar com a api, tente novamente mais tarde");
				System.out.println(e.getMessage());
			}

			int verificador = verificaSaida(scann);
			if (verificador == 2)
				break;

		}
		System.out.println("Programa finalizado");
	}

	private static int verificaSaida(Scanner scann) {
		int verificador = 0;
		while (true) {
			System.out.println("1 Para pesquisar outro CEP \n2 Para encerrar a aplicação");

			verificador = scann.nextInt();
			if (verificador == 1 || verificador == 2) {
				break;
			} else {
				System.out.println("Valor invalido .......");
			}
		}

		return verificador;
	}

	private static String perguntaCep() throws InvalidCepException {
		Scanner scann = new Scanner(System.in);
		System.out.println("================================");
		System.out.println("==--Digite um CEP para busca--==");
		System.out.println("================================");
		String cep = scann.nextLine();
		if (cep.isEmpty()) {
			throw new InvalidCepException("O cep digitado esta vazio");
		}

		return cep;
	}

	public static Endereco pesquisaCep(String cep)
			throws IOException, InterruptedException, URISyntaxException, InvalidCepException {
		Gson gson = new Gson();
		ConexaoApi conexao = new ConexaoApi(cep);
		String enderecoJson = conexao.getEnderecoJson();

		return gson.fromJson(enderecoJson, Endereco.class);

	}

}
