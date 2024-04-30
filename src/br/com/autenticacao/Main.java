package br.com.autenticacao;

import br.com.autenticacao.controller.UsuarioController;
import br.com.autenticacao.model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		UsuarioController controller = new UsuarioController();
		
//		Usuario usuario = new Usuario();
//		usuario.setNome("Alice");
//		usuario.setEmail("Alice@contato.com");
//		usuario.setSenha("Alice123");
//		usuario.setIsAtivo(true);
		
//		controller.cadastrar(usuario);
//	}
		
		String email = "Alice@contato.com";
		String senha = "Alice123";
		
		controller.autenticar(email, senha);
		
	}
}
