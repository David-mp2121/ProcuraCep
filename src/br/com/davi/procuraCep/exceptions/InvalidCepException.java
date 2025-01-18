package br.com.davi.procuraCep.exceptions;

public class InvalidCepException extends Exception {
	String message;

	public InvalidCepException(String string) {
		this.message = string;
	}

}
