package com.projetos.danilo.systemcredit.creditrequestsystem.repository

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}