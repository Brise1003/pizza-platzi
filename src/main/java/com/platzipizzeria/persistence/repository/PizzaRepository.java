package com.platzipizzeria.persistence.repository;

import com.platzipizzeria.persistence.entity.PizzaEntity;
import com.platzipizzeria.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(BigDecimal price);
    int countByVeganTrue();

//    @Query(value = "UPDATE pizza SET price = :newPrice WHERE id_pizza = :idPizza", nativeQuery = true)
//    void updatePrice(@Param("idPizza") int idPizza,@Param("newPrice") BigDecimal newPrice);

    @Query(value = "UPDATE pizza SET price = :#{#newPizzaPrice.newPrice} WHERE id_pizza = :#{#newPizzaPrice.pizzaId}", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newPizzaPrice") UpdatePizzaPriceDto newPizzaPrice);

}
