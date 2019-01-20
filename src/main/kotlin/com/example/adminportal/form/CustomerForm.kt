package com.example.adminportal.form

import lombok.Data
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Data
class CustomerForm(
        @NotNull
        @Size(min = 1, max = 127)
        var firstName: String? = null,

        @NotNull
        @Size(min = 1, max = 127)
        var lastName: String? = null
)