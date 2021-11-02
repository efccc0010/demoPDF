package com.cjava.demopdf.servicio;

import com.cjava.demopdf.modelo.Ciudad;
import com.cjava.demopdf.repositorio.CiudadRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadServicio implements ICiudadServicio {

    @Autowired
    private CiudadRepositorio repositorio;

    @Override
    public List<Ciudad> findAll() {

        return (List<Ciudad>) repositorio.findAll();
    }
}
