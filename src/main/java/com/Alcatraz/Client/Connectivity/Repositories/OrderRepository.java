package com.Alcatraz.Client.Connectivity.Repositories;

import com.Alcatraz.Client.Connectivity.Models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
