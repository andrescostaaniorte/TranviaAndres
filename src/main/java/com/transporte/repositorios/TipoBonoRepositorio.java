package com.transporte.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transporte.modelos.TipoBono;

@Repository
public interface TipoBonoRepositorio extends JpaRepository<TipoBono, Long>{

//	List<TipoBono> findByNombre(String nombreBono);
	
//	List<TipoBono> findByPrecio(Double precioBono);

}