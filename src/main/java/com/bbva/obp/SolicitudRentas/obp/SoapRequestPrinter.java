package com.bbva.obp.SolicitudRentas.obp;


import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SoapRequestPrinter implements WebServiceMessageCallback {

    private String filePath;

    public SoapRequestPrinter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
        if (message instanceof SoapMessage) {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                ((SoapMessage) message).writeTo(outputStream);
                Path path = Paths.get(filePath);
                path.toFile().getParentFile().mkdirs();
                Files.write(path, outputStream.toByteArray());
            }
        }
    }
}
