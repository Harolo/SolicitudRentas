package com.bbva.obp.SolicitudRentas.utils.SolicitudRentasMappers;


import com.bbva.obp.SolicitudRentas.dto.RentaInputDTO;
import com.bbva.obp.SolicitudRentas.utils.DateParse;
import com.bbva.obp.SolicitudRentas.wsdl.ObjectFactory;
import com.bbva.obp.SolicitudRentas.wsdl.RentaDTO;
import com.bbva.obp.SolicitudRentas.wsdl.TipoModalidadPrestacion;
import com.bbva.obp.SolicitudRentas.wsdl.TipoOrigenPrestacion;

public class RentasDTOMapper {

    public static final ObjectFactory rentasObjectFactory = new ObjectFactory();

    public static RentaDTO mapToRentaDTO(RentaInputDTO input){
        RentaDTO rentaDTO = new RentaDTO();
        rentaDTO.setTipoNumeroPoliza( input.getTipoNumeroPoliza() );
        rentaDTO.setTipoFechaExpedicion( DateParse.createGregorianCalendar( input.getTipoFechaExpedicion() ));
        rentaDTO.setTipoFechaDerecho( DateParse.createGregorianCalendar( input.getTipoFechaDerecho() ));
        rentaDTO.setTipoInteresTecnico( input.getTipoInteresTecnico() );
        rentaDTO.setTipoOrigenPrestacion( TipoOrigenPrestacion.valueOf(input.getTipoOrigenPrestacion()) );
        rentaDTO.setTipoModalidadPrestacion( TipoModalidadPrestacion.valueOf(input.getTipoModalidadPrestacion()) );
        rentaDTO.setTipoFechaInicioRenDif(
                rentasObjectFactory.createRentaDTOTipoFechaInicioRenDif(
                    DateParse.createGregorianCalendar( input.getTipoFechaInicioRenDif() )
                )
        );
        rentaDTO.setTipoAfpVen( input.getTipoAfpVen() );
        rentaDTO.setTipoValorMesada( input.getTipoValorMesada() );
        rentaDTO.setTipoNumeroMesadas( input.getTipoNumeroMesadas() );
        rentaDTO.setTipoValorReservaInVe( input.getTipoValorReservaInVe() );
        rentaDTO.setTipoValorReservaSob( input.getTipoValorReservaSob() );
        rentaDTO.setTipoValorReservaAux( input.getTipoValorReservaAux() );
        rentaDTO.setTipoValorOtrReserva( input.getTipoValorOtrReserva());
        rentaDTO.setTipoGastosAdmon( input.getTipoGastosAdmon() );
        rentaDTO.setTipoValorTotRes( input.getTipoValorTotRes() );
        String docSoporte = !input.getDocSoporteJudicial().equals("N") ? input.getDocSoporteJudicial() : "";

        rentaDTO.setDocSoporteJudicial(
                rentasObjectFactory.createRentaDTODocSoporteJudicial(docSoporte)
        );
        rentaDTO.setFechaDocSopteJud(
                rentasObjectFactory.createRentaDTOFechaDocSopteJud(
                        DateParse.createGregorianCalendar( input.getFechaDocSopteJud())
                )
        );
        rentaDTO.setObservacionesFalloJud(
                rentasObjectFactory.createRentaDTOObservacionesFalloJud(
                        input.getObservacionesFalloJud()
                )
        );
        return rentaDTO;
    }
}
