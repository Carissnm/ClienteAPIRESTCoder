package com.example.cliente_api_restpettinaroli.services;

import com.example.cliente_api_restpettinaroli.entities.Client;
import com.example.cliente_api_restpettinaroli.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;



    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }

    // Creo un método que llama al método para calcular la edad de Repository.
    public Integer getAge(LocalDate date) {
        return clientRepository.getAge(date);
    }

}
