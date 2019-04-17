package com.manoriega.agenda.dao;

import com.manoriega.agenda.entities.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDireccionDao extends JpaRepository<Direccion, Long> {
}
