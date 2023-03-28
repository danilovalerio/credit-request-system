package com.projetos.danilo.systemcredit.creditrequestsystem.service

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)

}