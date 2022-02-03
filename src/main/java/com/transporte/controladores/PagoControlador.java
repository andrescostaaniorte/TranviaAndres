package com.transporte.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.transporte.servicios.UsuarioServicio;

@Controller
public class PagoControlador {

	@Autowired
	UsuarioServicio usuarioServicio;
}
