package com.austin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.austin.model.FynarfinEntity;

@Repository
public interface FynarfinRepository extends JpaRepository<FynarfinEntity, Integer> {

}
