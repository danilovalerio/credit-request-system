package com.projetos.danilo.systemcredit.creditrequestsystem.repository

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * Nosso ponte de acesso ao banco de dados para persistir
 */
@Repository
interface CreditRepository : JpaRepository<Credit, Long> {
}