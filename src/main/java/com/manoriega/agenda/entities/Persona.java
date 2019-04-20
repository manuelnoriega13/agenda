package com.manoriega.agenda.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Personas")
public class Persona {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre1", length = 45, nullable = false)
    private String primerNombre;

    @Column(name = "nombre2", length = 45, nullable = true)
    private String segundoNombre;

    @Column(name = "apellido1", length = 45, nullable = false)
    private String primerApellido;

    @Column(name = "apellido2", length = 45, nullable = true)
    private String segundoApellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "activo")
    private Boolean activo = true;


    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "personas_id")
    private List<Direccion> direccionList;
    //
    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Telefono> telefonoSet;
    //
    @OneToMany(mappedBy = "persona",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "personas_id")
    private Set<Email> emailSet;
}
