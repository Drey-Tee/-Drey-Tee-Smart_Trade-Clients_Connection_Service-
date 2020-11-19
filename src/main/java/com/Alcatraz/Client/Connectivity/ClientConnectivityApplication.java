package com.Alcatraz.Client.Connectivity;

import com.Alcatraz.Client.Connectivity.Service.SoapClientService;
import com.Alcatraz.Client.Connectivity.WSDL.GetUserRequest;
import com.Alcatraz.Client.Connectivity.WSDL.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientConnectivityApplication {
	private static int id = 1100;

//	@Autowired
//	SoapClientService soapClientService;

	public static void main(String[] args) {
		SpringApplication.run(ClientConnectivityApplication.class, args);
	}

//	public void run(String[] arg0) throws Exception{
//		GetUserRequest request = new GetUserRequest();
//		request.setId(id);
//		GetUserResponse response = soapClientService.resolveUserRequest(request);
//		System.out.println("the shit is doing");
////		soapClientService.log
//	}
}
