package com.example.model;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private String nick;
	private String contrasenia;
	private String codigo;
	private String correo;
	private String img_perfil;
	private boolean administrador;
	
	public Usuario(int id, String nombre, String apellido, boolean administrador, String contrasenia, String nick, String codigo, String correo, String img_perfil) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nick = nick;
		this.contrasenia = contrasenia;
		this.administrador = administrador;
		this.codigo = codigo;
		this.correo = correo;
		this.img_perfil = img_perfil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getImg_perfil() {
		return img_perfil;
	}

	public void setImg_perfil(String img_perfil) {
		this.img_perfil = img_perfil;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	
	
}
