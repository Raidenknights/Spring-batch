package com.example.demo.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.batch.entity.BatchUserEntity;

@Repository
public interface BatchUserRepository extends JpaRepository<BatchUserEntity, Integer> {

}