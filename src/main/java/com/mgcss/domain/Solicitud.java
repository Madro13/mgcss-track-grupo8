package com.mgcss.domain;

import java.util.Date;

public class Solicitud {
	
	private Long id;
	private String estado;
	private Date fechaCreacion = new Date();
	
	public Solicitud(Long id, String estado, Date fechaCreacion) {
		super();
		this.id = id;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
