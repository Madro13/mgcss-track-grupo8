package com.mgcss.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SolicitudTest {

	@Test
	void noDebePermitirCerrarSolicitudSiNoEstaEnProceso() {
		Cliente cliente  = new Cliente(1L, "Jose", "jose@email.com", EstadoCliente.STANDARD);
		Solicitud solicitud = new Solicitud(1L, cliente, "Fallo en el teclado", EstadoSolicitud.ABIERTA);
		
		assertThrows(IllegalStateException.class, solicitud::cerrar);
		assertEquals(EstadoSolicitud.ABIERTA, solicitud.getEstado());
	}

	@Test
    void debePermitirCerrarSolicitudSiEstaEnProceso() {
        Cliente cliente = new Cliente(1L, "Jose", "jose@email.com", EstadoCliente.STANDARD);
        Solicitud solicitud = new Solicitud(1L, cliente, "Fallo en el teclado", EstadoSolicitud.EN_PROCESO);

        solicitud.cerrar();

        assertEquals(EstadoSolicitud.CERRADA, solicitud.getEstado());
        assertNotNull(solicitud.getFechaCierre());
    }

    @Test
    void noDebePermitirAsignarTecnicoInactivo() {
        Cliente cliente = new Cliente(1L, "Jose", "jose@email.com", EstadoCliente.STANDARD);
        Solicitud solicitud = new Solicitud(1L, cliente, "No deja escribir", EstadoSolicitud.ABIERTA);
        Tecnico tecnico = new Tecnico(1L, "Luis", "Hardware", false);

        assertThrows(IllegalStateException.class, () -> solicitud.asignarTecnico(tecnico));
        assertNull(solicitud.getTecnicoAsignado());
    }

    @Test
    void debePermitirAsignarTecnicoActivo() {
        Cliente cliente = new Cliente(1L, "Jose", "jose@email.com", EstadoCliente.STANDARD);
        Solicitud solicitud = new Solicitud(1L, cliente, "No deja escribir", EstadoSolicitud.ABIERTA);
        Tecnico tecnico = new Tecnico(1L, "Luis", "Hardware", true);

        solicitud.asignarTecnico(tecnico);

        assertEquals(tecnico, solicitud.getTecnicoAsignado());
    }
}