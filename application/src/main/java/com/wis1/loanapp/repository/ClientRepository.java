package com.wis1.loanapp.repository;

import com.wis1.loanapp.domain.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository <Client, Long> {

    List<Client> findAll();
}
