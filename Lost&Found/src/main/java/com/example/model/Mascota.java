package com.example.model;

public class Mascota {
	private int id;
	private String nombre_mascota;
	private String edad;
	private String encargado;
	private String castrado;
	private String img_mascota;
	private String refugio;
	private String raza;
	private String vacuna;
	private String clasificacion;
	private String adoptante;
	private Boolean adoptado;
	
	public Mascota(int id, String img_mascota, String nombre_mascota, String edad, String clasificacion, String raza, 
			String vacuna, String castrado, String refugio, String encargado, String adoptante, Boolean adoptado) {
		
		this.id = id;
		this.img_mascota = img_mascota;
		this.nombre_mascota = nombre_mascota;
		this.edad = edad;
		this.clasificacion = clasificacion;
		this.raza = raza;
		this.vacuna = vacuna;
		this.castrado = castrado;
		this.refugio = refugio;
		this.encargado = encargado;
		this.adoptante = adoptante;
		this.adoptado = adoptado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCastrado() {
		return castrado;
	}

	public void setCastrado(String castrado) {
		this.castrado = castrado;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}


	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getImg_mascota() {
		return img_mascota;
	}

	public void setImg_mascota(String img_mascota) {
		this.img_mascota = img_mascota;
	}

	public String getRefugio() {
		return refugio;
	}

	public void setRefugio(String refugio) {
		this.refugio = refugio;
	}


	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getVacuna() {
		return vacuna;
	}

	public void setVacuna(String vacuna) {
		this.vacuna = vacuna;
	}
	

	public String getAdoptante() {
		return adoptante;
	}

	public void setAdoptante(String adoptante) {
		this.adoptante = adoptante;
	}

	public String getNombre_mascota() {
		return nombre_mascota;
	}

	public void setNombre_mascota(String nombre_mascota) {
		this.nombre_mascota = nombre_mascota;
	}

	
	public Boolean getAdoptado() {
		return adoptado;
	}

	public void setAdoptado(Boolean adoptado) {
		this.adoptado = adoptado;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	
	
}
