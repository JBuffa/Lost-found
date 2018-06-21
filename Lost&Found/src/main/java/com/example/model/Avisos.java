package com.example.model;

public class Avisos {
	private int id;
	private String detalles;
	private String img_avisos;
	private String titulo;

	
	public Avisos(int id, String img_avisos, String  titulo, String detalles) {
		this.id = id;
		this.img_avisos = img_avisos;
		this.titulo = titulo;
		this.detalles = detalles;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg_avisos() {
		return img_avisos;
	}

	public void setImg_avisos(String img_avisos) {
		this.img_avisos = img_avisos;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
