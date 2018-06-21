package com.example.model;

public class Refugio {
	public Refugio(int id, String img_refugio, String nombre_refugio,  String barrio, String encargado, String direccion,
			String email, String telefono, String facebook, boolean admin_refugio, String codigo, String contrasenia) {
		super();
		this.id = id;
		this.img_refugio = img_refugio;
		this.nombre_refugio = nombre_refugio;
		this.barrio = barrio;
		this.encargado = encargado;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.facebook = facebook;
		this.contrasenia = contrasenia;
		this.codigo = codigo;
		this.admin_refugio = admin_refugio;
	}
	private int id;
	private String img_refugio;
	private String nombre_refugio;
	private String barrio;
	private String encargado;
	private String email;
	private String direccion;
	private String telefono;
	private String facebook;
	private String contrasenia;
	private String codigo;
	private boolean admin_refugio;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_refugio() {
		return nombre_refugio;
	}
	public void setNombre_refugio(String nombre_refugio) {
		this.nombre_refugio = nombre_refugio;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getEncargado() {
		return encargado;
	}
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getImg_refugio() {
		return img_refugio;
	}
	public void setImg_refugio(String img_refugio) {
		this.img_refugio = img_refugio;
	}
	public boolean isAdmin_refugio() {
		return admin_refugio;
	}
	public void setAdmin_refugio(boolean admin_refugio) {
		this.admin_refugio = admin_refugio;
	}
	
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
}
