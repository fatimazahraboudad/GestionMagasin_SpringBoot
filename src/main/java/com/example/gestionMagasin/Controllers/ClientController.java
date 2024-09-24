package com.example.gestionMagasin.Controllers;

import com.example.gestionMagasin.Dtos.ClientDto;
import com.example.gestionMagasin.Services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("all")
    public List<ClientDto> all() {
        return clientService.getAllClient();
    }

    @PostMapping("addClient")
    public ClientDto addClient(@RequestBody ClientDto c) {
        return clientService.addClient(c);
    }

    @GetMapping("findById/{id}")
    public ClientDto ClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        return clientService.deeletClient(id);
    }

    @PutMapping("update/{id}")
    public ClientDto update(@PathVariable Long id, @RequestBody ClientDto c) {
        return clientService.updateClient(id, c);
    }
}
