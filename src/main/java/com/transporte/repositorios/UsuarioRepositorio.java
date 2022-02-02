package com.transporte.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transporte.modelos.Usuario;

//REPOSITORIO PARA ALMACENAR TODOS LOS USUARIOS Y PODER BUSCARLOS MEDIANTE
//LA FUNCION ByEmail EN UsuarioServicio

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Usuario findFirstByEmail(String email);

}
