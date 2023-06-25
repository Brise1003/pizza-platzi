package com.platzipizzeria.persistence.repository;

import com.platzipizzeria.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {



}
