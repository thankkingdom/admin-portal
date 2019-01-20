package com.example.adminportal.service

import com.example.adminportal.entity.AdminPortalUser
import com.example.adminportal.repository.AdminPortalUserRepository
import org.springframework.data.domain.Example
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import java.util.*

@Component
class LoginUserDetailService(var adminPortalUserRepository: AdminPortalUserRepository) : UserDetailsService {

    override fun loadUserByUsername(email: String) : UserDetails {
        var userOpt: Optional<AdminPortalUser> = adminPortalUserRepository.findByEmail(email)
        if (!userOpt.isPresent) {
            throw UsernameNotFoundException("The requested user is not found")
        }
        return LoginUserDetails(userOpt.get())
    }
}