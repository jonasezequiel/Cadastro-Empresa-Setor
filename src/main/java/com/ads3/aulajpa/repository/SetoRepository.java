package com.ads3.aulajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ads3.aulajpa.entities.Setor;

@Repository
public interface SetoRepository extends JpaRepository<Setor, Integer> {

}