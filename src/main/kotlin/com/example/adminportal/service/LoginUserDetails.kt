package com.example.adminportal.service

import com.example.adminportal.entity.AdminPortalUser
import lombok.Data
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User

@Data
class LoginUserDetails(user: AdminPortalUser): User(
        user.email, user.password,
        AuthorityUtils.createAuthorityList("ROLE_USER")
) {
    var user: AdminPortalUser? = null

    init {
        this.user = user
    }
}