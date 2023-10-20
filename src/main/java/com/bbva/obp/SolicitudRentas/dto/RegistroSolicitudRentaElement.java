package com.bbva.obp.SolicitudRentas.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class RegistroSolicitudRentaElement {

    private CausanteInputDTO tipoCausante;

    private RentaInputDTO tipoRenta;

    private List<BeneficiariosInputDTO> tipoBeneficiarios;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tipoBeneficiarios.size(); i++) {
            sb.append(toStringABene(i));
            sb.append("\n");
        }
        return sb.toString();

    }

    public String toStringABene(int benefIndex) {
        return String.format("%s;%s;%s", tipoCausante, tipoRenta, tipoBeneficiarios.get(benefIndex));
    }
}
