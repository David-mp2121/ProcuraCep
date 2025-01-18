package br.com.davi.procuraCep.conexoes;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

import br.com.davi.procuraCep.modelos.Endereco;

public class ConsultaCep {

	

	
	

	public Endereco buscaEndereco(String cep) {
		Gson gson = new Gson();
		URI endereco = URI.create("http://viacep.com.br/ws/" +cep + "/json/");
		try {

			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			return gson.fromJson(response.body(), Endereco.class);
		} catch (Exception e) {
			throw new RuntimeException("Nao foi possivel se conectar com o servidor,  tente novamente mais tarde");
		}

	}
}
