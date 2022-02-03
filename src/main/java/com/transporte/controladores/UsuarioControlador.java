package com.transporte.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import com.transporte.modelos.Usuario;
import com.transporte.servicios.UsuarioServicio;
import com.transporte.upload.storage.StorageService;

@Controller
public class UsuarioControlador {

	@Autowired
	UsuarioServicio usuarioServicio;
	
	private String ficheroEnviado;
	
	
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
	
	
	//COPIADO DE EMPLEADOS
	
	@GetMapping({ "/usuarios" })
	public String listado(Model model) {
		model.addAttribute("listaUsuarios", UsuarioServicio.findAll());
		return "listadoUsuarios";
	}

	@GetMapping("/usuarios/new")
	public String nuevoUsuarioForm(Model model) {
		model.addAttribute("usuarioForm", new Usuario());
		return "usuarioForm";
	}

	@PostMapping("/usuarios/new/submit")
	public String nuevoUsuarioSubmit(@Valid @ModelAttribute("usuarioForm") Usuario nuevoUsuario,
			BindingResult bindingResult, @RequestParam("file") MultipartFile file) {

		if (bindingResult.hasErrors()) {
			return "usuarioForm";
		} else {
			if (!file.isEmpty()) {
				String avatar = StorageService.store(file, nuevoUsuario.getNombre());
				System.out.println("La imagen a guardar es : " + avatar);
				nuevoUsuario.setAvatar(MvcUriComponentsBuilder
						.fromMethodName(UsuarioControlador.class, "serveFile", avatar).build().toUriString());
			}
			usuarioServicio.add(nuevoUsuario);
			return "redirect:/usuarios";
		}
	}

	@GetMapping("/usuarios/edit/{id}")
	public String editarUsuarioForm(@PathVariable long id, Model model) {
		Usuario u = usuarioServicio.findById(id);
		if (u != null) {
			ficheroEnviado=(String) u.getAvatar(); //para controlar si cambia el fichero
			model.addAttribute("usuarioForm", u);
			return "usuarioForm";
		} else {
			return "redirect:/usuarios/new";
		}
	}
	
	@PostMapping("/usuarios/edit/submit")
	public String editarUsuariosPost(@Valid @ModelAttribute("usuarioForm") Usuario nuevoUsuario,
			BindingResult bindingResult, @RequestParam("file") MultipartFile file) {

		System.out.println(ficheroEnviado + ", " + file.getName());
		if (bindingResult.hasErrors()) {			
			return "usuarioForm";	
		} else {			
			if (!file.isEmpty()) {
				String avatar = StorageService.store(file, nuevoUsuario.getNombre());
				nuevoUsuario.setAvatar(MvcUriComponentsBuilder
						.fromMethodName(UsuarioControlador.class, "serveFile", avatar).build().toUriString());
			}else {
				nuevoUsuario.setAvatar(ficheroEnviado);
			}
			usuarioServicio.edit(nuevoUsuario);
			return "redirect:/usuarios";
		}
	}
	
    @GetMapping("/usuarios/delete/{id}")
    public String deleteUsuario(@PathVariable("id") int id){
        usuarioServicio.deleteUsuario(id);
        return "redirect:/usuarios";
    }
}
