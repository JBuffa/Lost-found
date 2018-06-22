package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Avisos;
import com.example.model.Mascota;
import com.example.model.Perdidos;
import com.example.model.Refugio;
import com.example.model.Usuario;

@Controller
public class UsuariosController {
	
	@Autowired
	private Environment env;
	
	
	//<---seccion de registro--->
	
	@GetMapping("/iniciar_sesion")
	public String iniciarSesion() {
	return "login";
}
	
	
	// formulario vacio para loguearse

		
	@GetMapping("/registro")
		public String registro() {
		return "register";
	}
	
	@PostMapping("/procesar-registro")
		public String procesarLogin( HttpSession session, @RequestParam String correo, @RequestParam String contrasenia) throws SQLException {
		boolean sePudo = UsuariosHelper.intentarLoguearse(session, correo, contrasenia, null);
		
		if (sePudo){
			return "redirect:/";
		} else {
			// precargar los datos que lleno, salvo la contrasenia
			return "register";
		}
		
	}
	
	@GetMapping("/recuperar_contrasenia")
		public String recuperarContrasenia() {
		return "forgot-password";
	}
	
	//<---fin seccion de registro--->
	
	// pagina inicial
	
	@GetMapping("/")
	public String inicio(HttpSession session,  Model template)throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
		
