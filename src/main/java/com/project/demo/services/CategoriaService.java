package com.project.demo.services;

import com.project.demo.entity.Categoria;
import com.project.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }
}
