package com.manoriega.agenda.dto;

import com.manoriega.agenda.entities.Persona;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDTO {

    private Long id;
    private String email;
    private Persona persona;
}
