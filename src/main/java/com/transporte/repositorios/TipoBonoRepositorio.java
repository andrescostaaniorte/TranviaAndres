package com.transporte.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transporte.modelos.TipoBono;

public interface TipoBonoRepositorio extends JpaRepository<TipoBono, Long>{

//	TipoBono findByNombre(String nombreBono);
//	
//	TipoBono findByPrecio(Double precioBono);

}