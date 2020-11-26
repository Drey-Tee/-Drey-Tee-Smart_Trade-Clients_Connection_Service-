package com.Alcatraz.Client.Connectivity.Service;

import com.Alcatraz.Client.Connectivity.Models.*;
import com.Alcatraz.Client.Connectivity.Repositories.*;
import com.Alcatraz.Client.Connectivity.WSDL.GetOrderRequest;
import com.Alcatraz.Client.Connectivity.WSDL.GetOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
     Client client1 =    newlyCreatedOrder.getClient();


            int order_id  = toIntExact(newlyCreatedOrder.getId());
        GetOrderRequest orderRequest =  new GetOrderRequest();

        orderRequest.setBalance(client1.getBank_balance());
        orderRequest.setId(order_id);
        orderRequest.setPrice(newlyCreatedOrder.getPrice());
        orderRequest.setTicker(newlyCreatedOrder.getTicker_name());
        orderRequest.setQuantity(newlyCreatedOrder.getQuantity());
        orderRequest.setSide(newlyCreatedOrder.getOrderType().getName());
        soapClientService.getItemInfo(orderRequest);

        return "Order Created successfully";
    }

    public List<Order> getAllOrder(Long id) {
       return orderRepository.findByClient_Id(id);
    }

    public List<Portfolio> getAllPortfolio(Long id) {
        return portfolioRepository.findPortfolioByClient_Id(id);
    }
}
