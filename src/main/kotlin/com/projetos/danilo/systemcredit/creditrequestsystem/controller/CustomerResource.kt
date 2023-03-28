package com.projetos.danilo.systemcredit.creditrequestsystem.controller

import com.projetos.danilo.systemcredit.creditrequestsystem.dto.CustomerDto
import com.projetos.danilo.systemcredit.creditrequestsystem.dto.CustomerUpdateDto
import com.projetos.danilo.systemcredit.creditrequestsystem.dto.CustomerView
import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Customer
import com.projetos.danilo.systemcredit.creditrequestsystem.service.impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    fun saveCustomer(@RequestBody customerDto: CustomerDto): ResponseEntity<String> {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.email} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

    /**
     * Quando for algumas infos dê preferência para Patch ao invés de Put
     */
    @PatchMapping
    fun updateCustomer(@RequestParam(value = "customerId") id: Long, 
                       @RequestBody customerUpdateDto: CustomerUpdateDto): ResponseEntity<CustomerView> {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = customerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }
}