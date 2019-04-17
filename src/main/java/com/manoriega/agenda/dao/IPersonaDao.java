package com.manoriega.agenda.dao;

import com.manoriega.agenda.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaDao extends JpaRepository<Persona, Long> {
}
