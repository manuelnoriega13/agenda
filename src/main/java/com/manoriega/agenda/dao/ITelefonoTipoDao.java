package com.manoriega.agenda.dao;

import com.manoriega.agenda.entities.TelefonoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITelefonoTipoDao extends JpaRepository<TelefonoTipo, Long> {
}
