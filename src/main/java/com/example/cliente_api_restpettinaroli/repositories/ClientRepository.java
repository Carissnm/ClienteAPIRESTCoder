package com.example.cliente_api_restpettinaroli.repositories;
import com.example.cliente_api_restpettinaroli.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public interface ClientRepository extends JpaRepository <Client, Long> {

    public default Integer getAge(LocalDate birthdate) {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}
