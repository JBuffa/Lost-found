package com.example.model;

public class Usuario {
	private int id;
	private String img_perfil;
	private String nick;
	private String nombre;
	private String apellido;
	private String correo;
	private boolean administrador;
	private String contrasenia;
	private String codigo;
	
	public Usuario(int id, String img_perfil, String nick, String nombre, String apellido, String correo, boolean administrador, String contrasenia,  String codigo) {
		this.id = id;
		this.img_perfil = img_perfil;
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.administrador = administrador;
		this.codigo = codigo;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getImg_perfil() {
		return img_perfil;
	}

	public void setImg_perfil(String img_perfil) {
		this.img_perfil = img_perfil;
	}
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	
	
}
