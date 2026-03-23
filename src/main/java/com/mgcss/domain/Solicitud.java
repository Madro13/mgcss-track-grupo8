package com.mgcss.domain;

import java.util.Date;

public class Solicitud {
	
	private Long id;
	private String descripcion;
	private EstadoSolicitud estado;
	private Date fechaCreacion;
	private Date fechaCierre;
	
	public Solicitud() {}
	
	public Solicitud(Long id, String descripcion, EstadoSolicitud estado) {
		this.id = id;
		this.descripcion = descripcion;
		this.estado = estado;
		this.fechaCreacion = new Date();
		this.fechaCierre = null;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public EstadoSolicitud getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoSolicitud estado) {
		this.estado = estado;
	}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public Date getFechaCierre() {
		return fechaCierre;
	}
	
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	
	public void cerrar() {
		if (estado != EstadoSolicitud.EN_PROCESO) {
			throw new IllegalStateException("Sólo se podría cerrar la solicitud que está EN_PROCESO");
		}
		estado = EstadoSolicitud.CERRADA;
		fechaCierre = new Date();
	}

}
