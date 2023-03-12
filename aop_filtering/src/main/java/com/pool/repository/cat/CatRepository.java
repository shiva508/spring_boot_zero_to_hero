package com.pool.repository.cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pool.model.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

}
