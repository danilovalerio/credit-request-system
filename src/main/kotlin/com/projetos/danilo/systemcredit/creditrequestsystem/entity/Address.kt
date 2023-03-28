package com.projetos.danilo.systemcredit.creditrequestsystem.entity

import jakarta.persistence.Embeddable

/**
 * Não vou criar uma tabela de endereço
 * Vou pegar a classe de address integrar com customer
 */
@Embeddable
data class Address (
    var zipCode: String = ""
)
