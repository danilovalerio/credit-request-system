package com.projetos.danilo.systemcredit.creditrequestsystem

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition(servers = [Server(url = "/", description = "Default Server URL")])
@SpringBootApplication
class CreditRequestSystemApplication

fun main(args: Array<String>) {
	runApplication<CreditRequestSystemApplication>(*args)
}
