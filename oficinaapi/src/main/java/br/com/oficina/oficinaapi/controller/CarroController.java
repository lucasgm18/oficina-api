package br.com.oficina.oficinaapi.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.oficina.oficinaapi.dto.CarroRecordDto;
import br.com.oficina.oficinaapi.model.Carro;
import br.com.oficina.oficinaapi.repository.CarroRepository;
@RestController
public class CarroController {

    private static final Logger logger = LoggerFactory.getLogger(CarroController.class);
    //injeção de dependecia
    @Autowired
    private CarroRepository carroRepository;

    //Pegará o BODY, HEAD E STATUS DA REQUISIÇÃO HTTP
    @PostMapping("/carros")


    public ResponseEntity<Carro> cadastraCarro(@RequestBody CarroRecordDto carroRecordDto) {
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroRecordDto, carro); //Pegando a propriedade que veio do corpo da requisição salva no params e passando para o OBJ CARRO
        return ResponseEntity.status(HttpStatus.CREATED).body(carroRepository.save(carro));
    }

    @GetMapping("/carros")
    public ResponseEntity<List<Carro>> consultaTodosOsCarros() {
        return ResponseEntity.status(HttpStatus.OK).body(carroRepository.findAll());
    }

    @GetMapping("/carros/{vin}")
    public ResponseEntity<Object> pesquisaPorVin(@PathVariable(name = "vin") String vin) {
        logger.info("Recebida requisição para pesquisar carro com VIN: {}", vin);
        Optional<Carro> optionalCarro = carroRepository.findById(vin);
        if (optionalCarro.isPresent()) {
            logger.info("Carro encontrado: {}", optionalCarro.get());
            return ResponseEntity.status(HttpStatus.OK).body(optionalCarro.get());
        } else {
            logger.warn("Carro com VIN {} não foi encontrado.", vin);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não foi encontrado!");
        }
    }

    @RestController
    public static class TestController {

        @GetMapping("/test/{vin}")
        public String testEndpoint(@PathVariable(name = "vin") String vin) {
            return "VIN recebido: " + vin;
        }
    }



    @PutMapping("/carros/{vin}")
    public ResponseEntity<Object> alterarPlaca(@PathVariable(name = "vin") String vin, @RequestBody CarroRecordDto carroRecordDto) {
        Optional<Carro> optionalCarro = carroRepository.findById(vin);
        if (optionalCarro.isEmpty()) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Placa não encontrada!");

        }
        Carro carro = optionalCarro.get();
        BeanUtils.copyProperties(carroRecordDto, carro);
        return ResponseEntity.status(HttpStatus.OK).body(carroRepository.save(carro));
    }

    @DeleteMapping("carros/{vin}")
    public ResponseEntity<Object> excluiCarro(@PathVariable(name = "vin") String vin){
        Optional<Carro> optionalCarro = carroRepository.findById(vin);
        if (optionalCarro.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado!");
        }
        carroRepository.deleteById(vin);
        return ResponseEntity.status(HttpStatus.OK).body("Carro foi excluido com sucesso!");
    }

   }



