package com.example.adminportal.controller

import com.example.adminportal.entity.Customer
import com.example.adminportal.form.CustomerForm
import com.example.adminportal.service.CustomerService
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("customers")
class CustomerController(
        val customerService: CustomerService
) {
    @ModelAttribute
    fun setUpForm(): CustomerForm {
        return CustomerForm()
    }

    @GetMapping
    fun list(model: Model): String {
        var customers: List<Customer> = customerService.findAll()
        model.addAttribute("customers", customers)
        return "customers/list"
    }

    @PostMapping(path = ["create"])
    fun create(@Validated form: CustomerForm, result: BindingResult, model: Model): String {
        if (result.hasErrors()) {
            return list(model)
        }
        var customer: Customer = Customer()
        BeanUtils.copyProperties(form, customer)
        customerService.create(customer)
        return "redirect:/customers"
    }
}
