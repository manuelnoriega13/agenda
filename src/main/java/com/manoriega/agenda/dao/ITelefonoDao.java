package com.manoriega.agenda.dao;

import com.manoriega.agenda.entities.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITelefonoDao extends JpaRepository<Telefono, Long> {
}
