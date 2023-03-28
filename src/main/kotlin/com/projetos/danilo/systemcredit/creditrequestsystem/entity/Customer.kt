package com.projetos.danilo.systemcredit.creditrequestsystem.entity

import jakarta.persistence.*
import java.math.BigDecimal

/**
 * Essa classe será uma tabela no banco de dados
 * Para nomear diferente @Table(name = "Cliente")
 */
@Entity
data class Customer(
    @Column(nullable = false)
    var firstName: String = "",
    @Column(nullable = false)
    var lastName: String = "",
    @Column(nullable = false, unique = true)
    var cpf: String = "",
    @Column(nullable = false, unique = true)
    var email: String = "",
    //TODO("Incluir o campo income através do flyway com uma migration")
    @Column(nullable = false)
    var income: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false)
    var password: String = "",
    // Embedded - Integrado address dentro de customer
    @Column(nullable = false) @Embedded
    var address: Address = Address(),
    // FetchType Lazy: Carregar lista de creditos só quando quiser, não quando carregar
    // Cascade: Para limpar a lista de creditos caso apague esse ususario
    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),
    mappedBy = "customer")
    var credits: List<Credit> = mutableListOf(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)
