package com.Alcatraz.Client.Connectivity.Repositories;

import com.Alcatraz.Client.Connectivity.Models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client,Long> {
    Optional<Client> findByEmail(String email);
}
