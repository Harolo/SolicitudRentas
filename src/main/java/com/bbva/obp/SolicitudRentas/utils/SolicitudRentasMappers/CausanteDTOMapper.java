package com.bbva.obp.SolicitudRentas.utils.SolicitudRentasMappers;

import com.bbva.obp.SolicitudRentas.dto.CausanteInputDTO;
import com.bbva.obp.SolicitudRentas.utils.DateParse;
import com.bbva.obp.SolicitudRentas.wsdl.*;

public class CausanteDTOMapper {
    private static final ObjectFactory objectFactoryCausante = new ObjectFactory();

    public static CausanteDTO mapToCausanteDTO(CausanteInputDTO input){
        CausanteDTO causanteDTO = new CausanteDTO();

        causanteDTO.setTipoIdentificacion( TipoIdentificacion.valueOf(input.getTipoIdentificacion()) );
        causanteDTO.setTipoDocumento( input.getTipoDocumento() );
        causanteDTO.setTipoPrimerApellido( input.getTipoPrimerApellido() );
        causanteDTO.setTipoSegundoApellido(
                objectFactoryCausante.createCausanteDTOTipoSegundoApellido( input.getTipoSegundoApellido() )
        );
        causanteDTO.setTipoPrimerNombre( input.getTipoPrimerNombre() );
        causanteDTO.setTipoSegundoNombre(
                objectFactoryCausante.createCausanteDTOTipoSegundoNombre( input.getTipoSegundoNombre() )
        );
        causanteDTO.setTipoGenero( TipoGenero2.valueOf(input.getTipoGenero()) );
        causanteDTO.setTipoFechaNacimiento( DateParse.createGregorianCalendar( input.getTipoFechaNacimiento() ));
        causanteDTO.setTipoEstadoExpedicion( TipoEstadoExpedicion2.valueOf(input.getTipoEstadoExpedicion()) );
        causanteDTO.setTipoEstadoActual( TipoEstadoActual2.valueOf(input.getTipoEstadoActual()) );

        return causanteDTO;
    }
}
