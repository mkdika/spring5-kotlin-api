package com.mkdika.springkotlinapi.repository

import com.mkdika.springkotlinapi.model.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Int>