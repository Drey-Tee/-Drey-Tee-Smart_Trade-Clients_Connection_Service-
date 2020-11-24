package com.Alcatraz.Client.Connectivity.Service;

import com.Alcatraz.Client.Connectivity.Models.Client;
import com.Alcatraz.Client.Connectivity.Models.Portfolio;
import com.Alcatraz.Client.Connectivity.Repositories.ClientRepository;
import com.Alcatraz.Client.Connectivity.Repositories.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioService  {
    @Autowired
    PortfolioRepository portfolioRepository;
    @Autowired
    ClientRepository clientRepository;

    public Portfolio createPortfolio(Portfolio portfolio, Long id){
       Optional<Client> client = clientRepository.findById(id);
        client.ifPresent(portfolio::setClient);
       return this.portfolioRepository.save(portfolio);
    }

    public Optional<Portfolio> findPortfolio(Long id){
        final Optional<Portfolio> optionalPortfolio =  this.portfolioRepository.findById(id);
        if(optionalPortfolio.isPresent())
            return optionalPortfolio;
        else return null;
    }

    public Long deletePortfolio(Long id){
        final Optional<Portfolio> optionalPortfolio =  this.portfolioRepository.findById(id);
        if(optionalPortfolio.isPresent()) {
            this.portfolioRepository.deleteById(optionalPortfolio.get().getId());
            return optionalPortfolio.get().getId();
        }
        else return null;
    }
}
