package com.transporte.modelos;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class TipoBono {
	@Id @GeneratedValue
	private long idTipoBono;
	
	private String nombreBono;
	
	//PRECIO DEL BONO CUANDO LO COMPRAS LA PRIMERA VEZ (O SI CAMBIAS)
	private double precioBono;
	
	//LA PARTE QUE DESCUENTA EL BONO PARA LUEGO RESTARLA A NUESTRO SALDO
	private double costeViaje;

	
	//CONSTRUCTORES
	public TipoBono() { }

	public TipoBono(long idTipoBono, String nombreBono, double precioBono, double costeViaje) {
		super();
		this.idTipoBono = idTipoBono;
		this.nombreBono = nombreBono;
		this.precioBono = precioBono;
		this.costeViaje = costeViaje;
	}

	public TipoBono(String nombreBono, double precioBono, double costeViaje) {
		super();
		this.nombreBono = nombreBono;
		this.precioBono = precioBono;
		this.costeViaje = costeViaje;
	}

	//GETTERS AND SETTERS
	public long getIdTipoBono() {
		return idTipoBono;
	}

	public void setIdTipoBono(long idTipoBono) {
		this.idTipoBono = idTipoBono;
	}

	public String getNombreBono() {
		return nombreBono;
	}

	public void setNombreBono(String nombreBono) {
		this.nombreBono = nombreBono;
	}

	public double getPrecioBono() {
		return precioBono;
	}

	public void setPrecioBono(double precioBono) {
		this.precioBono = precioBono;
	}

	public double getCosteViaje() {
		return costeViaje;
	}

	public void setCosteViaje(double costeViaje) {
		this.costeViaje = costeViaje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(costeViaje);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (idTipoBono ^ (idTipoBono >>> 32));
		result = prime * result + ((nombreBono == null) ? 0 : nombreBono.hashCode());
		temp = Double.doubleToLongBits(precioBono);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TipoBono other = (TipoBono) obj;
		if (Double.doubleToLongBits(costeViaje) != Double.doubleToLongBits(other.costeViaje)) {
			return false;
		}
		if (idTipoBono != other.idTipoBono) {
			return false;
		}
		if (nombreBono == null) {
			if (other.nombreBono != null) {
				return false;
			}
		} else if (!nombreBono.equals(other.nombreBono)) {
			return false;
		}
		if (Double.doubleToLongBits(precioBono) != Double.doubleToLongBits(other.precioBono)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TipoBono [idTipoBono=" + idTipoBono + ", nombreBono=" + nombreBono + ", precioBono=" + precioBono
				+ ", costeViaje=" + costeViaje + "]";
	}
	
	
}
