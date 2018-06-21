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
	
	@Autowired
	private UsuariosHelper UsuariosHelper;
	
	
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

	@GetMapping("/desconectarse")
		public String logout() {
		return "redirrect:/login";
	}
	
	@GetMapping("/recuperar_contrasenia")
		public String recuperarContrasenia() {
		return "forgot-password";
	}
	
	//<---fin seccion de registro--->
	
	// pagina inicial
	
	@GetMapping("/")
	public String inicio(){	
		return "Home";
	}	
	
	// contactarnos
	
	@GetMapping("/nosotros")
	public String contacto(){	
		return "contact";
	}
	
	
	@GetMapping("/registrar_mascota")
	public String registroMascota(){	
		return "registro-mascota";
	}
	
	@GetMapping("/registrar_refugio")
	public String registroRefugio(){	
		return "registro-refugio";
	}

	@GetMapping("/registrar_perdido")
	public String registroPerdido(){	
		return "registro-perdido";
	}
	
	@GetMapping("/registrar_usuario")
	public String registroUsuario(){	
		return "registro-usuario";
	}
	
	@GetMapping("/registrar_avisos")
	public String registroAvisos(){	
		return "registro-avisos";
	}
	
	
	
	//<---Lista de refugios--->
	
	
	@GetMapping	("/refugio")
	public String refugio(HttpSession session, Model template) throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM refugio;");
		
		ResultSet resultado = consulta.executeQuery();
		
		ArrayList<Refugio> listadoRefugio = new ArrayList<Refugio>();
		
		while ( resultado.next() ) {
			int id = resultado.getInt("id");
			String img_refugio = resultado.getString("img_refugio");
			String nombre_refugio = resultado.getString("nombre_refugio");
			String barrio = resultado.getString("barrio");
			String encargado = resultado.getString("encargado");
			String contrasenia = resultado.getString("contrasenia");
			String email = resultado.getString("email");
			String telefono = resultado.getString("telefono");
			String direccion = resultado.getString("direccion");
			String codigo = resultado.getString("codigo");
			String facebook = resultado.getString("facebook");
			Boolean admin_refugio = resultado.getBoolean("admin_refugio");
			
			Refugio x = new Refugio(id, img_refugio, nombre_refugio, barrio, encargado, contrasenia, email, telefono, direccion, codigo, facebook, admin_refugio);
			listadoRefugio.add(x);
		}
		
		template.addAttribute("listadoRefugio", listadoRefugio);
			
		return "refuge";
	}
	
	
	// muestra un refugio en detalle
	@GetMapping("/detalle_refugio/{id}")
	public String detalleRefugio(Model template, @PathVariable int id) throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
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

	
	//<---Lista de refugios--->
	
	
	@GetMapping	("/adopcion")
	public String mascota(HttpSession session, Model template) throws SQLException {
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM mascota;");
		
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
	
	// muestra una mascota en detalle
		@GetMapping("/detalle_mascota/{id}")
		public String detalleMascota(Model template, @PathVariable int id) throws SQLException {
			
			Connection connection;
			connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
					env.getProperty("spring.datasource.password"));
			
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
		public String registroUsuario(HttpSession session,Model template) throws SQLException {
			Connection connection;
			connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
					env.getProperty("spring.datasource.password"));
			Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
			
			UsuariosHelper.checkearHeader(logeado, template);
			
			connection.close();
			
			return "registro-usuario";
		}	

	@GetMapping("/insertar-usuario")
	public String insertUsuario(@RequestParam String nick,@RequestParam String imagen_de_perfil,
			 @RequestParam String correo, @RequestParam String contrasenia, @RequestParam String nombre, @RequestParam String apellido,
			 @RequestParam (value = "administrador", required = false) boolean administrador) throws SQLException {
		
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		PreparedStatement consulta = connection.prepareStatement(
				"INSERT INTO usuarios(nick, imagen_de_perfil, correo, contrasenia, administrador, nombre, apellido) VALUES( ?, ?, ?, ?, ?, ?, ?); ");
		consulta.setString(1, nick);
		consulta.setString(2, imagen_de_perfil);
		consulta.setString(3, correo);
		consulta.setString(4, contrasenia);
		consulta.setBoolean(5, administrador);
		consulta.setString(6, nombre);
		consulta.setString(7, apellido);
		consulta.executeUpdate();

		connection.close();

		return "redirect:/registro-usuario";
	}
	
	
	@PostMapping("/logear-usuario")
	public String logearUsuario(HttpSession session, Model template, @RequestParam String correo, @RequestParam String contrasenia) throws SQLException {
	
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		boolean sePudo = UsuariosHelper.intentarLoguearse(session, correo, contrasenia, connection);
			
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
		public String detalleRefugio(Model template, @PathVariable String nick) throws SQLException {
			
			Connection connection;
			connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
					env.getProperty("spring.datasource.password"));
			
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
	public String insertUsuario(@RequestParam String img_perdido, @RequestParam String titulo, @RequestParam String descripcion,
			@RequestParam String usuario, @RequestParam (value = "encontrado", required = false) boolean encontrado) throws SQLException {
		
		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		PreparedStatement consulta = connection.prepareStatement(
				"INSERT INTO perdidos(img_perdido, titulo, descripcion, usuario, encontrado) VALUES( ?, ?, ?, ?, ?); ");
		consulta.setString(1, img_perdido);
		consulta.setString(2, titulo);
		consulta.setString(3, descripcion);
		consulta.setString(4, usuario);
		consulta.setBoolean(5, encontrado);
		consulta.executeUpdate();

		connection.close();

		return "redirect:/registro-perdido";
	}
	
	// muestra el listado completo de mascotas perdidas
	@GetMapping("/perdidos")
	public String peridos( HttpSession session, Model template) throws SQLException {
		

		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM perdidos;");
		
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
	
	
	
	//<---Registro avisos--->
	
	

	@GetMapping("/insertar-avisos")
	public String insertarAviso(@RequestParam String img_avisos, @RequestParam String titulo, 
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

		return "redirect:/announcements";
	}
	
	
	// muestra el listado completo de avisos
	@GetMapping("/zoonosis")
	public String listado( HttpSession session, Model template) throws SQLException {
		

		
		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		
		PreparedStatement consulta = 
				connection.prepareStatement("SELECT * FROM avisos;");
		
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
	
	
	
	
	
	
	
	
	
	@GetMapping("/administrar")
	public String administrar(HttpSession session,Model template) throws SQLException {

		Connection connection;
		connection = DriverManager.getConnection(env.getProperty("spring.datasource.url"), env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		Usuario logeado = com.example.demo.UsuariosHelper.usuarioLogeado(session, connection);
		
		if (logeado == null || logeado.isAdministrador() == false) {
			return "redirect:/iniciar_sesion";
		}
		
		UsuariosHelper.checkearHeader(logeado, template);
		
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
			String barrio = resultadoRefugio.getString("barrio");
			String encargado = resultadoRefugio.getString("encargado");
			String contrasenia = resultadoRefugio.getString("contrasenia");
			String email = resultadoRefugio.getString("email");
			String telefono = resultadoRefugio.getString("telefono");
			String direccion = resultadoRefugio.getString("direccion");
			String codigo = resultadoRefugio.getString("codigo");
			String facebook = resultadoRefugio.getString("facebook");
			Boolean admin_refugio = resultadoRefugio.getBoolean("admin_refugio");
			
			Refugio z = new Refugio(id, img_refugio, nombre_refugio, barrio, encargado, contrasenia, email, telefono, direccion, codigo, facebook, admin_refugio);

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
	

}






