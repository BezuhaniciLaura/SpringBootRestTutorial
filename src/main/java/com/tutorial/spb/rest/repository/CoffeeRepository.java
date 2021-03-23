package com.tutorial.spb.rest.repository;

import com.tutorial.spb.rest.entities.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee , String> {
}
