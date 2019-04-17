package com.manoriega.agenda.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "emails")
public class Email {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 45, nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "personas_id")
    private Persona persona;
}
