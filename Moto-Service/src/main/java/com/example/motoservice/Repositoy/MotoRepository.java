package com.example.motoservice.Repositoy;

import com.example.motoservice.Entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotoRepository extends JpaRepository<Moto,Integer> {

    List<Moto> findByUsuarioId(int usuarioId);
}
