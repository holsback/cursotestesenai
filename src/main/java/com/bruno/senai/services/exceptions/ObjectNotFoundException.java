package com.bruno.senai.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	// Extender a biblioteca que extende o tratamento de erro
	private static final long serialVersionUID = 1L;
	
	//recebe a msm
	public ObjectNotFoundException(String msm) {
		super(msm);
	}
	
	//Recebe a msm e a causa.
	public ObjectNotFoundException(String msm, Throwable cause) {
		super(msm, cause);
	}
}
