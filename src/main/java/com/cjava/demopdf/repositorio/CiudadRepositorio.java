package com.cjava.demopdf.repositorio;

import com.cjava.demopdf.modelo.Ciudad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepositorio extends CrudRepository<Ciudad, Long> {

}
