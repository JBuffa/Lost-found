package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.model.Usuario;

@Service
public class UsuariosHelper {
	
	@Autowired
	private Environment env;
	
	
	public boolean intentarLoguearse(HttpSession session, String nick, String contrasenia, Connection connection) throws SQLException{

		
		PreparedStatement consulta = connection
				.prepareStatement("SELECT * FROM usuarios WHERE nick = ? AND contrasenia = ? ");
		consulta.setString(1, nick);
		consulta.setString(2, contrasenia);
		ResultSet resultado = consulta.executeQuery();
		
		
		if (resultado.next() ){
			int id = resultado.getInt("id");
			session.setAttribute("id", id);
			String codigo = UUID.randomUUID().toString();
			session.setAttribute("codigo-autorizacion", codigo); //sesion id
			PreparedStatement consulta2 = connection
					.prepareStatement("UPDATE usuarios SET codigo = ? WHERE nick = ?");
			consulta2.setString(1, codigo);
			consulta2.setString(2, nick);
			consulta2.executeUpdate();
			
			
			return true;
		} else {
			return false;
		}
	
	}
	
	public static Usuario usuarioLogeado(HttpSession session, Connection connection) throws SQLException{
		String codigo =  (String)session.getAttribute("codigo-autorizacion");
		
		if (codigo != null){
		
			PreparedStatement consulta = connection
					.prepareStatement("SELECT * FROM usuarios WHERE codigo = ?");
			consulta.setString(1, codigo);
			ResultSet resultado = consulta.executeQuery();
			
			if (resultado.next()){
				int id = resultado.getInt("id");
				session.setAttribute("id", id);
				Usuario logueado = new Usuario (resultado.getInt("id"), resultado.getString("correo"), resultado.getString("contrasenia"),
						resultado.getBoolean("administrador"), resultado.getString("imagen_de_perfil"), resultado.getString("nick"), 
						resultado.getString("nombre"), resultado.getString("apellido"), resultado.getString("codigo"));
				return logueado;
			
			} else {
				return null;
			}

		} else {
			return null;
		}
	
		
	}
	
	public static void cerrarSesion(HttpSession session, Connection connection) throws SQLException{
		
		String codigo = (String)session.getAttribute("codigo-autorizacion");
		session.removeAttribute("codigo-autorizacion");
		

		PreparedStatement consulta = connection
				.prepareStatement("UPDATE usuarios SET codigo = null WHERE codigo = ?");
		consulta.setString(1, codigo);
		consulta.executeUpdate();

	}
	
	
	public void checkearHeader(Usuario logeado, Model template) throws SQLException{
		if (logeado == null) {
			template.addAttribute("estaLogeado", false);
		} else {
			template.addAttribute("estaLogeado", true);
		
			template.addAttribute("img_perfil", logeado.getImg_perfil());
			template.addAttribute("nick", logeado.getNick());
			
				if (logeado.isAdministrador() == true) {
					
					template.addAttribute("logeadoisadmin", logeado.isAdministrador());
				}
		}
	}

}
