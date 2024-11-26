package api.ibmec.Ecommerce.controller;

import api.ibmec.Ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import api.ibmec.Ecommerce.entity.Extrato;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/extratos")
public class EcommerceController {

    @Autowired
    private ProductService productService;

    // Endpoint de introdução à API
    @GetMapping("/welcome")
    public ResponseEntity<String> introducao() {
        return ResponseEntity.ok("Bem-vindo à API do nosso e-commerce!");
    }

    // Buscar extratos pelo CPF
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<Extrato>> buscarExtratosPorCpf(@PathVariable String cpf) {
        List<Extrato> extratos = productService.findCpf(cpf);
        if (extratos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(extratos);
    }

    // Buscar extrato pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Extrato> buscarExtratoPorId(@PathVariable String id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Criar um novo extrato
    @PostMapping
    public ResponseEntity<Extrato> criarExtrato(@Valid @RequestBody Extrato extrato) {
        Extrato novoExtrato = productService.salvarExtrato(extrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoExtrato);
    }
}
