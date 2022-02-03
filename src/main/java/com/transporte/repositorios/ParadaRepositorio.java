package com.transporte.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transporte.modelos.Parada;

@Repository
public interface ParadaRepositorio extends JpaRepository<Parada, Long>{

//	List<Parada> findByNombre(String nombreParada);

}
