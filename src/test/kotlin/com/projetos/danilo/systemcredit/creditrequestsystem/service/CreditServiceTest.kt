package com.projetos.danilo.systemcredit.creditrequestsystem.service

import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Address
import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Credit
import com.projetos.danilo.systemcredit.creditrequestsystem.entity.Customer
import com.projetos.danilo.systemcredit.creditrequestsystem.enumaration.Status
import com.projetos.danilo.systemcredit.creditrequestsystem.repository.CreditRepository
import com.projetos.danilo.systemcredit.creditrequestsystem.service.impl.CreditService
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
import java.time.LocalDate
import java.util.*

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CreditServiceTest {
    //Mockar as dependencias
    @MockK
    lateinit var creditRepository: CreditRepository
    @MockK
    lateinit var customerService: CustomerService

    /**
     * Para injetar a classe que QUEREMOS TESTAR
     */
    @InjectMockKs
    lateinit var creditService: CreditService

    @Test
    fun `should create credit`(){
        //given
        val fakeCredit = buildCredit()
        val fakeCustomer = buildCustomer()

        every { customerService.findById(any()) } returns fakeCustomer
        every { creditRepository.save(any()) } returns fakeCredit

        //when
        val actual: Credit = creditService.save(fakeCredit)

        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCredit)
        verify(exactly = 1) { creditRepository.save(fakeCredit) }
    }

    @Test
    fun `should find all credits by customer id`(){
        //given
        val fakeListCredit: List<Credit> = listOf(buildCredit(), buildCredit())
        val fakeCustomer = buildCustomer()

        every { customerService.findById(any()) } returns fakeCustomer
        every { creditRepository.findAllByCustomerId(any()) } returns fakeListCredit

        //when
        val actual: List<Credit> = creditService.findAllByCustomer(fakeCustomer.id ?: 0)

        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeListCredit)
        Assertions.assertThat(actual).hasSize(2)
        verify(exactly = 1) { creditRepository.findAllByCustomerId(fakeCustomer.id ?: 0) }
    }

    @Test
    fun `should find credit by credit code`(){
        //given
        val fakeCustomer = buildCustomer(id = 10L)
        val fakeCredit = buildCredit(customer = fakeCustomer)

        every { customerService.findById(any()) } returns fakeCustomer
        every { creditRepository.findByCreditCode(any()) } returns fakeCredit

        //when
        val actual: Credit = creditService.findByCreditCode(fakeCustomer.id ?: 0, fakeCredit.creditCode)

        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCredit)
        verify(exactly = 1) { creditRepository.findByCreditCode(fakeCredit.creditCode) }
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

    private fun buildCredit(
        uuid: UUID = UUID.randomUUID() ,
        creditValue: BigDecimal = 10000.toBigDecimal(),
        dayFirstInstallment: LocalDate = LocalDate.now().plusDays(30),
        numberOfInstallments: Int = 30,
        status: Status = Status.IN_PROGRESS,
        customer: Customer = buildCustomer(id = Random().nextLong()),
        id: Long = Random().nextLong()
    ) = Credit (
        creditCode = uuid,
        creditValue = creditValue,
        dayFirstInstallment = dayFirstInstallment,
        numerOfInstallments = numberOfInstallments,
        status = status,
        customer = customer,
        id = id
    )

}