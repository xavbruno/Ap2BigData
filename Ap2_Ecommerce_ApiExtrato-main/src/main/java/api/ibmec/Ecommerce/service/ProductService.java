package api.ibmec.Ecommerce.service;

import api.ibmec.Ecommerce.entity.Extrato;
import api.ibmec.Ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Buscar extratos pelo CPF
    public List<Extrato> findCpf(String cpf) {
        return productRepository.findByCpf(cpf);
    }

    // Salvar novo extrato
    public Extrato salvarExtrato(Extrato extrato) {
        return productRepository.save(extrato);
    }

    // Buscar extrato por ID
    public Optional<Extrato> findById(String id) {
        return productRepository.findById(id);
    }
}
