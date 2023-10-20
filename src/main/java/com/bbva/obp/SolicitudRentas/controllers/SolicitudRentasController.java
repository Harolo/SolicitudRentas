package com.bbva.obp.SolicitudRentas.controllers;

import com.bbva.obp.SolicitudRentas.dto.RegistroSolicitudRentaElement;
import com.bbva.obp.SolicitudRentas.services.SolicitudRentasService;
import com.bbva.obp.SolicitudRentas.wsdl.ResultadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitudRentas")
public class SolicitudRentasController {

    @Autowired
    private SolicitudRentasService solicitudRentasService;


    @PostMapping("/registrar")
    public ResponseEntity<ResultadoDTO> registrarSolicitudRentas(@RequestBody RegistroSolicitudRentaElement registroSolicitudRentaElement) {
        return new ResponseEntity<>(solicitudRentasService.registrarSolicitud(registroSolicitudRentaElement), HttpStatus.OK);
    }
}
