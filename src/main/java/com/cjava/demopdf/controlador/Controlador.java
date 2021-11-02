package com.cjava.demopdf.controlador;

import com.cjava.demopdf.modelo.Ciudad;
import com.cjava.demopdf.servicio.ICiudadServicio;
import com.cjava.demopdf.util.GenerarPdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayInputStream;
import java.util.List;

@Controller
public class Controlador {

    @Autowired
    private ICiudadServicio ciudadServicio;

    @RequestMapping(value = "/reportePDF", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport() {

        var ciudades = (List<Ciudad>) ciudadServicio.findAll();

        ByteArrayInputStream bis = GenerarPdf.reporteCiudades(ciudades);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = ReporteCiudades.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}