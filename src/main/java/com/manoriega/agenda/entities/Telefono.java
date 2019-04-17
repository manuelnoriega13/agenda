package com.manoriega.agenda.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "telefonos")
public class Telefono {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero", nullable = false)
    private Long telefono;

    @ManyToOne
    @JoinColumn(name = "personas_id")
    private Persona persona;

}
