package com.onibus.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.onibus.negocio.usuarios.Usuario;

public class UsuarioDAO {

	List<Usuario> usuarios = new ArrayList<Usuario>();

	public void inserir(Usuario usuario) {
		usuarios.add(usuario);

	}

	public Usuario buscar(String email) {
		Usuario usu = null;
		for (Usuario usuario : usuarios) {
			if (usuario.getEmail().equals(email)) {
				usu = usuario;
				break;
			}
		}
		return usu;
	}

}
