package com.projetos.danilo.systemcredit.creditrequestsystem.service.impl

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Customer
import com.projetos.danilo.systemcredit.creditrequestsystem.repository.CustomerRepository
import com.projetos.danilo.systemcredit.creditrequestsystem.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
): ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow{
            throw RuntimeException("Id $id not found")
        }
    }

    override fun delete(id: Long) {
        return this.customerRepository.deleteById(id)
    }
}