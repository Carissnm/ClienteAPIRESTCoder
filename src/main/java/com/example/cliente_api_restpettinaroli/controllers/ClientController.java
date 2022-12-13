package com.example.cliente_api_restpettinaroli.controllers;

import com.example.cliente_api_restpettinaroli.entities.Client;
import com.example.cliente_api_restpettinaroli.entities.ClientDTO;
import com.example.cliente_api_restpettinaroli.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.Optional;

import static java.lang.String.valueOf;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getClientById(@PathVariable(name = "id") Long id) {
        Optional<Client> client = clientService.findClientById(id);
        LocalDate birthday = client.get().getBirthday();
        Integer age = clientService.getAge(birthday);

        if (client.isPresent()) {
            ClientDTO clientDTO = new ClientDTO(client.get().getName(), client.get().getSurname(), age);
            return ResponseEntity.ok(clientDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> saveClient(@RequestBody Client client) {
        try {
            Client savedClient =
                    clientService.createClient(client);
            return ResponseEntity.created(URI.create("")).body(savedClient);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
