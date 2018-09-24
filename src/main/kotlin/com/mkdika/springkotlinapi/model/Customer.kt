package com.mkdika.springkotlinapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.persistence.GenerationType

/**
 * all properties must have default value in order to be generated the default constructor by Kotlin.
 */
@Entity
data class Customer(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int = 0,

        @get: NotBlank
        var firstName: String = "",

        @get: NotBlank
        var lastName: String = "",

        var balance: Double = 0.0
)