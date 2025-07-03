package com.project.demo.controller;


import com.project.demo.entity.Categoria;
import com.project.demo.services.CategoriaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaService.createCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        return ResponseEntity.ok(categoriaService.findAll());
    }
}
