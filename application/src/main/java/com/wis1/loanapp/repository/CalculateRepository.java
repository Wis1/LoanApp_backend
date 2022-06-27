package com.wis1.loanapp.repository;

import com.wis1.loanapp.domain.Calculate;
import com.wis1.loanapp.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CalculateRepository extends CrudRepository<Calculate, Long> {

    List<Calculate> findByClient(Client client);
    List<Calculate> findAll();
    Calculate save(Calculate calculate);

}
