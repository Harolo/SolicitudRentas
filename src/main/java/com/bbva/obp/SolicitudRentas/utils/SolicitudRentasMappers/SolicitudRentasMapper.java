package com.bbva.obp.SolicitudRentas.utils.SolicitudRentasMappers;


import com.bbva.obp.SolicitudRentas.dto.RegistroSolicitudRentaElement;
import com.bbva.obp.SolicitudRentas.wsdl.SolicitudRenta;


public class SolicitudRentasMapper {


    public static SolicitudRenta mapToSolicitudRentas(RegistroSolicitudRentaElement input){
        SolicitudRenta solicitudRenta = new SolicitudRenta();
        solicitudRenta.setTipoCausante( CausanteDTOMapper.mapToCausanteDTO( input.getTipoCausante() ) );
        solicitudRenta.setTipoRenta( RentasDTOMapper.mapToRentaDTO( input.getTipoRenta() ) );
        solicitudRenta.getTipoBeneficiarios().addAll(
                BeneficiariosDTOMapper.mapToListBeneficiariosDTO( input.getTipoBeneficiarios() )
        );

        return solicitudRenta;
    }


}
