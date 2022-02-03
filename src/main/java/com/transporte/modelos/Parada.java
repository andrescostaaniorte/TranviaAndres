package com.transporte.modelos;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Parada {

	@Id @GeneratedValue
	private long idParada;
	
	public String nombreParada;
	
	
	//QUITAMOS MODELO DE ZONA Y LO HACEMOS ATRIBUTO
	
	//PREGUNTAR SI HACE FALTA DEJARLO AQUI Y SI AÑADIMOS PRECIO ZONA YA QUE NO TENEMOS TICKET
	private String zona;
	
	
	//CONSTRUCTORES
	public Parada() { }

	public Parada(long idParada, String nombreParada, String zona) {
		super();
		this.idParada = idParada;
		this.nombreParada = nombreParada;
		this.zona = zona;
	}

	public Parada(String nombreParada, String zona) {
		super();
		this.nombreParada = nombreParada;
		this.zona = zona;
	}


	public long getIdParada() {
		return idParada;
	}


	public void setIdParada(long idParada) {
		this.idParada = idParada;
	}


	public String getNombreParada() {
		return nombreParada;
	}


	public void setNombreParada(String nombreParada) {
		this.nombreParada = nombreParada;
	}


	public String getZona() {
		return zona;
	}


	public void setZona(String zona) {
		this.zona = zona;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idParada ^ (idParada >>> 32));
		result = prime * result + ((nombreParada == null) ? 0 : nombreParada.hashCode());
		result = prime * result + ((zona == null) ? 0 : zona.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Parada other = (Parada) obj;
		if (idParada != other.idParada) {
			return false;
		}
		if (nombreParada == null) {
			if (other.nombreParada != null) {
				return false;
			}
		} else if (!nombreParada.equals(other.nombreParada)) {
			return false;
		}
		if (zona == null) {
			if (other.zona != null) {
				return false;
			}
		} else if (!zona.equals(other.zona)) {
			return false;
		}
		return true;
	}


	@Override
	public String toString() {
		return "Parada [idParada=" + idParada + ", nombreParada=" + nombreParada + ", zona=" + zona + "]";
	}
	
	
}
