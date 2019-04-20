package com.manoriega.agenda.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class TelefonoTipoDTO {

    private Long id;
    private String descripcion;
}
