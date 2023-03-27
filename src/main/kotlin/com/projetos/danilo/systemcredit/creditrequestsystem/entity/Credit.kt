package com.projetos.danilo.systemcredit.creditrequestsystem.entity

import com.projetos.danilo.systemcredit.creditrequestsystem.enumaration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class Credit (
    val creditCode: UUID = UUID.randomUUID(),
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numerOfInstallments: Int = 0,
    val status: Status = Status.IN_PROGRESS,
    val customer: Customer? = null,
    val id: Long? = null
)
