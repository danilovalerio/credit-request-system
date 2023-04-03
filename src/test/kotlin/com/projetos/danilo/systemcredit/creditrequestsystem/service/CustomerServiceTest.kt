package com.projetos.danilo.systemcredit.creditrequestsystem.service

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Address
import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Customer
import com.projetos.danilo.systemcredit.creditrequestsystem.repository.CustomerRepository
import com.projetos.danilo.systemcredit.creditrequestsystem.service.impl.CustomerService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerServiceTest {
    @MockK lateinit var customerRepository: CustomerRepository
    @InjectMockKs lateinit var customerService: CustomerService

    @Test
    fun `should create customer`(){
        //given (dado que precisamos receber)
        val fakeCustomer = buildCustomer()

        //sempre que chamar metodo save com qualquer parametro retorne o fakeCustomer
        every { customerRepository.save(any()) } returns fakeCustomer

        //when (quando)
        val actual: Customer = customerService.save(fakeCustomer)

        //then (entao)
        /**
         * Validar se está retornando um customer, se não vem vazio
         */
        Assertions.assertThat(actual).isNotNull

        /**
         * Validar se o customer retornado é igual ao que mandamos para o repository
         */
        Assertions.assertThat(actual).isSameAs(fakeCustomer)

        /**
         * Verificar se o save está sendo executado somente uma vez
         */
        verify(exactly = 1) { customerRepository.save(fakeCustomer) }
    }

    /**
     * Builder de Objeto para ser utlizado durante os teste unitários
     */
    private fun buildCustomer(
        firstName: String = "Danilo",
        lastName: String = "Silva",
        cpf: String = "12345678901",
        email: String = "danilo@email.com",
        password: String = "123456",
        zipCode: String = "00000000",
        street: String = "Rua sem numero",
        income: BigDecimal = BigDecimal.valueOf(1000.0),
        id: Long = 1L
    ) = Customer(
        firstName = firstName,
        lastName = lastName,
        cpf, email, income, password,
        address = Address(zipCode, street),
        id = id
    )

}