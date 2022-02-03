package com.transporte.modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
	
	@Id @GeneratedValue
	private long idUsuario;
	
	private String nombre;
	private String apellidos;
	private String dni;
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;
	
	//UN USUARIO PUEDE REALIZAR UNO O MAS PAGOS
	//DEFINIMOS CANTIDAD DISPONIBLE PORQUE ES LO QUE NOS INTERESA DE PAGO
	@OneToMany
	List<Pago> pagos;
	
	//CADA USUARIO PUEDE TENER VARIOS VIAJES EN UN MISMO DIA
	@OneToMany
	List<ViajeGastado> viajesGastados;
	
	
	private String email;
	private String password;
	
	
	//CAMPOS DE BONO
	@Column(unique=true)
	private long idBono;
	private double saldoBono;
	
	@ManyToOne
	private TipoBono tipoBono;

	
	//GENERAR QR/NFC PARA CADA USUARIO (DEJARLO PARA FINAL/NO IMPRESCINDIBLE)
	
	
	
	//CONSTRUCTORES
	public Usuario() { }

	public Usuario(long idUsuario, String nombre, String apellidos, String dni, Date fechaAlta, List<Pago> pagos,
			List<ViajeGastado> viajesGastados, String email, String password, long idBono, double saldoBono,
			TipoBono tipoBono) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaAlta = fechaAlta;
		this.pagos = pagos;
		this.viajesGastados = viajesGastados;
		this.email = email;
		this.password = password;
		this.idBono = idBono;
		this.saldoBono = saldoBono;
		this.tipoBono = tipoBono;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	public List<ViajeGastado> getViajesGastados() {
		return viajesGastados;
	}

	public void setViajesGastados(List<ViajeGastado> viajesGastados) {
		this.viajesGastados = viajesGastados;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdBono() {
		return idBono;
	}

	public void setIdBono(long idBono) {
		this.idBono = idBono;
	}

	public double getSaldoBono() {
		return saldoBono;
	}

	public void setSaldoBono(double saldoBono) {
		this.saldoBono = saldoBono;
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
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + (int) (idBono ^ (idBono >>> 32));
		result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pagos == null) ? 0 : pagos.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		long temp;
		temp = Double.doubleToLongBits(saldoBono);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipoBono == null) ? 0 : tipoBono.hashCode());
		result = prime * result + ((viajesGastados == null) ? 0 : viajesGastados.hashCode());
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
		Usuario other = (Usuario) obj;
		if (apellidos == null) {
			if (other.apellidos != null) {
				return false;
			}
		} else if (!apellidos.equals(other.apellidos)) {
			return false;
		}
		if (dni == null) {
			if (other.dni != null) {
				return false;
			}
		} else if (!dni.equals(other.dni)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (fechaAlta == null) {
			if (other.fechaAlta != null) {
				return false;
			}
		} else if (!fechaAlta.equals(other.fechaAlta)) {
			return false;
		}
		if (idBono != other.idBono) {
			return false;
		}
		if (idUsuario != other.idUsuario) {
			return false;
		}
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		if (pagos == null) {
			if (other.pagos != null) {
				return false;
			}
		} else if (!pagos.equals(other.pagos)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (Double.doubleToLongBits(saldoBono) != Double.doubleToLongBits(other.saldoBono)) {
			return false;
		}
		if (tipoBono == null) {
			if (other.tipoBono != null) {
				return false;
			}
		} else if (!tipoBono.equals(other.tipoBono)) {
			return false;
		}
		if (viajesGastados == null) {
			if (other.viajesGastados != null) {
				return false;
			}
		} else if (!viajesGastados.equals(other.viajesGastados)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", fechaAlta=" + fechaAlta + ", pagos=" + pagos + ", viajesGastados=" + viajesGastados + ", email="
				+ email + ", password=" + password + ", idBono=" + idBono + ", saldoBono=" + saldoBono + ", tipoBono="
				+ tipoBono + "]";
	}

	
	//METODOS PARA LA SEGURIDAD
	public CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setPassword(String encode) {
		// TODO Auto-generated method stub
		
	}

	public void setAvatar(String uriString) {
		// TODO Auto-generated method stub
		
	}

	public Object getAvatar() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
