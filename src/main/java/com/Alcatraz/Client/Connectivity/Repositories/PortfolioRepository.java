package com.Alcatraz.Client.Connectivity.Repositories;

import com.Alcatraz.Client.Connectivity.Models.Portfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.sound.sampled.Port;
import java.util.List;

@Repository
public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {
    List<Portfolio> findPortfolioByClient_Id(Long client_id);
}
