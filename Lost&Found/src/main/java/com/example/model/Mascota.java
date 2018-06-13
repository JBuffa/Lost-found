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
	private String vacunas;
	private String adoptante;
	
	public Mascota(int id, String nombre_mascota, String edad, String encargado, String castrado, String img_mascota, String raza,  String vacunas, String refugio, String adoptante) {
		this.id = id;
		this.nombre_mascota = nombre_mascota;
		this.edad = edad;
		this.encargado = encargado;
		this.castrado = castrado;
		this.img_mascota = img_mascota;
		this.refugio = refugio;
		this.raza = raza;
		this.vacunas = vacunas;
		this.adoptante = adoptante;
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

	public String getVacunas() {
		return vacunas;
	}

	public void setVacunas(String vacunas) {
		this.vacunas = vacunas;
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

	
	
	
}
