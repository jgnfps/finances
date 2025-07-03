package com.project.demo.repository;

import com.project.demo.entity.Transacao;
import com.project.demo.enums.tipoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findByUsuarioId(Long usuarioId);

    List<Transacao> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);

    List<Transacao> findByTipo(tipoTransacao tipo);
}
