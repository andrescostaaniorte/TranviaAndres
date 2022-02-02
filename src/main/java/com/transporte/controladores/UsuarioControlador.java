package com.transporte.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.transporte.modelos.Usuario;
import com.transporte.servicios.UsuarioServicio;

@Controller
public class UsuarioControlador {

	@Autowired
	UsuarioServicio usuarioServicio;
	
	@GetMapping({"/","/auth/login"})
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@PostMapping("/auth/register")
	public String register(@ModelAttribute Usuario usuario) {		
		usuarioServicio.registrar(usuario);
		return "redirect:/auth/login";
	}
}
