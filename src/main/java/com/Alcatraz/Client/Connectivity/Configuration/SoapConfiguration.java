package com.Alcatraz.Client.Connectivity.Configuration;

import com.Alcatraz.Client.Connectivity.Service.SoapClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfiguration {
//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        // this package must match the package in the  specified in
//        // pom.xml
//        marshaller.setContextPath("ConsumerValidation.wsdl");
//        return marshaller;
//    }
//
//    @Bean(name = "soapClientService")
//    public SoapClientService soapClientService(Jaxb2Marshaller marshaller){
//        SoapClientService client = new SoapClientService();
//        client.setDefaultUri("http://localhost:8091/ws/soapWS");
//        client.setMarshaller(marshaller);
//        client.setUnmarshaller(marshaller);
//        return client;
//    }

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setPackagesToScan("com.Alcatraz.Client.Connectivity.WSDL");
        return jaxb2Marshaller;
    }
}
