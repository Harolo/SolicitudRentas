package com.bbva.obp.SolicitudRentas.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.StringJoiner;

@Setter
@Getter
@NoArgsConstructor
public class BeneficiariosInputDTO {

    // TODO: cambiar por enum TipoTipoBeneficiario
    private String tipoTipoBeneficiario;
    
    // TODO: cambiar por enum TipoTipoDocumento
    private String tipoTipoDocumento;

    private String tipoDocumento;

    private String tipoPrimerApellido;

    private String tipoSegundoApellido;

    private String tipoPrimerNombre;

    private String tipoSegundoNombre;

    // TODO: cambiar por enum TipoGenero
    private String tipoGenero;

    private String tipoFechaNacimiento;

    // TODO: cambiar por enum TipoIndEstudiaAct
    private String tipoIndEstudiaAct;

    // TODO: cambiar por enum TipoIndDependeEco
    private String tipoIndDependeEco;

    // TODO: cambiar por enum TipoEstadoExpedicion
    private String tipoEstadoExpedicion;

    // TODO: cambiar por enum TipoEstadoActual
    private String tipoEstadoActual;

    // TODO: cambiar por enum TemporBeneficiario
    private String temporBeneficiario;

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(";");
        joiner.add(tipoTipoBeneficiario)
                .add(tipoTipoDocumento)
                .add(tipoDocumento)
                .add(tipoPrimerApellido)
                .add(tipoSegundoApellido)
                .add(tipoPrimerNombre)
                .add(tipoSegundoNombre)
                .add(tipoGenero)
                .add(tipoFechaNacimiento)
                .add(tipoIndEstudiaAct)
                .add(tipoIndDependeEco)
                .add(tipoEstadoExpedicion)
                .add(tipoEstadoActual)
                .add(temporBeneficiario);
        return joiner.toString();
    }
}
