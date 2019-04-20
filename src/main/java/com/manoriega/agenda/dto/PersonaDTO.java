package com.manoriega.agenda.dto;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonaDTO {

    private Long id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private Boolean activo = true;
    private List<DireccionDTO> direccionDTOList;
    private Set<TelefonoDTO> telefonoDTOSet;
    private Set<EmailDTO> emailDTOSet;
}