		return "Home";
	}	
	
	// contactarnos
	
	@GetMapping("/nosotros")
	public String contacto(HttpSession session,  Model template)throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
			
		return "contact";
	}
	
	
	@GetMapping("/registrar_mascota")
	public String registroMascota(HttpSession session,  Model template)throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
			
		return "registro-mascota";
	}
	
	@GetMapping("/registrar_refugio")
	public String registroRefugio(HttpSession session,  Model template)throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
			
		return "registro-refugio";
	}

	@GetMapping("/registrar_perdido")
	public String registroPerdido(HttpSession session,  Model template)throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
			
		return "registro-perdido";
	}
	
	@GetMapping("/registrar_usuario")
	public String registroUsuario1(HttpSession session,  Model template)throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
			
		return "registro-usuario";
	}
	
	@GetMapping("/registrar_avisos")
	public String registroAvisos(HttpSession session,  Model template)throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
		
		return "registro-avisos";
	}
	
	
	
	//<---Lista de refugios--->
	
	
	@GetMapping	("/refugio")
	public String refugio(HttpSession session, Model template) throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		 
			Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
			if (logeado == null) {
			           template.addAttribute("estaLogeado", false);
			       } else {
			           template.addAttribute("estaLogeado", true);
			       }
	
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM refugio;");
		
		
		ResultSet resultado = consulta.executeQuery();
		
		ArrayList<Refugio> listadoRefugio = new ArrayList<Refugio>();
		
		while ( resultado.next() ) {
			int id = resultado.getInt("id");
			String img_refugio = resultado.getString("img_refugio");
			String nombre_refugio = resultado.getString("nombre_refugio");
			String encargado = resultado.getString("encargado");
			String barrio = resultado.getString("barrio");
			String direccion = resultado.getString("direccion");
			String telefono = resultado.getString("telefono");
			String email = resultado.getString("email");
			String facebook = resultado.getString("facebook");
			Boolean admin_refugio = resultado.getBoolean("admin_refugio");
			String contrasenia = resultado.getString("contrasenia");
			String codigo = resultado.getString("codigo");
			
			Refugio x = new Refugio(id, img_refugio, nombre_refugio, encargado, barrio, direccion, telefono, email, 
					 facebook, admin_refugio, contrasenia, codigo);
			listadoRefugio.add(x);
		}
		
		template.addAttribute("listadoRefugio", listadoRefugio);
			
		return "refuge";
	}
	
	
	// muestra un refugio en detalle
	@GetMapping("/detalle_refugio/{id}")
	public String detalleRefugio(HttpSession session, Model template, @PathVariable int id) throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		 
			Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
			if (logeado == null) {
			           template.addAttribute("estaLogeado", false);
			       } else {
			           template.addAttribute("estaLogeado", true);
			       }
		
		
		
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM refugio WHERE id = ?;");
		
		consulta.setInt(1, id);

		ResultSet resultado = consulta.executeQuery();
		
		if ( resultado.next() ) {
			String nombre_refugio = resultado.getString("nombre_refugio");
			String barrio = resultado.getString("barrio");
			String encargado = resultado.getString("encargado");
			String contrasenia = resultado.getString("contrasenia");
			String email = resultado.getString("email");
			String telefono = resultado.getString("telefono");
			String direccion = resultado.getString("direccion");
			String codigo = resultado.getString("codigo");
			String img_refugio = resultado.getString("img_refugio");
			String facebook= resultado.getString("facebook");
			
			template.addAttribute("nombre_refugio", nombre_refugio);
			template.addAttribute("barrio", barrio);
			template.addAttribute("encargado", encargado);
			template.addAttribute("contrasenia", contrasenia);
			template.addAttribute("email", email);
			template.addAttribute("telefono", telefono);
			template.addAttribute("direccion", direccion);
			template.addAttribute("codigo", codigo);
			template.addAttribute("img_refugio", img_refugio);
			template.addAttribute("facebook", facebook);
		}
		
		return "detalle_refugio";
	}

	
	//<---Registro refugio--->
	
	

	@GetMapping("/insertar-refugio")
	public String insertarRefugio(HttpSession session, @RequestParam String img_refugio, @RequestParam String nombre_refugio, @RequestParam String contrasenia,
			@RequestParam String email, @RequestParam String direccion, @RequestParam String barrio, @RequestParam String encargado, @RequestParam String telefono, 
			@RequestParam String facebook, @RequestParam (value = "admin_refugio", required = false) boolean admin_refugio) throws SQLException {
		
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		

		
		
		PreparedStatement consulta = connection.prepareStatement(
				"INSERT INTO refugio(img_refugio, nombre_refugio, contrasenia, email, direccion, barrio, encargado, telefono, facebook, admin_refugio) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");
		consulta.setString(1, img_refugio);
		consulta.setString(2, nombre_refugio);
		consulta.setString(3, contrasenia);
		consulta.setString(4, email);
		consulta.setString(5, direccion);
		consulta.setString(6, barrio);
		consulta.setString(7, encargado);
		consulta.setString(8, telefono);
		consulta.setString(9, facebook);
		consulta.setBoolean(10, admin_refugio);
		consulta.executeUpdate();

		connection.close();

		return "redirect:/refugio";
	}
	
	
	
	//<---Lista de Mascotas--->
	
	
	@GetMapping	("/adopcion")
	public String mascota(HttpSession session, Model template) throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
		
		
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM mascota ORDER BY id DESC;");
		
		ResultSet resultado = consulta.executeQuery();
		
		ArrayList<Mascota> listadoMascota = new ArrayList<Mascota>();
		
		while ( resultado.next() ) {
			int id = resultado.getInt("id");
			String img_mascota = resultado.getString("img_mascota");
			String nombre_mascota = resultado.getString("nombre_mascota");
			String edad = resultado.getString("edad");
			String clasificacion = resultado.getString("clasificacion");
			String raza = resultado.getString("raza");
			String vacuna = resultado.getString("vacuna");
			String castrado = resultado.getString("castrado");
			String refugio = resultado.getString("refugio");
			String encargado = resultado.getString("encargado");
			String adoptante = resultado.getString("adoptante");
			Boolean adoptado = resultado.getBoolean("adoptado");
			
			Mascota x = new Mascota(id, img_mascota, nombre_mascota, edad, clasificacion, raza, vacuna, castrado, refugio, encargado, adoptante, adoptado);
			listadoMascota.add(x);
		}
		
		template.addAttribute("listadoMascota", listadoMascota);
			
		return "adoption";
	}
	
	
	
	
	
	//<---Registro Mascota--->
	
	

	@GetMapping("/insertar-mascota")
	public String insertarMascota(HttpSession session, @RequestParam String img_mascota, @RequestParam String nombre_mascota, @RequestParam String edad,
			@RequestParam String raza, @RequestParam String clasificacion, @RequestParam String castrado, @RequestParam String vacuna, @RequestParam String refugio, 
			@RequestParam String encargado, @RequestParam (value = "adoptado", required = false) boolean adoptado) throws SQLException {
		
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		

		
		
		PreparedStatement consulta = connection.prepareStatement(
				"INSERT INTO mascota(img_mascota, nombre_mascota, edad, raza, clasificacion, castrado, vacuna, refugio, encargado, adoptado) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ");
		consulta.setString(1, img_mascota);
		consulta.setString(2, nombre_mascota);
		consulta.setString(3, edad);
		consulta.setString(4, raza);
		consulta.setString(5, clasificacion);
		consulta.setString(6, castrado);
		consulta.setString(7, vacuna);
		consulta.setString(8, refugio);
		consulta.setString(9, encargado);
		consulta.setBoolean(10, adoptado);
		consulta.executeUpdate();

		connection.close();

		return "redirect:/adopcion";
	}
	
	
	// muestra una mascota en detalle
		@GetMapping("/detalle_mascota/{id}")
		public String detalleMascota(HttpSession session, Model template, @PathVariable int id) throws SQLException {
			
			Connection connection;
			connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
					env.getProperty("spring.datasource.password"));
			
			
			Usuario logeado = UsuariosHelper.usuarioLogeado(session, connection);
			
			if (logeado == null) {
	            template.addAttribute("estaLogeado", false);
	        } else {
	            template.addAttribute("estaLogeado", true);
	            String nick = logeado.getNick();
	            template.addAttribute("nick", nick);  
			}
		
			
			
			PreparedStatement consulta = 
					connection.prepareStatement("SELECT * FROM mascota WHERE id = ?;");
			
			consulta.setInt(1, id);

			ResultSet resultado = consulta.executeQuery();
			
			if ( resultado.next() ) {
				String nombre_mascota = resultado.getString("nombre_mascota");
				String edad = resultado.getString("edad");
				String clasificacion = resultado.getString("clasificacion");
				String raza = resultado.getString("raza");
				String vacuna = resultado.getString("vacuna");
				String castrado = resultado.getString("castrado");
				String refugio = resultado.getString("refugio");
				String encargado = resultado.getString("encargado");
				String img_mascota = resultado.getString("img_mascota");
				String adoptante = resultado.getString("adoptante");
				Boolean adoptado = resultado.getBoolean("adoptado");
				
				template.addAttribute("nombre_mascota", nombre_mascota);
				template.addAttribute("edad", edad);
				template.addAttribute("clasificacion", clasificacion);
				template.addAttribute("raza", raza);
				template.addAttribute("vacuna", vacuna);
				template.addAttribute("castrado", castrado);
				template.addAttribute("refugio", refugio);
				template.addAttribute("encargado", encargado);
				template.addAttribute("img_mascota", img_mascota);
				template.addAttribute("adoptante", adoptante);
				template.addAttribute("adoptado", adoptado);
			}
			
			return "detalle_mascota";
		}

	
	//<---Registro usuario--->
	
		@GetMapping("/registro-usuario")
		public String registroUsuario(HttpSession session, Model template) throws SQLException {
			Connection connection;
			connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
					env.getProperty("spring.datasource.password"));
			
			Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);

			if (logeado == null) {
	            template.addAttribute("estaLogeado", false);
	        } else {
	            template.addAttribute("estaLogeado", true);
	            String nick = logeado.getNick();
	            template.addAttribute("nick", nick);  
			}
			
			connection.close();
			
			return "registro-usuario";
		}	

	@GetMapping("/insertar-usuario")
	public String insertUsuario(HttpSession session, @RequestParam String nick,@RequestParam String img_perfil,
			 @RequestParam String correo, @RequestParam String contrasenia, @RequestParam String nombre, @RequestParam String apellido,
			 @RequestParam (value = "administrador", required = false) boolean administrador) throws SQLException {
		
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		
		PreparedStatement consulta = connection.prepareStatement(
				"INSERT INTO usuarios(nick, img_perfil, correo, contrasenia, administrador, nombre, apellido) VALUES( ?, ?, ?, ?, ?, ?, ?); ");
		consulta.setString(1, nick);
		consulta.setString(2, img_perfil);
		consulta.setString(3, correo);
		consulta.setString(4, contrasenia);
		consulta.setBoolean(5, administrador);
		consulta.setString(6, nombre);
		consulta.setString(7, apellido);
		consulta.executeUpdate();

		connection.close();
		boolean sePudo = UsuariosHelper.intentarLoguearse(session, nick, contrasenia, connection);
		
		if (sePudo){
			Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
			connection.close();
			return "redirect:/perfil/" + logeado.getNick();
		} else {
			connection.close();
			return "redirect:/iniciar_sesion";	
		}
	}
	
	
	@PostMapping("/logear-usuario")
	public String logearUsuario(HttpSession session, Model template, @RequestParam String nick, @RequestParam String contrasenia) throws SQLException {
	
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		
		
		boolean sePudo = UsuariosHelper.intentarLoguearse(session, nick, contrasenia, connection);
			
			if (sePudo){
				Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
				connection.close();
				return "redirect:/perfil/" + logeado.getNick();
			} else {
				connection.close();
				return "redirect:/iniciar_sesion";	
			}
		}
	
	
	// muestra un perfil usuario en detalle
		@GetMapping("/perfil/{nick}")
		public String detallePerfil(HttpSession session, Model template, @PathVariable String nick) throws SQLException {
			
			Connection connection;
			connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
					env.getProperty("spring.datasource.password"));
			
			Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
			
			if (logeado == null) {
	              template.addAttribute("estaLogeado", false);
	          } else {
	              template.addAttribute("estaLogeado", true);
			}
			
			
			PreparedStatement consulta = 
					connection.prepareStatement("SELECT * FROM usuarios WHERE nick = ?;");
			
			consulta.setString(1, nick);

			ResultSet resultado = consulta.executeQuery();
			
			if ( resultado.next() ) {
				String nick1 = resultado.getString("nick");
				String nombre = resultado.getString("nombre");
				String apellido = resultado.getString("apellido");
				String administrador = resultado.getString("administrador");
				String contrasenia = resultado.getString("contrasenia");
				String correo = resultado.getString("correo");
				String codigo = resultado.getString("codigo");
				String img_perfil = resultado.getString("img_perfil");
				
				template.addAttribute("nick", nick1);
				template.addAttribute("nombre", nombre);
				template.addAttribute("apellido", apellido);
				template.addAttribute("administrador", administrador);
				template.addAttribute("contrasenia", contrasenia);
				template.addAttribute("correo", correo);
				template.addAttribute("codigo", codigo);
				template.addAttribute("img_perfil", img_perfil);

			}
			
			return "perfil";
		}

		// muestra un perfil usuario en detalle
		@GetMapping("/perfil")
		public String detallePerfil2(HttpSession session, Model template, @PathVariable String nick) throws SQLException {
			
			Connection connection;
			connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
					env.getProperty("spring.datasource.password"));
			
			Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
			
			if (logeado == null) {
	            template.addAttribute("estaLogeado", false);
	        } else {
	            template.addAttribute("estaLogeado", true);
	            template.addAttribute("nick", nick);  
			}
			
			
			PreparedStatement consulta = 
					connection.prepareStatement("SELECT * FROM usuarios WHERE nick = ?;");
			
			consulta.setString(1, nick);

			ResultSet resultado = consulta.executeQuery();
			
			if ( resultado.next() ) {
				String nick1 = resultado.getString("nick");
				String nombre = resultado.getString("nombre");
				String apellido = resultado.getString("apellido");
				String administrador = resultado.getString("administrador");
				String contrasenia = resultado.getString("contrasenia");
				String correo = resultado.getString("correo");
				String codigo = resultado.getString("codigo");
				String img_perfil = resultado.getString("img_perfil");
				
				template.addAttribute("nick", nick1);
				template.addAttribute("nombre", nombre);
				template.addAttribute("apellido", apellido);
				template.addAttribute("administrador", administrador);
				template.addAttribute("contrasenia", contrasenia);
				template.addAttribute("correo", correo);
				template.addAttribute("codigo", codigo);
				template.addAttribute("img_perfil", img_perfil);

			}
			
			return "perfil";
		}
		
		
		
		
	//<---Registro perdido--->
	
	

	@GetMapping("/insertar-perdido")
	public String insertUsuario(HttpSession session, @RequestParam String img_perdido, @RequestParam String usuario, @RequestParam String titulo, 
			@RequestParam String descripcion, @RequestParam (value = "encontrado", required = false) boolean encontrado) throws SQLException {
		
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		

		
		
		PreparedStatement consulta = connection.prepareStatement(
				"INSERT INTO perdidos(img_perdido, usuario, titulo, descripcion, encontrado) VALUES( ?, ?, ?, ?, ?); ");
		consulta.setString(1, img_perdido);
		consulta.setString(2, usuario);
		consulta.setString(3, titulo);
		consulta.setString(4, descripcion);
		consulta.setBoolean(5, encontrado);
		consulta.executeUpdate();

		connection.close();

		return "redirect:/perdidos";
	}
	
	// muestra el listado completo de mascotas perdidas
	@GetMapping("/perdidos")
	public String peridos( HttpSession session, Model template) throws SQLException {
		

		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
		
		
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM perdidos ORDER BY id DESC;");
		
		ResultSet resultado = consulta.executeQuery();
		
		ArrayList<Perdidos> listadoPerdidos = new ArrayList<Perdidos>();
		
		while ( resultado.next() ) {
			int id = resultado.getInt("id");
			String img_perdido = resultado.getString("img_perdido");
			String titulo = resultado.getString("titulo");
			String descripcion = resultado.getString("descripcion");
			String usuario = resultado.getString("usuario");
			Boolean encontrado = resultado.getBoolean("encontrado");
			
			Perdidos x = new Perdidos(id, img_perdido, titulo, descripcion, usuario, encontrado);
			listadoPerdidos.add(x);
		}
		
		template.addAttribute("listadoPerdidos", listadoPerdidos);
		
		return "lost";
	}
	
	
	

	
	
	// muestra el listado completo de avisos
	@GetMapping("/zoonosis")
	public String listado( HttpSession session, Model template) throws SQLException {
	
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
		
		
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM avisos ORDER BY id DESC;");
		
		ResultSet resultado = consulta.executeQuery();
		
		ArrayList<Avisos> listadoAvisos = new ArrayList<Avisos>();
		
		while ( resultado.next() ) {
			int id = resultado.getInt("id");
			String img_avisos = resultado.getString("img_avisos");
			String titulo = resultado.getString("titulo");
			String detalles = resultado.getString("detalles");
			
			Avisos x = new Avisos( id, img_avisos, titulo, detalles);
			listadoAvisos.add(x);
		}
		
		template.addAttribute("listadoAvisos", listadoAvisos);
		
		return "announcements";
	}
	
	//<---Registro avisos--->
	
	

	@GetMapping("/insertar-avisos")
	public String insertarAviso(HttpSession session, @RequestParam String img_avisos, @RequestParam String titulo, 
			@RequestParam String detalles) throws SQLException {
		
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		
		PreparedStatement consulta = connection.prepareStatement(
				"INSERT INTO avisos(img_avisos, titulo, detalles) VALUES( ?, ?, ?); ");
		consulta.setString(1, img_avisos);
		consulta.setString(2, titulo);
		consulta.setString(3, detalles);
		
		consulta.executeUpdate();

		connection.close();

		return "redirect:/zoonosis";
	}
	
	
	
	// desconecta session
	@GetMapping("/desconectar")
	public String desconecta( HttpSession session, Model template) throws SQLException {
		
		        Connection connection;
		        connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
		                env.getProperty("spring.datasource.password"));
		        com.example.demo.UsuariosHelper.cerrarSesion(session, connection);
		        
		        
		        connection.close();
		        

		return "redirect:/";
		 }		
	
	
	//<---Administrador--->
	
	
	
	@GetMapping("/administrar")
	public String administrar(HttpSession session,Model template) throws SQLException {

		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		if (logeado == null) {
            template.addAttribute("estaLogeado", false);
        } else {
            template.addAttribute("estaLogeado", true);
            String nick = logeado.getNick();
            template.addAttribute("nick", nick);  
		}
		
		if (logeado == null || logeado.isAdministrador() == false) {
			return "redirect:/iniciar_sesion";
		}


		PreparedStatement consultaMascota = connection.prepareStatement("SELECT * FROM Mascota ORDER BY id ASC;");

		ResultSet resultadoMascota = consultaMascota.executeQuery();

		ArrayList<Mascota> listadoMascota = new ArrayList<Mascota>();
		
		while ( resultadoMascota.next() ) {
			int id = resultadoMascota.getInt("id");
			String img_mascota = resultadoMascota.getString("img_mascota");
			String nombre_mascota = resultadoMascota.getString("nombre_mascota");
			String edad = resultadoMascota.getString("edad");
			String clasificacion = resultadoMascota.getString("clasificacion");
			String raza = resultadoMascota.getString("raza");
			String vacuna = resultadoMascota.getString("vacuna");
			String castrado = resultadoMascota.getString("castrado");
			String refugio = resultadoMascota.getString("refugio");
			String encargado = resultadoMascota.getString("encargado");
			String adoptante = resultadoMascota.getString("adoptante");
			Boolean adoptado = resultadoMascota.getBoolean("adoptado");
			
			Mascota x = new Mascota(id, img_mascota, nombre_mascota, edad, clasificacion, raza, vacuna, castrado, refugio, encargado, adoptante, adoptado);
			listadoMascota.add(x);	
		}

		template.addAttribute("listadoMascota", listadoMascota);
		
		
		PreparedStatement consultaRefugio = connection.prepareStatement("SELECT * FROM refugio ORDER BY id ASC;");

		ResultSet resultadoRefugio = consultaRefugio.executeQuery();

		ArrayList<Refugio> listadoRefugio= new ArrayList<Refugio>();
		
		while ( resultadoRefugio.next() ) {
			int id = resultadoRefugio.getInt("id");
			String img_refugio = resultadoRefugio.getString("img_refugio");
			String nombre_refugio = resultadoRefugio.getString("nombre_refugio");
			String encargado = resultadoRefugio.getString("encargado");
			String barrio = resultadoRefugio.getString("barrio");
			String direccion = resultadoRefugio.getString("direccion");
			String telefono = resultadoRefugio.getString("telefono");
			String email = resultadoRefugio.getString("email");
			String facebook = resultadoRefugio.getString("facebook");
			Boolean admin_refugio = resultadoRefugio.getBoolean("admin_refugio");
			String contrasenia = resultadoRefugio.getString("contrasenia");
			String codigo = resultadoRefugio.getString("codigo");
			
			Refugio z = new Refugio(id, img_refugio, nombre_refugio, encargado, barrio, direccion, telefono, email, 
					 facebook, admin_refugio, contrasenia, codigo);

			listadoRefugio.add(z);	
		}

		template.addAttribute("listadoRefugio", listadoRefugio);
		
		
		PreparedStatement consultaUsuarios = connection.prepareStatement("SELECT * FROM perdidos ORDER BY id ASC;");

		ResultSet resultadoPerdidos = consultaUsuarios.executeQuery();

		ArrayList<Perdidos> listadoPerdidos = new ArrayList<Perdidos>();
		
		while ( resultadoPerdidos.next() ) {
			int id = resultadoPerdidos.getInt("id");
			String img_perdido = resultadoPerdidos.getString("img_perdido");
			String titulo = resultadoPerdidos.getString("titulo");
			String descripcion = resultadoPerdidos.getString("descripcion");
			String usuario = resultadoPerdidos.getString("usuario");
			Boolean encontrado = resultadoPerdidos.getBoolean("encontrado");
			
			Perdidos y = new Perdidos(id, img_perdido, titulo, descripcion, usuario, encontrado);
			
			listadoPerdidos.add(y);
		}
		
		template.addAttribute("listadoPerdidos", listadoPerdidos);
		
		
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM avisos;");
		
		ResultSet resultadoAvisos = consulta.executeQuery();
		
		ArrayList<Avisos> listadoAvisos = new ArrayList<Avisos>();
		
		while ( resultadoAvisos.next() ) {
			int id = resultadoAvisos.getInt("id");
			String img_avisos = resultadoAvisos.getString("img_avisos");
			String titulo = resultadoAvisos.getString("titulo");
			String detalles = resultadoAvisos.getString("detalles");
			
			Avisos w = new Avisos( id, img_avisos, titulo, detalles);
			
			listadoAvisos.add(w);
		}
		
		template.addAttribute("listadoAvisos", listadoAvisos);
		
		connection.close();
		
		return "administrar";
	}
	
	//<---Administrador: Eliminar datos--->

	
	@GetMapping("/eliminar-refugio/{id}")
	public String eliminarRefugio(Model template, @PathVariable int id) throws SQLException {
	
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));

		PreparedStatement consulta = connection.prepareStatement("DELETE FROM refugio WHERE id = ?;");

		consulta.setInt(1, id);

		consulta.executeUpdate();

		connection.close();
		return "redirect:/administrar";
	}
	
	@GetMapping("/eliminar-mascota/{id}")
	public String eliminarMascota(Model template, @PathVariable int id) throws SQLException {
	
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));

		PreparedStatement consulta = connection.prepareStatement("DELETE FROM mascota WHERE id = ?;");

		consulta.setInt(1, id);

		consulta.executeUpdate();

		connection.close();
		return "redirect:/administrar";
	}
	
	@GetMapping("/eliminar-perdidos/{id}")
	public String eliminarPerdidos(Model template, @PathVariable int id) throws SQLException {
	
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));

		PreparedStatement consulta = connection.prepareStatement("DELETE FROM perdidos WHERE id = ?;");

		consulta.setInt(1, id);

		consulta.executeUpdate();

		connection.close();
		return "redirect:/administrar";
	}
	
	@GetMapping("/eliminar-avisos/{id}")
	public String eliminarAvisos(Model template, @PathVariable int id) throws SQLException {
	
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));

		PreparedStatement consulta = connection.prepareStatement("DELETE FROM avisos WHERE id = ?;");

		consulta.setInt(1, id);

		consulta.executeUpdate();

		connection.close();
		return "redirect:/administrar";
	}
	
	
}






