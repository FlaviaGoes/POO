package com.example.demo;

public class calculadora {
	Dados dados;
	
	public void setDados(Dados dados) {
		this.dados = dados;
	}
	
	public Dados getDados() {
		return dados;
	}
	
	public void calcular() {
		if(dados.getOperacao().equals("somar")) {
			dados.setResultado(dados.getA()+dados.getB());
		}
	}
	
}
