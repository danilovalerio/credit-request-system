package com.projetos.danilo.systemcredit.creditrequestsystem.service.impl

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Credit
import com.projetos.danilo.systemcredit.creditrequestsystem.repository.CreditRepository
import com.projetos.danilo.systemcredit.creditrequestsystem.service.ICreditService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
       // return this.creditRepository
    }

    /**
     * Aqui vamos ter que usar Named Queries no JPA
     */
    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
       val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw RuntimeException("Credit code $creditCode not found"))

        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact admin code XPTO")
    }
}