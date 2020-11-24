package com.Alcatraz.Client.Connectivity.Service;

import com.Alcatraz.Client.Connectivity.Models.*;
import com.Alcatraz.Client.Connectivity.Repositories.*;
import com.Alcatraz.Client.Connectivity.WSDL.GetUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.StrictMath.toIntExact;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Autowired
    OrderTypeRepository orderTypeRepository;

    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SoapClientService clientService;

    @Autowired
    private SoapClientService soapClientService;

    public String createNewOrder(Order order, Long id, Long port_id){
        Optional<Client> client =  clientRepository.findById(id);
        order.setClient(client.get());


        Optional<Portfolio> portfolio = portfolioRepository.findById(port_id);
        order.setPortfolio(portfolio.get());

        Optional<OrderType> orderType = orderTypeRepository.findById(1L);
        order.setOrderType(orderType.get());

        Optional<OrderStatus> orderStatus = orderStatusRepository.findById(1L);
        order.setOrderStatus(orderStatus.get());

        //order to hold newly created order

        Order newlyCreatedOrder = orderRepository.save(order);

            int order_id  = toIntExact(newlyCreatedOrder.getId());
        GetUserRequest userRequest =  new GetUserRequest();
        userRequest.setId(order_id);
        soapClientService.getItemInfo(userRequest);

        return "Order Created successfully";
    }
}
