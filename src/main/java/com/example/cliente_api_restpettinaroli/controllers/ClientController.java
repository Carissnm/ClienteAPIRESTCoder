package com.example.cliente_api_restpettinaroli.controllers;

import com.example.cliente_api_restpettinaroli.entities.Client;
import com.example.cliente_api_restpettinaroli.entities.ClientDTO;
import com.example.cliente_api_restpettinaroli.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        if (client.isPresent()) {
            LocalDate birthday = client.get().getBirthday(); // capturo la edad del cliente.
            Integer age = clientService.getAge(birthday); // utilizo el método creado en service.
            //Instancio clientDTO para poder mostrar nombre y apellido del cliente más el dato de la edad.
            ClientDTO clientDTO = new ClientDTO(client.get().getName(), client.get().getSurname(), age);
            return ResponseEntity.ok(clientDTO);
        } else {
            return new ResponseEntity<>("Sorry, we couldn't find Client with id " + id, HttpStatus.NOT_FOUND);
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
