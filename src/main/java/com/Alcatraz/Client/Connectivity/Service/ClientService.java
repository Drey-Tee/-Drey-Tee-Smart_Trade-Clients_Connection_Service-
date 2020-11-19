package com.Alcatraz.Client.Connectivity.Service;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.Alcatraz.Client.Connectivity.Models.Client;
import com.Alcatraz.Client.Connectivity.Models.LoginRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

        List<Client> clients = new ArrayList(
                Arrays.asList(
                        new Client("1", "Erastus", "Doh", "edoh@gmail.com", "password"),
                        new Client("2", "Audrey", "Nueki", "drey@gmail.com", "12345678"),
                        new Client("2", "Nana", "Kwame", "nana@gmail.com", "1234567"),
                        new Client("4", "James", "Amo", "james@gmail.com", "123456")
                )
        );




    public ClientService() {
    }

    public List<Client> getClients() {
        return this.clients;
    }

    public Client getClient(String id) {
        return this.clients.stream().filter((c) -> c.getId().equals(id)).findFirst().get();
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void updateClient(String id, Client client) {
        for(int index = 0; index < this.clients.size(); ++index) {
            Client c = this.clients.get(index);
            if (c.getId().equals(id)) {
                this.clients.set(index, client);
            }
        }

    }

    public void deleteClient(String id) {
        this.clients.removeIf((client) -> client.getId().equals(id));
    }

    public Client login(LoginRequest loginRequest) {
        Optional<Client> client = this.clients.stream().filter((c) -> c.getEmail().equals(loginRequest.getEmail()) && c.getPassword().equals(loginRequest.getPassword())).findFirst();
        return client.orElseGet((Supplier)null);
    }
}

