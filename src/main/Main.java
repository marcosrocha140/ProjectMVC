package main;

import daoimplementation.UsuarioDAOImpl;
import daointerfaces.UsuarioDAO;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Adicionar usuario
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		//Usuario novoUsuario = new Usuario("Marcelo", "marcelc@gmail.com");
		//usuarioDAO.adicionarUsuario(novoUsuario);
		
		
		//Buscar Usuario
		//Usuario usuario = usuarioDAO.buscarUsuario(1);
		//System.out.println("Usuario encontrado: "+ "ID: "+usuario.getId()+"Nome: "+usuario.getNome() + usuario.getEmail());
	
	
		/*System.out.println("Listas de usuarios: ");
		for(Usuario u : usuarioDAO.listarUsuarios()){
			System.out.println("ID: " + u.getId() + "Nome: " + u.getNome() + "E-mail: " + u.getEmail());
		}*/
	
		//Atualizar usuario
		/*Usuario usuario = new Usuario();
		usuario.setId(2);
		usuario.setNome("Marcos Rocha");
		usuario.setEmail("rmarcos140@gmail.com");
		usuarioDAO.atualizarUsuario(usuario);*/
		
		//Deletar usuario
		//usuarioDAO.deletarUsuario(1);
	}
}
