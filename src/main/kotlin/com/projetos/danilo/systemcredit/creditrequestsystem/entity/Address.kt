package com.projetos.danilo.systemcredit.creditrequestsystem.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

/**
 * Não vou criar uma tabela de endereço
 * Vou pegar a classe de address integrar com customer
 */
@Embeddable
data class Address (
    @Column(nullable = false)
    var zipCode: String = "",
    @Column(nullable = false)
    var street: String = ""
)
