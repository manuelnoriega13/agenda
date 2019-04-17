package com.manoriega.agenda.dao;

import com.manoriega.agenda.entities.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmailDao extends JpaRepository<Email, Long> {
}
