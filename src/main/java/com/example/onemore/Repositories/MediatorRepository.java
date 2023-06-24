package com.example.onemore.Repositories;


import com.example.onemore.models.mediator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediatorRepository extends CrudRepository<mediator, Integer> {
}
