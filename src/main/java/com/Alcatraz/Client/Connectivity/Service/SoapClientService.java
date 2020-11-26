package com.Alcatraz.Client.Connectivity.Service;

import com.Alcatraz.Client.Connectivity.WSDL.GetOrderRequest;
import com.Alcatraz.Client.Connectivity.WSDL.GetOrderResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class SoapClientService  extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(SoapClientService.class);

//    public GetOrderResponse resolveUserRequest(GetOrderRequest request){
//        GetOrderRequest request1 = new GetOrderRequest();
//        request1.setId(request.getId());
//        log.info("Requesting user with id " + request.getId());
//        return (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8089/soapWS",request1,new SoapActionCallback("http://localhost:8089/soapWS/"));
//    }

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    public GetOrderResponse getItemInfo(GetOrderRequest getOrderRequest){
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        return (GetOrderResponse) webServiceTemplate.marshalSendAndReceive("http://b26e25190b50.ngrok.io/soapWS",getOrderRequest);
    }
}
