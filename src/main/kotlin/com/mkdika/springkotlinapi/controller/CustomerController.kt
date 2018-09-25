package com.mkdika.springkotlinapi.controller

import com.mkdika.springkotlinapi.model.Customer
import com.mkdika.springkotlinapi.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/customer")
class CustomerController(private val customerRepository: CustomerRepository) {

    @GetMapping
    fun findAllCustomer(): ResponseEntity<Iterable<Customer>> =
            ResponseEntity.ok().body(customerRepository.findAll())

    @GetMapping("/{id}")
    fun findCustomerById(@PathVariable(value = "id") id: Int): ResponseEntity<Customer> {
        return customerRepository.findById(id).map { customer -> ResponseEntity.ok(customer) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createCustomer(@Valid @RequestBody customer: Customer): ResponseEntity<Customer> =
            ResponseEntity.ok().body(customerRepository.save(customer))

    @PutMapping("/{id}")
    fun updateCustomerById(@PathVariable(value = "id") id: Int,
                           @Valid @RequestBody newCustomer: Customer): ResponseEntity<Customer> {
        return customerRepository.findById(id).map { exCustomer ->
            val updateCustomer: Customer = exCustomer.copy(firstName = newCustomer.firstName,
                    lastName = newCustomer.lastName,
                    balance = newCustomer.balance)
            ResponseEntity.ok().body(customerRepository.save(updateCustomer))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable(value = "id") id: Int): ResponseEntity<Void> {
        return customerRepository.findById(id).map { customer ->
            customerRepository.delete(customer)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElse(ResponseEntity.notFound().build())
    }

}