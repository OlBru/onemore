package com.example.onemore.Repositories;


import com.example.onemore.models.account;
import com.example.onemore.models.holder;
import org.springframework.data.repository.CrudRepository;

public interface HolderRepository extends CrudRepository<holder, Integer> {
    holder save(holder holder);
    void delete(holder holder);
    void deleteById(Integer id);
}
