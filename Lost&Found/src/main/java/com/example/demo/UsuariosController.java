package com.example.demo;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		public String procesarLogin( HttpSession session, @RequestParam String apodo, @RequestParam String contrasenia) throws SQLException {
		boolean sePudo = UsuariosHelper.intentarLoguearse(session, apodo, contrasenia);
		
		if (sePudo){
			return "redirect:/blank";
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
	
	@GetMapping("/home")
	public String index(){	
		return "blank";
	}
	

}






