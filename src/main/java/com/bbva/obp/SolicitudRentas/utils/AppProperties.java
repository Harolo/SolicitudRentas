package com.bbva.obp.SolicitudRentas.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
        @PropertySource(value = "file:/de/app/solicitud_rentas.properties")
})
@Getter
public class AppProperties {

    @Value("${webService.uri}")
    private String soapWebServiceURI;

    @Value("${webService.WSUsername}")
    private String username;

    @Value("${webService.WSPass}")
    private String password;

    @Value("${proxy.host}")
    private String proxyHost;

    @Value("${proxy.port}")
    private int proxyPort;

    @Value("${spring.seguros.path}")
    private String responsesLogsPath;

    @Value("${spring.seguros.prefixLogOk}")
    private String prefixLogOk;

    @Value("${spring.seguros.prefixLogErr}")
    private String prefixLogErr;

    @Value("${proxy.used}")
    private boolean proxyUsed;


}
