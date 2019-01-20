package com.example.adminportal.repository

import com.example.adminportal.entity.AdminPortalUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AdminPortalUserRepository : JpaRepository<AdminPortalUser, Long> {
    fun findByEmail(email: String) : Optional<AdminPortalUser>
}