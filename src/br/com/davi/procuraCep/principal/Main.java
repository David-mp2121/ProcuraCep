package br.com.davi.procuraCep.principal;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import com.google.gson.JsonSyntaxException;
import com.google.gson.*;

import br.com.davi.procuraCep.conexoes.ConsultaCep;
import br.com.davi.procuraCep.exceptions.InvalidCepException;
import br.com.davi.procuraCep.modelos.Endereco;

public class Main {

	public static void main(String[] args) throws IOException, InvalidCepException {

		Scanner scann = new Scanner(System.in);
		ConsultaCep consultaCep = new ConsultaCep();

		while (true) {

			try {

				String cep = perguntaCep();
				Endereco endereco = consultaCep.buscaEndereco(cep);
				System.out.println("Endereço procurado : " + endereco + "\n\n");

			} catch ( InvalidCepException e ) {
				System.out.println( "erro "+e.getMessage());
			}
			catch ( RuntimeException g ){
				System.out.println(g.getMessage());
			}

			int verificador = verificaSaidaDoLoop(scann);
			if (verificador == 2)
				break;

		}
		System.out.println("Programa finalizado");
	}

	private static int verificaSaidaDoLoop(Scanner scann) {
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

}
