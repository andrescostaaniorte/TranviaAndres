package com.transporte.modelos;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
	
	//PRUEBA DE EDICION DESDE GITHUB
	
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
	private Pago saldo;
	
	//CADA USUARIO PUEDE TENER VARIOS VIAJES EN UN MISMO DIA
	@OneToMany
	List<ViajeGastado> viajeGastado;
	
	
	private String email;
	private String password;
	
	
	//CAMPOS DE BONO

	@Id @GeneratedValue
	private long idBono;
	
	@OneToMany
	private TipoBono tipoBono;

	
	//GENERAR QR/NFC PARA CADA USUARIO (DEJARLO PARA FINAL/NO IMPRESCINDIBLE)
	
	
	
	//CONSTRUCTORES
	public Usuario() { }

	public Usuario(long idUsuario, String nombre, String apellidos, String dni, Date fechaAlta, Pago saldo,
			List<ViajeGastado> viajeGastado, String email, String password, long idBono, TipoBono tipoBono) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaAlta = fechaAlta;
		this.saldo = saldo;
		this.viajeGastado = viajeGastado;
		this.email = email;
		this.password = password;
		this.idBono = idBono;
		this.tipoBono = tipoBono;
	}
	
	public Usuario(String nombre, String apellidos, String dni, Date fechaAlta, Pago saldo,
			List<ViajeGastado> viajeGastado, String email, String password, long idBono, TipoBono tipoBono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaAlta = fechaAlta;
		this.saldo = saldo;
		this.viajeGastado = viajeGastado;
		this.email = email;
		this.password = password;
		this.idBono = idBono;
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

	public Pago getSaldo() {
		return saldo;
	}

	public void setSaldo(Pago saldo) {
		this.saldo = saldo;
	}

	public List<ViajeGastado> getViajeGastado() {
		return viajeGastado;
	}

	public void setViajeGastado(List<ViajeGastado> viajeGastado) {
		this.viajeGastado = viajeGastado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getIdBono() {
		return idBono;
	}

	public void setIdBono(long idBono) {
		this.idBono = idBono;
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
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
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
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (saldo == null) {
			if (other.saldo != null) {
				return false;
			}
		} else if (!saldo.equals(other.saldo)) {
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
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni
				+ ", fechaAlta=" + fechaAlta + ", saldo=" + saldo + ", viajeGastado=" + viajeGastado + ", email="
				+ email + ", password=" + password + ", idBono=" + idBono + ", tipoBono=" + tipoBono + "]";
	}
	
	
}
