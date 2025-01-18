package br.com.davi.procuraCep.modelos;

import com.google.gson.annotations.SerializedName;

public class Endereco {

	@SerializedName("cep")
	public String cep;
	
	@SerializedName("logradouro")
	public String logradouro;
	
	@SerializedName("bairro")
	public String bairro;
	
	@SerializedName("localidade")
	public String cidade;
	
	@SerializedName("uf")
	public String estado;
	
	@SerializedName("regiao")
	public String regiao;
	
	@SerializedName("ddd")
	public String ddd;
	
	
	
	
	@Override
	public String toString() {
	
	
		String endereco = "CEP :"+this.cep +" || "+ this.logradouro +" - " +" || "+ this.bairro+" " + this.estado+"-"+this.cidade;
		
		
		
		return endereco;
	}

}
