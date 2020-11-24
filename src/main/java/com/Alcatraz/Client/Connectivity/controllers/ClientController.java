package com.Alcatraz.Client.Connectivity.controllers;
import com.Alcatraz.Client.Connectivity.Configuration.ClientConnectivityServicePublisher;
import com.Alcatraz.Client.Connectivity.Models.Client;
import com.Alcatraz.Client.Connectivity.Models.LoginRequest;
import com.Alcatraz.Client.Connectivity.Models.Order;
import com.Alcatraz.Client.Connectivity.Models.Portfolio;
import com.Alcatraz.Client.Connectivity.Service.ClientService;
import com.Alcatraz.Client.Connectivity.Service.OrderService;
import com.Alcatraz.Client.Connectivity.Service.PortfolioService;
import com.Alcatraz.Client.Connectivity.Service.SoapClientService;
import com.Alcatraz.Client.Connectivity.WSDL.GetUserRequest;
import com.Alcatraz.Client.Connectivity.WSDL.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
//
//    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private OrderService orderService;




    @Autowired
    private ClientConnectivityServicePublisher clientConnectivityServicePublisher;

    @RequestMapping("/clients")
    public Iterable<Client> getAllClients(){
        return clientService.getClients();
    }


    @RequestMapping("/clients/{id}")
    public Optional<Client> getClient(@PathVariable Long id){
        return clientService.getClient(id);
    }

    @PostMapping("/clients/register")
    public Client registerClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @PostMapping("/clients/login")
    public Client clientLogin(@RequestBody LoginRequest loginRequest){
        return  clientService.login(loginRequest);
    }

    @PostMapping("/clients/{id}/portfolio")
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio, @PathVariable Long id){
        return portfolioService.createPortfolio(portfolio,id);
    }

    @PostMapping("/clients/{id}/{portfolioId}/order")
    public void createOrder(@RequestBody Order order,@PathVariable long id, @PathVariable long portfolioId ){
        orderService.createNewOrder(order,id,portfolioId);
    }
//    @RequestMapping(method = RequestMethod.POST, value = "/clients")
//    public void addClient(@RequestBody Client client){
//        clientService.addClient(client);
//    }

//    @PostMapping(value = "/login")
//    public Client login(@RequestBody LoginRequest loginResquest){
//        return clientService.login(loginResquest);
//    }
////
//    @RequestMapping(method = {RequestMethod.PUT}, value = "/clients/{id}")
//    public void updateClient(@RequestBody Client client, @PathVariable String id){
//        clientService.updateClient(id, client);
//    }

//    @RequestMapping(method = RequestMethod.DELETE, value = "/clients/{id}")
//    public void deleteTopic(@PathVariable String id){ clientService.deleteClient(id);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/publish")
    public void publish(@RequestBody String message){
        clientConnectivityServicePublisher.publisher(message);
    }

//    @PostMapping("/soap")
//    public GetUserResponse resolveGetUserRequest(@RequestBody GetUserRequest request){
//        GetUserResponse response = new GetUserResponse();
//       response= soapClientService.getItemInfo(request);
//       return response;
//    }


//    @PostMapping("/item")
//    public GetUserResponse response(@RequestBody GetUserRequest getUserRequest){
//        return soapClientService.getItemInfo(getUserRequest);
//    }

}

