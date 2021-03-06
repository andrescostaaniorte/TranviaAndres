package com.transporte.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.transporte.modelos.Usuario;
import com.transporte.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {
	
	@Autowired
	UsuarioRepositorio repositorio;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	//CONTRASEÑA NECESARIA?
	public Usuario registrar(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return repositorio.save(u);
	}
	
	public Usuario findById(long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Usuario buscarPorEmail(String email) {
		return repositorio.findFirstByEmail(email);
	}

	public static Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Usuario nuevoUsuario) {
		// TODO Auto-generated method stub
		
	}

	public void edit(Usuario nuevoUsuario) {
		// TODO Auto-generated method stub
		
	}

	public void deleteUsuario(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}