package com.transporte.modelos;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Pago {
	
	@Id @GeneratedValue
	private long idPago;
	
	//UN USUARIO PUEDE HACER VARIOS PAGOS
	@ManyToOne
	private Usuario idUsuario;
	//RELACION EN USUARIO
	
	//IMPORTE
	private double importe;
	
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;
	
	
	//CONSTRUCTORES
	public Pago() { }

	public Pago(long idPago, Usuario idUsuario, double importe, Date fechaIngreso) {
		super();
		this.idPago = idPago;
		this.idUsuario = idUsuario;
		this.importe = importe;
		this.fechaIngreso = fechaIngreso;
	}

	public Pago(Usuario idUsuario, double importe, Date fechaIngreso) {
		super();
		this.idUsuario = idUsuario;
		this.importe = importe;
		this.fechaIngreso = fechaIngreso;
	}

	public long getIdPago() {
		return idPago;
	}

	public void setIdPago(long idPago) {
		this.idPago = idPago;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@Override
	public String toString() {
		return "Pago [idPago=" + idPago + ", idUsuario=" + idUsuario + ", importe=" + importe + ", fechaIngreso=" + fechaIngreso + "]";
	}
	

}
