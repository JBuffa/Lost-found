package com.example.model;

public class Perdidos {
	private int id;
	private String img_perdido;
	private String descripcion;
	private String usuario;

	
	public Perdidos(int id, String img_perdido, String descripcion,  String usuario) {
		this.id = id;
		this.img_perdido= img_perdido;
		this.descripcion = descripcion;
		this.usuario = usuario;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg_perdido() {
		return img_perdido;
	}

	public void setImg_perdido(String img_perdido) {
		this.img_perdido = img_perdido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	
	
}
