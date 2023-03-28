package com.projetos.danilo.systemcredit.creditrequestsystem.dto

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Address
import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Customer
import java.math.BigDecimal

data class CustomerDto(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String
) {

    /**
     * Monta o customer para salvar pela service
     */
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        email = this.email,
        password = this.password,
        income = this.income,
        address = Address(zipCode = this.zipCode, street = this.street)
    )

}
