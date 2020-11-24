package com.Alcatraz.Client.Connectivity.Repositories;

import com.Alcatraz.Client.Connectivity.Models.Portfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {
}
