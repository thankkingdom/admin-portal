package com.example.adminportal.service

import com.example.adminportal.entity.Customer
import com.example.adminportal.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class CustomerService(var customerRepository: CustomerRepository) {

    fun findAll(): List<Customer> {
        //return customerRepository.findAllOrderByName()
        var sort: Sort = Sort(Sort.Direction.ASC, "firstName", "lastName")
        return customerRepository.findAll(sort)
    }

    fun findAll(pageable: Pageable): Page<Customer> {
        return customerRepository.findAll(pageable)
    }

    fun findOne(id: Int): Optional<Customer> {
        return customerRepository.findById(id)
    }

    fun create(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    fun update(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    fun delete(id: Int) {
        customerRepository.deleteById(id)
    }
}