package com.sgc.model.entity;

import com.sgc.model.BaseEntity;

public class Usuario extends BaseEntity{

	private String nome;
	
	private String usuario;
	
	private String password;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", usuario=" + usuario + ", password="
				+ password + "]";
	}
	
}
