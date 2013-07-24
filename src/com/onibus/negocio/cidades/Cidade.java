package com.onibus.negocio.cidades;

import com.onibus.negocio.usuarios.Usuario;

public class Cidade {
	
	private int id;
	private String nome;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean igual = false;
		Cidade outra = (Cidade)obj;
		if (this.nome.equals(outra.getNome())) {
			if (this.id == outra.getId()) {
				igual = true;
			} else {
				igual = false;
			}
		}
		return igual;
	}
	
	

}
