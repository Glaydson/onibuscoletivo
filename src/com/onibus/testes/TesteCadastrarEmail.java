package com.onibus.testes;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.onibus.negocio.cidades.Cidade;
import com.onibus.negocio.usuarios.ControleUsuarios;
import com.onibus.negocio.usuarios.Usuario;
import com.sun.net.httpserver.Authenticator.Success;

public class TesteCadastrarEmail {

	ControleUsuarios cUsuarios = new ControleUsuarios();
	
	@Before
	public void setUp() throws Exception {

		Usuario usuario1 = new Usuario();
		Cidade cidade1 = new Cidade();
		cidade1.setId(1);
		cidade1.setNome("Fortaleza");
		usuario1.setEmail("123456@email.com");
		usuario1.setCidade(cidade1);
		cUsuarios.cadastrarUsuarioSimples(usuario1);
		
		Usuario usuario2 = new Usuario();
		Cidade cidade2 = new Cidade();
		cidade2.setId(2);
		cidade2.setNome("Natal");
		usuario2.setEmail("123789@email.com");
		usuario2.setCidade(cidade2);
		cUsuarios.cadastrarUsuarioSimples(usuario2);
		
		
		
		
	}

	@Test
	public void testCadastrarUsuarioSimplesSucesso() {
		String email = "giancarlolucciani@gmail.com";
		Cidade cidade = new Cidade();
		cidade.setId(1);
		cidade.setNome("Fortaleza");
		try {

			cUsuarios.cadastrarUsuarioSimples(email, cidade);
			Usuario usuEsperado = new Usuario();
			usuEsperado.setCidade(cidade);
			usuEsperado.setEmail(email);
			Usuario usuObtido = cUsuarios.buscarUsuario(email);
			assertTrue(usuObtido.equals(usuEsperado));
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void testCadastrarUsuarioJaExistente() {
		
		String email = "123456@email.com";
		Cidade cidade = new Cidade();
		cidade.setId(1);
		cidade.setNome("Fortaleza");
		try {

			cUsuarios.cadastrarUsuarioSimples(email, cidade);
			fail("Cadastrou usuário que já existe");
		} catch (Exception e) {
			// Sucesso
		}
		
	}
	
	@Test
	public void testCadastrarUsuarioFaltandoCidade() {
	
		String email = "123@email.com";
		Cidade cidade = null;
		try {

			cUsuarios.cadastrarUsuarioSimples(email, cidade);
			fail("Cadastrou usuário faltando a cidade");
		} catch (Exception e) {
			// Sucesso
		}
		
		
	}

}
