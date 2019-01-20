package com.example.adminportal.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Table(name = "admin_portal_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
class AdminPortalUser(
        @Id @GeneratedValue var adminPortalUserId: Long,
        @Column(nullable = false) var email: String = "",
        @Column(nullable = false) var password: String = ""
)