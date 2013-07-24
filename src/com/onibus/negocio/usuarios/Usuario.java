package com.onibus.negocio.usuarios;

import com.onibus.negocio.cidades.Cidade;

public class Usuario {

	private String email;
	private Cidade cidade;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public boolean equals(Object obj) {
		boolean igual = false;
		Usuario outro = (Usuario)obj;
		if (this.email.equals(outro.getEmail())) {
			if (this.getCidade().equals(outro.getCidade())) {
				igual = true;
			} else {
				igual = false;
			}
		}
		return igual;
	}

	
}
