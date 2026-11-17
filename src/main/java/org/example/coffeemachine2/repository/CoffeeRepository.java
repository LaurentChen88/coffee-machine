package org.example.coffeemachine2.repository;

import org.example.coffeemachine2.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
