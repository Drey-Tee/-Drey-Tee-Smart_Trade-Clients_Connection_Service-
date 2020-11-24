package com.Alcatraz.Client.Connectivity.Service;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.Alcatraz.Client.Connectivity.Models.Client;
import com.Alcatraz.Client.Connectivity.Models.LoginRequest;

import java.security.SecureRandom;
import java.util.Optional;

import com.Alcatraz.Client.Connectivity.Repositories.ClientRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ClientService  {
    @Autowired
    ClientRepository clientRepository;




    public ClientService() {
    }

    public Iterable<Client> getClients() {
        return clientRepository.findAll();

    }

    public Optional<Client> getClient(Long id) {
        return clientRepository.findById(id);
//        return this.clients.stream().filter((c) -> c.getId().equals(id)).findFirst().get();
    }

    public Client saveClient(Client client){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10,new SecureRandom());
        final String encryptedPassword = bCryptPasswordEncoder.encode(client.getPassword());
        client.setPassword(encryptedPassword);
        return  this.clientRepository.save(client);
    }

    public Client login(LoginRequest loginRequest) throws RuntimeException{
        final Optional<Client> optionalClient = this.clientRepository.findByEmail(loginRequest.getEmail());
        if(optionalClient.isPresent()){
            return optionalClient.get();
        }
        return null;

//        if(client.getPassword() == loginRequest.getPassword()){
//            return client;
//        }else{
//            return new NotFoundException("User not found");
//        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return null;
//    }




//    public void addClient(Client client) {
//        this.clients.add(client);
//    }

//    public void updateClient(String id, Client client) {
//        for(int index = 0; index < this.clients.size(); ++index) {
//            Client c = this.clients.get(index);
//            if (c.getId().equals(id)) {
//                this.clients.set(index, client);
//            }
//        }
//
//    }

//    public void deleteClient(String id) {
//        this.clients.removeIf((client) -> client.getId().equals(id));
//    }

//    public Client login(LoginRequest loginRequest) {
//        Optional<Client> client = this.clients.stream().filter((c) -> c.getEmail().equals(loginRequest.getEmail()) && c.getPassword().equals(loginRequest.getPassword())).findFirst();
//        return client.orElseGet((Supplier)null);
//    }
}

