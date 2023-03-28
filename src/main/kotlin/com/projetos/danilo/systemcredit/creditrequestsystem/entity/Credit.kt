package com.projetos.danilo.systemcredit.creditrequestsystem.entity

import com.projetos.danilo.systemcredit.creditrequestsystem.enumaration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "Credit")
data class Credit (
    @Column(nullable = false, unique = true)
    val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false)
    val creditValue: BigDecimal,
    @Column(nullable = false)
    val dayFirstInstallment: LocalDate,
    @Column(nullable = false)
    val numerOfInstallments: Int = 0,
    @Enumerated
    val status: Status = Status.IN_PROGRESS,
    //muitos creditos podem pertencer a um único cliente
    @ManyToOne
    var customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
