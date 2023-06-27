package com.example.onemore.Repositories;



import com.example.onemore.models.buysell;
import org.springframework.data.repository.CrudRepository;

public interface BuysellRepository extends CrudRepository<buysell, Integer> {
    buysell save(buysell buysell);
    void delete(buysell buysell);
    void deleteById(Integer id);
}
