package br.com.davi.procuraCep.conexoes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import br.com.davi.procuraCep.exceptions.InvalidCepException;

public class ConexaoApi {

	public String json = null;

	public ConexaoApi(String cep) throws IOException, InterruptedException, URISyntaxException, InvalidCepException {
		String url = "http://viacep.com.br/ws/"+cep+"/json/";
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).version(HttpClient.Version.HTTP_1_1).build();
		;
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		json = response.body();
		if (json.contains("logradouro")) {
		}else throw new InvalidCepException("Nao foi possivel se concetar com o url informado : "+url);
	}
	public String getEnderecoJson() {
		return this.json;
	}

}
