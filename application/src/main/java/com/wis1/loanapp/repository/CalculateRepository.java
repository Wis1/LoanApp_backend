package com.wis1.loanapp.repository;

import com.wis1.loanapp.domain.Calculate;
import com.wis1.loanapp.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculateRepository extends CrudRepository<Calculate, Long> {

    List<Calculate> findByClient(Client client);

}
