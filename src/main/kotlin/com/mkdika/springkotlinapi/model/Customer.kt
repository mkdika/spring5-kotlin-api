package com.mkdika.springkotlinapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Customer(
        @Id
        @GeneratedValue
        var id: Int,

        @get: NotBlank
        var firstName: String,

        @get: NotBlank
        var lastName: String,

        var balance: Double
)