package com.project.demo.services;

import com.project.demo.entity.Categoria;
import com.project.demo.entity.Transacao;
import com.project.demo.entity.User;
import com.project.demo.enums.tipoTransacao;
import com.project.demo.repository.CategoriaRepository;
import com.project.demo.repository.TransacaoRepository;
import com.project.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final CategoriaRepository categoriaRepository;
    private final UserRepository userRepository;

    public TransacaoService(TransacaoRepository transacaoRepository, CategoriaRepository categoriaRepository, UserRepository userRepository) {
        this.transacaoRepository = transacaoRepository;
        this.categoriaRepository = categoriaRepository;
        this.userRepository = userRepository;
    }


    public Transacao createTransacao(Transacao transacao) {
        if (transacao.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("O valor da transação deve ser maior que zero");
        }

        Categoria categoria = categoriaRepository.findById(transacao.getCategoria().getId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

        User usuario = userRepository.findById(transacao.getUser().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        transacao.setCategoria(categoria);
        transacao.setUser(usuario);

        return transacaoRepository.save(transacao);
    }

    public List<Transacao> findAll() {
        return transacaoRepository.findAll();
    }

    public Transacao getTransacaoById(Long id) {
        return transacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Transação não encontrada"));
    }

    public void deleteTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }

    public List<Transacao> getTransacoesByTipo(tipoTransacao tipo) {
        return transacaoRepository.findByTipo(tipo);
    }

    public List<Transacao> getTransacoesByUsuario(Long usuarioId) {
        return transacaoRepository.findByUsuarioId(usuarioId);
    }

    public List<Transacao> getTransacoesByPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        return transacaoRepository.findByDataBetween(dataInicial, dataFinal);
    }
}
