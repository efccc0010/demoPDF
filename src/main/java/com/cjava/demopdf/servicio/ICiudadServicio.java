package com.cjava.demopdf.servicio;


import com.cjava.demopdf.modelo.Ciudad;
import java.util.List;

public interface ICiudadServicio {

    List<Ciudad> findAll();
}
