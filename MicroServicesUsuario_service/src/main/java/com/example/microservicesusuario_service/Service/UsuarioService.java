package com.example.microservicesusuario_service.Service;

import com.example.microservicesusuario_service.Entity.Usuario;
import com.example.microservicesusuario_service.Models.Carro;
import com.example.microservicesusuario_service.Models.Moto;
import com.example.microservicesusuario_service.Repository.UsuarioRepository;
import com.example.microservicesusuario_service.feignclients.CarroFeignClient;
import com.example.microservicesusuario_service.feignclients.MotoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CarroFeignClient carroFeignClient;

    @Autowired
    private MotoFeignClient motoFeignClient;

    public  List<Carro> getCarros(int usuarioId){
        List<Carro> carros=restTemplate.getForObject("http://localhost:8002/carro/usuario/" + usuarioId,List.class);
        return  carros;
    }

    public  List<Moto> getMotos(int usuarioId){
        List<Moto> motos=restTemplate.getForObject("http://localhost:8003/moto/usuario/" + usuarioId,List.class);
        return  motos;
    }
    //Guardar un carro
    public  Carro saveCarro(int usuarioID,Carro carro){
        carro.setUsuarioId(usuarioID);
        Carro nuevoCarro=carroFeignClient.save(carro);
        return nuevoCarro;
    }

    //Guardar una moto
    public Moto saveMoto(int usuarioID,Moto moto){
        moto.setUsuarioId(usuarioID);
        Moto nuevaMoto=motoFeignClient.save(moto);
        return nuevaMoto;
    }

    public Map<String,Object> getUsuariosAndVehiculos(int usuarioId){
        Map<String,Object> resultado=new HashMap<>();
        Usuario usuario=usuarioRepository.findById(usuarioId).orElse(null);
        if(usuario==null){
            resultado.put("Mensaje","El usuario no existe");
            return  resultado;
        }
        resultado.put("Usuario",usuario);
        List<Carro> carros=carroFeignClient.getCarros(usuarioId);
        if(carros.isEmpty()){
            resultado.put("Carros","El usuario no tiene carros");

        }else{
            resultado.put("Carros",carros);
        }

        List<Moto> motos=motoFeignClient.getMotos(usuarioId);
        if(motos.isEmpty()){
            resultado.put("Motos","El usuario no tiene motos");

        }else{
            resultado.put("Motos",motos);
        }
        return resultado;

    }


    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario){
        Usuario nuevoUsuario=usuarioRepository.save(usuario);
        return nuevoUsuario;
    }
}
