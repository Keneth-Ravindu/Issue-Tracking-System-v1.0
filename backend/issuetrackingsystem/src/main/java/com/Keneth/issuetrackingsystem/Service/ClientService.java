package com.Keneth.issuetrackingsystem.Service;

import com.Keneth.issuetrackingsystem.model.Client;

import java.util.List;


public interface ClientService {
    public Client saveClient(Client client);
    public List<Client> getAllClients();
    public void deleteClientById(Integer id);
    public Client updateClient(Integer id, Client client);
}
