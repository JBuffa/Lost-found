package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.model.Usuario;

@Service
public class UsuariosHelper {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UsuariosHelper UsuariosHelper;
	
	public boolean intentarLoguearse( HttpSession session, String correo, String contrasenia ) throws SQLException{
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
		
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM usuarios WHERE correo = ? AND contrasenia = ?;");
		consulta.setString(1, correo);
		consulta.setString(2, contrasenia);
		
		ResultSet resultado = consulta.executeQuery();
		
		if (resultado.next () ){
			String codigo = UUID.randomUUID().toString();
			session.setAttribute("codigo-autorizacion", codigo);
			
			consulta = connection.prepareStatement("UPDATE usuarios SET codigo = ? WHERE correo = ?");
			consulta.setString(1, codigo);
			consulta.setString(2, correo);
			
			consulta.executeQuery();
			
			return true;
		} else {
					
			return false;
		}
		
	}
	
	public Usuario usuarioLogueado(HttpSession session)  throws SQLException {
		String codigo = (String)session.getAttribute("codigo-autorizacion");
		
		if (codigo != null){
			//obtener usuario de la base
			Connection connection;
			connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
			
			PreparedStatement consulta = 
					connection.prepareStatement("SELECT * FROM usuarios WHERE codigo = ?;");
			consulta.setString(1, codigo);
			
			ResultSet resultado = consulta.executeQuery();
			
			if(resultado.next()) {
				//armar y devolver ese usuario
				Usuario logueado = new Usuario (resultado.getInt("id"), resultado.getString("correo"), resultado.getString("contrasenia"), resultado.getBoolean("administrador"));
				return logueado;
			} else {
				return null;
			}
		
		} else {
			return null;
		}
		
		
	}
	
	public void cerrarSesion( HttpSession session  ) throws SQLException {
		// se pone el (String) para forzar el tipo
		String codigo = (String)session.getAttribute("codigo-autorizacion");
		
		session.removeAttribute("codigo-autorizacion");
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"), env.getProperty("spring.datasource.password"));
		
		PreparedStatement consulta = 
				connection.prepareStatement("UPDATE usuarios SET codigo = null WHERE codigo = ?;");
		
		consulta.setString(1, codigo);
		
		consulta.executeUpdate();
		connection.close();
		
		
		
		
	}
}
