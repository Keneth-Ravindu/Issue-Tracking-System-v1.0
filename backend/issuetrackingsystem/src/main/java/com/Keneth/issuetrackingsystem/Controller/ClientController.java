package com.Keneth.issuetrackingsystem.Controller;

import com.Keneth.issuetrackingsystem.Service.ClientService;
import com.Keneth.issuetrackingsystem.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/client")
@CrossOrigin

public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/add")
    public String add(@RequestBody Client client) {
        clientService.saveClient(client);
        return "New Client with a new issue is added";
    }

    @GetMapping("/getAll")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable("id") Integer id, @RequestBody Client client){
        try{
            Client updatedClient = clientService.updateClient(id, client);
            if (updatedClient != null){
                return ResponseEntity.ok().body(updatedClient);
            }else {
                return ResponseEntity.notFound().build();
            }
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        clientService.deleteClientById(id);
        return "Deleted Client with id " +id;
    }


}
