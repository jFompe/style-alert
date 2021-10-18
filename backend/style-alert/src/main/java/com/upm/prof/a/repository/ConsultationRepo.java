package com.upm.prof.a.repository;

import java.util.List;
import java.util.Optional;

import com.upm.prof.a.persistence.Consultation;
import com.upm.prof.a.persistence.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, Long>{
    
    public Optional<Consultation> findById(Long id);

    public List<Consultation> findByUser(User user);

}
