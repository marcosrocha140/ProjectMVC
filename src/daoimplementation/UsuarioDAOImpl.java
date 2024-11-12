package daoimplementation;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import daointerfaces.UsuarioDAO;
import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
	private static final String URL = "jdbc:mysql://localhost:3306/db_teste";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	public UsuarioDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void adicionarUsuario(Usuario usuario) {
		String sql = "INSERT into Usuario (nome, email) VALUES (?, ?)";
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getEmail());
				stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Usuario buscarUsuario(int id) {
		String sql = "SELECT * FROM Usuario WHERE id = ?";
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					return usuario;
				}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Usuario> listarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM Usuario";
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)){
				while(rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setEmail(rs.getString("email"));
					usuarios.add(usuario);
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public void atualizarUsuario(Usuario usuario) {
		String sql = "UPDATE Usuario SET nome = ?, email = ? WHERE id = ?";
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)){
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getEmail());
				stmt.setInt(3, usuario.getId());
				stmt.executeUpdate();	
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deletarUsuario(int id) {
		String sql = "DELETE FROM Usuario WHERE id = ?";
		try(Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}