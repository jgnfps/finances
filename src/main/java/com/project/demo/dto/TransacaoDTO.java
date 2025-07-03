package com.project.demo.dto;

import com.project.demo.enums.tipoTransacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransacaoDTO (
        @NotBlank(message = "A descrição é obrigatória!")
        String descricao,

        @Positive(message = "O valor deve ser positivo")
        BigDecimal valor,

        @NotNull(message = "A data é obrigatória")
        LocalDate data,

        @NotNull(message = "O tipo da transação é obrigatório")
        tipoTransacao tipo,

        @NotNull(message = "A categoria é obrigatória")
        Long categoriaId,

        @NotNull(message = "O usuário é obrigatório")
        Long usuarioId
){
}
