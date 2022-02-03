package com.transporte.modelos;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class ViajeGastado {
	
	@Id @GeneratedValue
	private long idViaje;
	
	//UN USUARIO PUEDE GASTAR MUCHOS VIAJES EN UN DIA
	@ManyToOne
	private Usuario idUsuario;
	//RELACION EN USUARIO
	
	
	private String origen;
	private String destino;
	private double coste;
	
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaViaje;
	
	
	//AL ESTAR RELACIONADO CON USUARIO Y USUARIO RELACONADO CON EL TIPO BONO NO HAY QUE DUPLICAR LA RELACION
	@ManyToOne
	private TipoBono tipoBono;

	
	//CONSTRUCTORES
	public ViajeGastado() { }

	public ViajeGastado(long idViaje, Usuario idUsuario, String origen, String destino, double coste, Date fechaViaje,
			TipoBono tipoBono) {
		super();
		this.idViaje = idViaje;
		this.idUsuario = idUsuario;
		this.origen = origen;
		this.destino = destino;
		this.coste = coste;
		this.fechaViaje = fechaViaje;
		this.tipoBono = tipoBono;
	}

	public ViajeGastado(Usuario idUsuario, String origen, String destino, double coste, Date fechaViaje,
			TipoBono tipoBono) {
		super();
		this.idUsuario = idUsuario;
		this.origen = origen;
		this.destino = destino;
		this.coste = coste;
		this.fechaViaje = fechaViaje;
		this.tipoBono = tipoBono;
	}

	public long getIdViaje() {
		return idViaje;
	}

	public void setIdViaje(long idViaje) {
		this.idViaje = idViaje;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public Date getFechaViaje() {
		return fechaViaje;
	}

	public void setFechaViaje(Date fechaViaje) {
		this.fechaViaje = fechaViaje;
	}

	public TipoBono getTipoBono() {
		return tipoBono;
	}

	public void setTipoBono(TipoBono tipoBono) {
		this.tipoBono = tipoBono;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coste);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((fechaViaje == null) ? 0 : fechaViaje.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + (int) (idViaje ^ (idViaje >>> 32));
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
		result = prime * result + ((tipoBono == null) ? 0 : tipoBono.hashCode());
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
		ViajeGastado other = (ViajeGastado) obj;
		if (Double.doubleToLongBits(coste) != Double.doubleToLongBits(other.coste)) {
			return false;
		}
		if (destino == null) {
			if (other.destino != null) {
				return false;
			}
		} else if (!destino.equals(other.destino)) {
			return false;
		}
		if (fechaViaje == null) {
			if (other.fechaViaje != null) {
				return false;
			}
		} else if (!fechaViaje.equals(other.fechaViaje)) {
			return false;
		}
		if (idUsuario == null) {
			if (other.idUsuario != null) {
				return false;
			}
		} else if (!idUsuario.equals(other.idUsuario)) {
			return false;
		}
		if (idViaje != other.idViaje) {
			return false;
		}
		if (origen == null) {
			if (other.origen != null) {
				return false;
			}
		} else if (!origen.equals(other.origen)) {
			return false;
		}
		if (tipoBono == null) {
			if (other.tipoBono != null) {
				return false;
			}
		} else if (!tipoBono.equals(other.tipoBono)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ViajeGastado [idViaje=" + idViaje + ", idUsuario=" + idUsuario + ", origen=" + origen + ", destino="
				+ destino + ", coste=" + coste + ", fechaViaje=" + fechaViaje + ", tipoBono=" + tipoBono + "]";
	}
	
	
}
