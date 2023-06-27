package com.example.onemore.Repositories;


import com.example.onemore.models.account;
import com.example.onemore.models.issuer;
import org.springframework.data.repository.CrudRepository;

public interface IssuerRepository extends CrudRepository<issuer, Integer> {

    issuer save(issuer issuer);
    void delete(issuer issuer);
    void deleteById(Integer id);
}
