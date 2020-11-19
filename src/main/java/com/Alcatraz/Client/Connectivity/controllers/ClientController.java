package com.Alcatraz.Client.Connectivity.controllers;
import com.Alcatraz.Client.Connectivity.Configuration.ClientConnectivityServicePublisher;
import com.Alcatraz.Client.Connectivity.Models.Client;
import com.Alcatraz.Client.Connectivity.Models.LoginRequest;
import com.Alcatraz.Client.Connectivity.Service.ClientService;
import com.Alcatraz.Client.Connectivity.Service.SoapClientService;
import com.Alcatraz.Client.Connectivity.WSDL.GetUserRequest;
import com.Alcatraz.Client.Connectivity.WSDL.GetUserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
//
//    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

//    @Autowired
//    private SoapClientService soapClientService;


    @Autowired
    private ClientConnectivityServicePublisher clientConnectivityServicePublisher;

    @RequestMapping("/clients")
    public List<Client> getAllClients(){
        return clientService.getClients();
    }


    @RequestMapping("/clients/{id}")
    public Client getClient(@PathVariable String id){
        return clientService.getClient(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/clients")
    public void addClient(@RequestBody Client client){
        clientService.addClient(client);
    }

    @PostMapping(value = "/login")
    public Client login(@RequestBody LoginRequest loginResquest){
        return clientService.login(loginResquest);
    }

    @RequestMapping(method = {RequestMethod.PUT}, value = "/clients/{id}")
    public void updateClient(@RequestBody Client client, @PathVariable String id){
        clientService.updateClient(id, client);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/clients/{id}")
    public void deleteTopic(@PathVariable String id){ clientService.deleteClient(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/publish")
    public void publish(@RequestBody String message){
        clientConnectivityServicePublisher.publisher(message);
    }

//    @PostMapping("/soap")
//    public GetUserResponse resolveGetUserRequest(@RequestBody GetUserRequest request){
//        GetUserResponse response = new GetUserResponse();
//       response= soapClientService.resolveUserRequest(request);
//       return response;
//    }
    @Autowired
    SoapClientService soapClientService;

    @PostMapping("/item")
    public GetUserResponse response(@RequestBody GetUserRequest getUserRequest){
        return soapClientService.getItemInfo(getUserRequest);
    }

}

