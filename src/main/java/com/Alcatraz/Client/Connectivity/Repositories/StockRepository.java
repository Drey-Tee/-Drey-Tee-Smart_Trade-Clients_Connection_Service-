package com.Alcatraz.Client.Connectivity.Repositories;

import com.Alcatraz.Client.Connectivity.Models.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
}
