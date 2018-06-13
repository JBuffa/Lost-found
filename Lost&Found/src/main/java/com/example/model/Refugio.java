package com.example.model;

public class Refugio {
	private int id;
	private String nick;
	private String contrasenia;
	private String codigo;
	private String correo;
	private String imagen_de_perfil;
	private boolean administrador;
	
	public Refugio(int id, String nick, String contrasenia, boolean administrador, String codigo, String correo, String imagen_de_perfil) {
		this.id = id;
		this.nick = nick;
		this.contrasenia = contrasenia;
		this.administrador = administrador;
		this.codigo = codigo;
		this.correo = correo;
		this.imagen_de_perfil = imagen_de_perfil;
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

	public String getImagen_de_perfil() {
		return imagen_de_perfil;
	}

	public void setImagen_de_perfil(String imagen_de_perfil) {
		this.imagen_de_perfil = imagen_de_perfil;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	
	
	
}
