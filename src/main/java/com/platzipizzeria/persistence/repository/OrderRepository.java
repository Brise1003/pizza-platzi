package com.platzipizzeria.persistence.repository;

import com.platzipizzeria.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
}
