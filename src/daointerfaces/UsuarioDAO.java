package daointerfaces;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
	
	void adicionarUsuario(Usuario usuario);
	Usuario buscarUsuario(int id);
	List<Usuario> listarUsuarios();
	void atualizarUsuario(Usuario usuario);
	void deletarUsuario(int id);

}