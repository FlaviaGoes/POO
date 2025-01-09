package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Relatorio {
	String titulo;
	String data;
	List<User> usuarios = new ArrayList<User>();
	
	public void addUser(User user) {
		usuarios.add(user);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<User> getUsuario() {
		return usuarios;
	}
	public void setUsuario(List<User> usuario) {
		this.usuarios = usuario;
	}
	
	
}
