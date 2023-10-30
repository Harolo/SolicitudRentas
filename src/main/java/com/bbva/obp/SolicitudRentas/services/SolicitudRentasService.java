package com.bbva.obp.SolicitudRentas.services;


import com.bbva.obp.SolicitudRentas.controllers.SolicitudRentasController;
import com.bbva.obp.SolicitudRentas.dto.RegistroSolicitudRentaElement;
import com.bbva.obp.SolicitudRentas.exception.ErrorException;
import com.bbva.obp.SolicitudRentas.obp.SoapClient;
import com.bbva.obp.SolicitudRentas.utils.AppProperties;
import com.bbva.obp.SolicitudRentas.utils.SolicitudRentasMappers.SolicitudRentasMapper;
import com.bbva.obp.SolicitudRentas.wsdl.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;

@Service
public class SolicitudRentasService {

    @Autowired
    SoapClient soapClient;

    @Autowired
    private AppProperties appProperties;
    private static final Logger logger = LogManager.getLogger(SolicitudRentasController.class);




    public ResultadoDTO registrarSolicitud(RegistroSolicitudRentaElement registroSolicitudRenta) {
        SolicitudRenta solicitudRenta = SolicitudRentasMapper.mapToSolicitudRentas(registroSolicitudRenta);
        ResultadoDTO resultado = soapClient.registrarSolicitudRentas(solicitudRenta);

        String codigoTransaccion = resultado.getTipoCodigoTransaccion().getValue();

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String currentDate = dateFormat.format(new Date());

        int benefs = registroSolicitudRenta.getTipoBeneficiarios().size();

        for (int i = 0; i<benefs; i++){
            String logToSave = registroSolicitudRenta.getTipoCausante().getTipoDocumento() + "\t" + codigoTransaccion + "\n";
            logger.info("Log de respuesta: {}", logToSave);


            if (codigoTransaccion.equals("00")){
                String path = appProperties.getResponsesLogsPath() + appProperties.getPrefixLogOk() + currentDate + ".txt";
                registrarEnLog(path, logToSave);
            }
            else {
                String path = appProperties.getResponsesLogsPath() + appProperties.getPrefixLogErr() + currentDate + ".txt";
                registrarEnLog(path, logToSave);
            }
            logger.info("Log de respuesta guardado");
        }
        logger.info("Codigo Respuesta: {}", resultado.getTipoCodigoTransaccion().getValue());

        return resultado;
    }


    public void registrarEnLog(String archivoLog, String contenido) {
        try {
            File logFile = new File(archivoLog);
            File logDir = logFile.getParentFile();

            if (!logDir.exists() && !logDir.mkdirs()) {
                throw new ErrorException("Error al crear el directorio ", logDir);
            }

            if (!logFile.exists()) {
                if (!logFile.createNewFile()) {
                    throw new ErrorException("Error al crear el archivo ", logFile);
                }
            }
            try (PrintWriter printWriter = new PrintWriter(new FileWriter(archivoLog, true))) {
                printWriter.println(contenido);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
