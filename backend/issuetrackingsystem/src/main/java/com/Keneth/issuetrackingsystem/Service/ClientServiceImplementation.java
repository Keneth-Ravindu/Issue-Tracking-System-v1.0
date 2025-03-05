package com.Keneth.issuetrackingsystem.Service;

import com.Keneth.issuetrackingsystem.Repository.ClientRepository;
import com.Keneth.issuetrackingsystem.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImplementation  implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClientById(Integer id){
        clientRepository.deleteById(id);
    }

    @Override
    public Client updateClient(Integer id, Client client){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()){
            Client existingClient = optionalClient.get();
            existingClient.setName(client.getName());

            return clientRepository.save(existingClient);
        } else {
            return null;
        }

    }

}

