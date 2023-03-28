package com.projetos.danilo.systemcredit.creditrequestsystem.dto

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Credit
import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numerOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )

}
