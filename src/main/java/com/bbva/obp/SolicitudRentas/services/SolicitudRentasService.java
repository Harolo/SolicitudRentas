package com.bbva.obp.SolicitudRentas.services;


import com.bbva.obp.SolicitudRentas.controllers.SolicitudRentasController;
import com.bbva.obp.SolicitudRentas.dto.RegistroSolicitudRentaElement;
import com.bbva.obp.SolicitudRentas.obp.SoapClient;
import com.bbva.obp.SolicitudRentas.utils.AppProperties;
import com.bbva.obp.SolicitudRentas.utils.SolicitudRentasMappers.SolicitudRentasMapper;
import com.bbva.obp.SolicitudRentas.wsdl.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SolicitudRentasService {

    @Autowired
    SoapClient soapClient;

    @Autowired
    private AppProperties appProperties;
    private static final Logger logger = LogManager.getLogger(SolicitudRentasController.class);



    public ResultadoDTO registrarSolicitud(RegistroSolicitudRentaElement registroSolicitudRenta) {

        SolicitudRenta solicitudRenta = SolicitudRentasMapper.mapToSolicitudRentas(registroSolicitudRenta);
        // System.out.println("Solicitud Renta OBP => " + solicitudRenta);
        logger.info("Solicitud Renta OBP => {}", solicitudRenta.toString());

        ResultadoDTO resultado = soapClient.registrarSolicitudRentas(solicitudRenta);

        String codigoTransaccion = resultado.getTipoCodigoTransaccion().getValue();

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String currentDate = dateFormat.format(new Date());

        int benefs = registroSolicitudRenta.getTipoBeneficiarios().size();

        for (int i = 0; i<benefs; i++){
            String logToSave = registroSolicitudRenta.toStringABene(i) + ";" + codigoTransaccion;
            // System.out.println("Log de respuesta => " + logToSave);
            logger.info("Log de respuesta  => {}", logToSave);


            if (codigoTransaccion.equals("00")){
                String path = appProperties.getResponsesLogsPath() + appProperties.getPrefixLogOk() + currentDate + ".txt";
                registrarEnLog(path, logToSave);
            }
            else {
                String path = appProperties.getResponsesLogsPath() + appProperties.getPrefixLogErr() + currentDate + ".txt";
                registrarEnLog(path, logToSave);
            }
            logger.info("Log de respuesta guardado");
            // System.out.println("Log de respuesta guardado");
        }
        // System.out.println("Codigo Respuesta => " + resultado.getTipoCodigoTransaccion().getValue());
        logger.info("Codigo Respuesta => {}", resultado.getTipoCodigoTransaccion().getValue());
        return resultado;
    }


    public void registrarEnLog(String archivoLog, String contenido) {
        try {
            File logFile = new File(archivoLog);
            File logDir = logFile.getParentFile();

            if (!logDir.exists() && !logDir.mkdirs()) {
                throw new RuntimeException("Error al crear el directorio " + logDir);
            }

            if (!logFile.exists()) {
                if (!logFile.createNewFile()) {
                    throw new RuntimeException("Error al crear el archivo " + logFile);
                }
                String headers = getHeadersFromClasses(CausanteDTO.class, RentaDTO.class, BeneficiariosDTO.class);
                try (FileWriter fileWriter = new FileWriter(archivoLog, false)) {
                    fileWriter.write(headers);
                }
            }

            try (PrintWriter printWriter = new PrintWriter(new FileWriter(archivoLog, true))) {
                printWriter.println(contenido);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHeadersFromClasses(Class<?>... classes) {
        StringBuilder headers = new StringBuilder();

        for (Class<?> aClass : classes) {
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                if (BeneficiariosDTO.class.isAssignableFrom(aClass)) {
                    headers.append(field.getName()).append("Benef").append(";");
                } else {
                    headers.append(field.getName()).append(";");
                }
            }
        }
        headers.append("CodigoTransaccion\n");
        return headers.toString();
    }
}
