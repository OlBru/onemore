package com.example.onemore.Repositories;


import com.example.onemore.models.account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<account, Integer> {
}
