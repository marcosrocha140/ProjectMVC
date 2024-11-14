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
		Scanner sc2 = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		
		while(value == 0) {
			
			System.out.println("1 - Cadastrar usuario."+"\n"+"2 - Buscar Usuario."+"\n"+"3 - Listar usuarios."+"\n"+"4 - Atualiazar Usuario."+"\n"+"5 - Excluir usuario."
					+"\n"+"0 - Sair");
					
			value = sc.nextInt();
			switch(value) {
				case 1:
					System.out.println("Digite o nome..."+"\n");
					String nome = sc2.nextLine();
					System.out.println("Digite o email..."+"\n");
					String email = sc2.nextLine();
					Usuario novoUsuario = new Usuario(nome, email);
					usuarioDAO.adicionarUsuario(novoUsuario);
					value = 0;
					break;
				case 2:
					System.out.println("Digite o ID do usuario que queira buscar");
					int id = sc2.nextInt();
					Usuario usuario = usuarioDAO.buscarUsuario(id);
					System.out.println("Usuario encontrado: "+ "ID: "+usuario.getId()+" Nome: "+usuario.getNome() +" "+"E-mail: "+ usuario.getEmail());
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
