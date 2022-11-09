package com.example.carroservice.Repository;

import com.example.carroservice.Entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Integer> {


    List<Carro> findByUsuarioId(int usuarioId);
}
