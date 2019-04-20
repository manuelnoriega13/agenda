package com.manoriega.agenda.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String pais;

    @Column(length = 45, nullable = false)
    private String estado;

    @Column(length = 45, nullable = false)
    private String ciudad;

    @Column(length = 45, nullable = false)
    private String calle;

    @Column(length = 45, nullable = false)
    private String numero;

    @Column(length = 45, nullable = false)
    private String piso;

    @Column(length = 45, nullable = false)
    private String departamento;

    @Column(nullable = false)
    private Boolean principal;

    @ManyToOne
    @JoinColumn(name = "personas_id")
    private Persona persona;
}
