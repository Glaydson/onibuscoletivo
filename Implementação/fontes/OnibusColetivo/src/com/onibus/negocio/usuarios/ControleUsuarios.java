package com.onibus.negocio.usuarios;

import com.onibus.negocio.cidades.Cidade;
import com.onibus.persistencia.UsuarioDAO;

public class ControleUsuarios {

	UsuarioDAO dao = new UsuarioDAO();

	public void cadastrarUsuarioSimples(String email, Cidade cidade)
			throws Exception {
		Usuario usuario = new Usuario();
		// validar os dados
		if (email.equals("") || cidade == null) {
			throw new Exception("Campos inválidos.");
		}

		Usuario usu = dao.buscar(email);
		if (usu == null) {
			usuario.setCidade(cidade);
			usuario.setEmail(email);
			dao.inserir(usuario);
		} else {
			throw new Exception("Usuãrio já existente");
		}

	}

	public Usuario buscarUsuario(String email) throws Exception {
		Usuario usuario = dao.buscar(email);
		if (usuario != null) {
			return usuario;
		} else {
			throw new Exception("Usuãrio não encontrado");
		}
	}

	public void cadastrarUsuarioSimples(Usuario usuario) {
		dao.inserir(usuario);

	}

}
