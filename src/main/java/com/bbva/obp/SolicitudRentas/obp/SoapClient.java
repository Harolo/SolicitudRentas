package com.bbva.obp.SolicitudRentas.obp;


import com.bbva.obp.SolicitudRentas.controllers.SolicitudRentasController;
import com.bbva.obp.SolicitudRentas.utils.AppProperties;
import com.bbva.obp.SolicitudRentas.wsdl.ObjectFactory;
import com.bbva.obp.SolicitudRentas.wsdl.ResultadoDTO;
import com.bbva.obp.SolicitudRentas.wsdl.SolicitudRenta;
import com.bbva.obp.SolicitudRentas.wsdl.TipoCodigoTransaccionE;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.xml.bind.JAXBElement;


public class SoapClient extends WebServiceGatewaySupport {


    @Value("${webService.uri}")
    private String soapWebServiceURI;

    @Autowired
    private Wss4jSecurityInterceptor securityInterceptor;

    @Autowired
    private HttpComponentsMessageSender messageSender;

    @Autowired
    private AppProperties appProperties;

    private static final Logger logger = LogManager.getLogger(SolicitudRentasController.class);


    public ResultadoDTO registrarSolicitudRentas(SolicitudRenta solicitudRenta) {

        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        webServiceTemplate.setInterceptors(new ClientInterceptor[]{ securityInterceptor });

        if (appProperties.isProxyUsed()){
            webServiceTemplate.setMessageSender(messageSender);
        }
        String caus = solicitudRenta.getTipoCausante().getTipoDocumento();
        JAXBElement<SolicitudRenta> request = new ObjectFactory().createRegistroSolicitudRentaElement(solicitudRenta);

        try {
            logger.info("Realizando comunicacion con OBP ...");

            JAXBElement<ResultadoDTO> response =  (JAXBElement<ResultadoDTO>) webServiceTemplate.marshalSendAndReceive(
                    soapWebServiceURI,
                    request
            );

            logger.info("Comunicacion exitosa. Respuesta: " + response.getValue().getTipoCodigoTransaccion().getValue());

            return response.getValue();
        }
        catch (Exception e) {
            logger.info("Error en comunicacion con OBP => " + e.getMessage());

            e.printStackTrace();
            ResultadoDTO resultado = new ResultadoDTO();
            TipoCodigoTransaccionE tipoCodTransaccion = new TipoCodigoTransaccionE();
            tipoCodTransaccion.setValue("Error: " + e.getMessage().replace(";", ","));
            resultado.setTipoCodigoTransaccion( tipoCodTransaccion );
            return resultado;
        }

    }
}
