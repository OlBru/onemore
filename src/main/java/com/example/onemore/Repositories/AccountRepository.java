package com.example.onemore.Repositories;


import com.example.onemore.models.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<account, Integer> {
    account save(account account);
    void delete(account account);
    void deleteById(Integer id);
}
