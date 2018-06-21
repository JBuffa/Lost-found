package com.example.model;

public class Perdidos {
	public Perdidos(Boolean encontrado) {
		super();
		this.encontrado = encontrado;
	}

	public Perdidos(int id, String img_perdido, String titulo, String descripcion, String usuario,  Boolean encontrado) {
		super();
		this.id = id;
		this.img_perdido = img_perdido;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.encontrado = encontrado;
	}

	private int id;
	private String img_perdido;
	private String descripcion;
	private String usuario;
	private String titulo;
	private Boolean encontrado;



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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Boolean getEncontrado() {
		return encontrado;
	}

	public void setEncontrado(Boolean encontrado) {
		this.encontrado = encontrado;
	}

	
}
