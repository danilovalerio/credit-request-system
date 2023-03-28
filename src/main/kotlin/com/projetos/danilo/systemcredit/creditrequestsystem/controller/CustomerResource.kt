package com.projetos.danilo.systemcredit.creditrequestsystem.controller

import com.projetos.danilo.systemcredit.creditrequestsystem.dto.CustomerDto
import com.projetos.danilo.systemcredit.creditrequestsystem.service.impl.CustomerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Poderiamos nomear como CustomerController
 */
@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService: CustomerService
) {

    /**
     * RequestBody - quando chegar os dados JSON no body me retorna uma string
     */
    @PostMapping
    fun saveCustomer(@RequestBody customerDto: CustomerDto): String {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved!"
    }
}