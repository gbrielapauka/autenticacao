package br.com.autenticacao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.autenticacao.model.Usuario;
import br.com.autenticacao.DAO.GenericDAO;
import br.com.autenticacao.DAO.UsuarioDAOImpl;

public class UsuarioController {
	
public List<Usuario> listarTodos() {
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		try {
			GenericDAO dao = new UsuarioDAOImpl();
			
			for (Object object : dao.listarTodos()) {
				listaUsuarios.add( (Usuario) object );
			}
			
		} catch (Exception e) {
			System.out.println("Erro na Controller ao listar Usuario.");
			e.printStackTrace();
		}
		
		return listaUsuarios;
	}
	
	public void cadastrar(Usuario usuario) {
		try {
			GenericDAO dao = new UsuarioDAOImpl();
			if (dao.cadastrar(usuario)) {
				JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Problemas ao cadastrar usuario.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Usuario usuario) {
		try {
			GenericDAO dao = new UsuarioDAOImpl();
			
			if (validarId(usuario.getId()) == false) {
				JOptionPane.showMessageDialog(null, "Nenhum usuario encontrado para o ID " + usuario.getId());
				return;
			}
			
			if (dao.alterar(usuario) == true) {
				JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Problemas ao alterar usuario.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Usuario listarPorId(int id) {
		try {
			GenericDAO dao = new UsuarioDAOImpl();
			Usuario usuario = (Usuario) dao.listarPorId(id);
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean excluir(int id) {
		try {
			GenericDAO dao = new UsuarioDAOImpl();
			
			if (validarId(id) == false) {
				return false;
			}
			
			dao.excluir(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean validarId(int id) {
		try {
			GenericDAO dao = new UsuarioDAOImpl();
			
			Usuario usuario = (Usuario) dao.listarPorId(id);
			
			if (usuario == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
