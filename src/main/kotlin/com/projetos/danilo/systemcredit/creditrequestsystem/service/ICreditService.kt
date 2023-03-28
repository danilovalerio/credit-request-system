package com.projetos.danilo.systemcredit.creditrequestsystem.service

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Credit
import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Customer
import java.util.UUID

/**
 * Interface para determinar as FUNCIONALIDADES do servico
 * - salvar
 * - buscar creditos por clientes
 * - buscar credito por UUID
 */
interface ICreditService {
    fun save(credit: Credit): Credit

    fun findAllByCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(creditCode: UUID): Credit
}