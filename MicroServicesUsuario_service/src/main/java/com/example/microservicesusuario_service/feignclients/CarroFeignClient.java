package com.example.microservicesusuario_service.feignclients;

import com.example.microservicesusuario_service.Models.Carro;
import com.example.microservicesusuario_service.Models.Moto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="carro-service",url="http://localhost:8002",path ="/carro" )

public interface CarroFeignClient {
    @PostMapping()
    public Carro save(@RequestBody Carro carro);


    @GetMapping("/usuario/{usuarioId}")
    public List<Carro> getCarros(@PathVariable("usuarioId") int usuarioId);
}
