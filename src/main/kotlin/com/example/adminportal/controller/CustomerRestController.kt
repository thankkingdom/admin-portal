package com.example.adminportal.controller

import com.example.adminportal.entity.Customer
import com.example.adminportal.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import java.util.*

@RestController
@RequestMapping("api/customers")
class CustomerRestController {
    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping
    fun getCustomers(): List<Customer> {
        val customers: List<Customer> = customerService.findAll()
        return customers
    }

    @GetMapping(path = ["{id}"])
    fun getCustomer(@PathVariable id: Int): Customer {
        var customer: Optional<Customer> = customerService.findOne(id)
        if (customer.isPresent) {
            return customer.get()
        }
        return Customer()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postCustomers(@RequestBody customer: Customer): Customer {
        return customerService.create(customer)
    }

    @PutMapping(path = ["{id}"])
    fun putCustomer(@PathVariable id: Int, @RequestBody customer: Customer): Customer {
        customer.id = id
        return customerService.update(customer)
    }

    @DeleteMapping(path = ["{id}"])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCustomer(@PathVariable id: Int) {
        customerService.delete(id)
    }

    @PostMapping("detail")
    fun postCustomers(@RequestBody customer: Customer, uriBuilder: UriComponentsBuilder): ResponseEntity<Customer> {
        var created: Customer = customerService.create(customer)
        var location: URI = uriBuilder.path("api/customers/{id}").buildAndExpand(
                created.id).toUri()
        return ResponseEntity.created(location).body(created)
    }

    @GetMapping("list")
    fun getCustomers(@PageableDefault pageable: Pageable): Page<Customer> {
        var customers: Page<Customer> = customerService.findAll(pageable)
        return customers
    }
}