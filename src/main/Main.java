package main;

import java.util.Scanner;

import daoimplementation.UsuarioDAOImpl;
import daointerfaces.UsuarioDAO;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = 0;
		Scanner sc = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		
		
		while(value == 0) {
			
			System.out.println("1 - Cadastrar usuario."+"\n"+"2 - Buscar Usuario."+"3 - Listar usuarios."+"\n"+"4 - Atualiazar Usuario."+"\n"+"5 - Excluir usuario."
					+"\n"+"0 - Sair");
					
			value = sc.nextInt();
			switch(value) {
				case 1:
					Usuario novoUsuario = new Usuario("Marcos", "marcos@gmail.com");
					usuarioDAO.adicionarUsuario(novoUsuario);
					break;
				case 2:
					Usuario usuario = usuarioDAO.buscarUsuario(1);
					System.out.println("Usuario encontrado: "+ "ID: "+usuario.getId()+"Nome: "+usuario.getNome() + usuario.getEmail());
					break;
				case 3:
					System.out.println("Listas de usuarios: ");
					for(Usuario u : usuarioDAO.listarUsuarios()){
						System.out.println("ID: " + u.getId() + "Nome: " + u.getNome() + "E-mail: " + u.getEmail());
					}
					break;
				case 4:
					/*Usuario usuario = new Usuario();
					usuario.setId(2);
					usuario.setNome("Marcos Rocha");
					usuario.setEmail("rmarcos140@gmail.com");
					usuarioDAO.atualizarUsuario(usuario);*/
					break;
				case 5:
					usuarioDAO.deletarUsuario(1);
					break;
				case 0:
					System.out.println("Você saiu!");
					break;
				default:
					System.out.println("Opção Invalida!!!");
			}
		}
		//Adicionar usuario			
		//Buscar Usuario
		//Atualizar usuario
		//Deletar usuario
		
	}
}
