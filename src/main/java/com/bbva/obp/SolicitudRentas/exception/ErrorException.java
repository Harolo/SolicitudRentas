package com.bbva.obp.SolicitudRentas.exception;

import java.io.File;

public class ErrorException extends RuntimeException{

    private File archivo;

    public ErrorException(String mensaje) {
        super(mensaje);
    }

    public ErrorException(String mensaje, File archivo) {
        super(mensaje);
        this.archivo = archivo;
    }

    public File getArchivo() {
        return archivo;
    }
}
