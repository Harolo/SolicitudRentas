package com.bbva.obp.SolicitudRentas.utils.SolicitudRentasMappers;

import com.bbva.obp.SolicitudRentas.dto.BeneficiariosInputDTO;
import com.bbva.obp.SolicitudRentas.utils.DateParse;
import com.bbva.obp.SolicitudRentas.wsdl.*;

import java.util.ArrayList;
import java.util.List;

public class BeneficiariosDTOMapper {

    private static final ObjectFactory objectFactory = new ObjectFactory();

    public static List<BeneficiariosDTO> mapToListBeneficiariosDTO(List<BeneficiariosInputDTO> input){
        List<BeneficiariosDTO> beneficiariosDTO =  new ArrayList<>();
        for (BeneficiariosInputDTO inputBeneficiario : input){
            beneficiariosDTO.add( BeneficiariosDTOMapper.mapToBeneficiariosDTO( inputBeneficiario ) );
        }
        return beneficiariosDTO;
    }

    public static BeneficiariosDTO mapToBeneficiariosDTO(BeneficiariosInputDTO input){
        BeneficiariosDTO beneficiariosDTO = new BeneficiariosDTO();
        beneficiariosDTO.setTipoTipoBeneficiario(TipoTipoBeneficiario.valueOf(input.getTipoTipoBeneficiario()) );
        beneficiariosDTO.setTipoTipoDocumento(objectFactory.createBeneficiariosDTOTipoTipoDocumento(
                TipoTipoDocumento.valueOf(input.getTipoTipoDocumento())
        ));

        beneficiariosDTO.setTipoDocumento( objectFactory.createBeneficiariosDTOTipoDocumento( input.getTipoDocumento() ));
        beneficiariosDTO.setTipoPrimerApellido( objectFactory.createBeneficiariosDTOTipoPrimerApellido( input.getTipoPrimerApellido() ));
        beneficiariosDTO.setTipoSegundoApellido( objectFactory.createBeneficiariosDTOTipoSegundoApellido( input.getTipoSegundoApellido() ));
        beneficiariosDTO.setTipoPrimerNombre( objectFactory.createBeneficiariosDTOTipoPrimerNombre( input.getTipoPrimerNombre() ));
        beneficiariosDTO.setTipoSegundoNombre( objectFactory.createBeneficiariosDTOTipoSegundoNombre( input.getTipoSegundoNombre() ));
        beneficiariosDTO.setTipoGenero( objectFactory.createBeneficiariosDTOTipoGenero(
                TipoGenero.valueOf(input.getTipoGenero())
        ));
        beneficiariosDTO.setTipoFechaNacimiento( objectFactory.createBeneficiariosDTOTipoFechaNacimiento(
                DateParse.createGregorianCalendar(input.getTipoFechaNacimiento())
        ));
        beneficiariosDTO.setTipoIndEstudiaAct( objectFactory.createBeneficiariosDTOTipoIndEstudiaAct(
                TipoIndEstudiaAct.valueOf(input.getTipoIndEstudiaAct())
        ));
        beneficiariosDTO.setTipoIndDependeEco( objectFactory.createBeneficiariosDTOTipoIndDependeEco(
                TipoIndDependeEco.valueOf(input.getTipoIndDependeEco())
        ));
        beneficiariosDTO.setTipoEstadoExpedicion( objectFactory.createBeneficiariosDTOTipoEstadoExpedicion(
                TipoEstadoExpedicion.valueOf(input.getTipoEstadoExpedicion())
        ));
        beneficiariosDTO.setTipoEstadoActual( objectFactory.createBeneficiariosDTOTipoEstadoActual(
                TipoEstadoActual.valueOf(input.getTipoEstadoActual())
        ));
        beneficiariosDTO.setTemporBeneficiario( objectFactory.createBeneficiariosDTOTemporBeneficiario(
                TemporBeneficiario.valueOf(input.getTemporBeneficiario())
        ));

        return beneficiariosDTO;
    }
}
