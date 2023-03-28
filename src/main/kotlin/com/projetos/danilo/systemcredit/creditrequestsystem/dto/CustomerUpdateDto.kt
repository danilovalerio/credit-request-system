package com.projetos.danilo.systemcredit.creditrequestsystem.dto

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDto(
    val fistName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String
) {

    fun toEntity(customer: Customer) : Customer {
        customer.firstName = this.fistName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street
        return customer
    }

}
