package com.project.demo.controller;

import com.project.demo.dto.TransacaoDTO;
import com.project.demo.entity.Categoria;
import com.project.demo.entity.Transacao;
import com.project.demo.entity.User;
import com.project.demo.enums.tipoTransacao;
import com.project.demo.services.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {
    private final TransacaoService transacaoService;

    @Autowired
    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping
    public ResponseEntity<Transacao> createTransacao(@RequestBody @Valid TransacaoDTO transacaoDTO) {
        Transacao transacao = new Transacao();
        transacao.setDescricao(transacaoDTO.descricao());
        transacao.setValor(transacaoDTO.valor());
        transacao.setData(LocalDateTime.from(transacaoDTO.data()));
        transacao.setTipoTransacao(tipoTransacao.valueOf(String.valueOf(transacaoDTO.tipo())));

        Categoria categoria = new Categoria();
        categoria.setId(transacaoDTO.categoriaId());
        transacao.setCategoria(categoria);

        User usuario = new User();
        usuario.setId(transacaoDTO.usuarioId());
        transacao.setUser(usuario);

        Transacao novaTransacao = transacaoService.createTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> getAllTransacoes() {
        return ResponseEntity.ok(transacaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> getTransacaoById(@PathVariable Long id) {
        Transacao transacao = transacaoService.getTransacaoById(id);
        return ResponseEntity.ok(transacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transacao> deleteTransacao(@PathVariable Long id) {
        transacaoService.deleteTransacao(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Transacao>> getTransacaoByTipo(@PathVariable String tipo) {
        List<Transacao> transacoes = transacaoService.getTransacoesByTipo(tipoTransacao.valueOf(tipo));
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<Transacao>> getTransacaoByPeriodo(@RequestParam String dataInicial, @RequestParam String dataFinal) {
        List<Transacao> transacoes = transacaoService.getTransacoesByPeriodo(LocalDate.parse(dataInicial), LocalDate.parse(dataFinal));
        return ResponseEntity.ok(transacoes);
    }
}
