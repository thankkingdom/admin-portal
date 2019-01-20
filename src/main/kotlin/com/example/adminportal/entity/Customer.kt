package com.example.adminportal.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer(
        @Id
        @GeneratedValue
        var id: Int = 0,

        @Column(nullable = false)
        var firstName: String = "",

        @Column(nullable = false)
        var lastName: String = ""
)