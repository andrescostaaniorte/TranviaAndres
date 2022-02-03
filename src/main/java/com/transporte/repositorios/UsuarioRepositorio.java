package com.transporte.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transporte.modelos.Usuario;

//REPOSITORIO PARA ALMACENAR TODOS LOS USUARIOS Y PODER BUSCARLOS MEDIANTE
//LA FUNCION ByEmail EN UsuarioServicio

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	Usuario findFirstByEmail(String email);

}
