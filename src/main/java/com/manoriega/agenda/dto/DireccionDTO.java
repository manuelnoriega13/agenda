package com.manoriega.agenda.dto;

import com.manoriega.agenda.entities.Persona;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DireccionDTO {
    private Long id;
    private String pais;
    private String estado;
    private String ciudad;
    private String calle;
    private String numero;
    private String piso;
    private String departamento;
    private Boolean principal;
    private Persona persona;

}
