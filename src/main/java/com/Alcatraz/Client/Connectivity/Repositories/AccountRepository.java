package com.Alcatraz.Client.Connectivity.Repositories;

import com.Alcatraz.Client.Connectivity.Models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
