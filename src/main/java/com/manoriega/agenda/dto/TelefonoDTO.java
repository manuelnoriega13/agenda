package com.manoriega.agenda.dto;

import com.manoriega.agenda.entities.Persona;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TelefonoDTO {

    private Long id;

    private Long telefono;

    private Persona persona;
}
