package com.mkdika.springkotlinapi.controller

import com.mkdika.springkotlinapi.SpringKotlinApiApplication
import com.mkdika.springkotlinapi.model.Customer
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit4.SpringRunner

/**
 * Customer Controller Integration Test
 */
@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(SpringKotlinApiApplication::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CustomerControllerIT {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    lateinit var headers: HttpHeaders

    @Before
    fun `setup`() {
        headers = HttpHeaders()
    }

    @Test
    fun `given nothing when called findAllCustomer then should return list`() {
        val result = testRestTemplate.getForEntity("/api/customer", CustomerList::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result?.body?.size).isEqualTo(3)
    }

    @Test
    fun `given available id when call findCustomerById then should return customer`() {
        val result = testRestTemplate.getForEntity("/api/customer/3", Customer::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result?.body).isEqualTo(Customer(id = 3, firstName = "John", lastName = "Doe", balance = 0.12))
    }

    @Test
    fun `given not available id when findCustomerById then should return notFound`() {
        val result = testRestTemplate.getForEntity("/api/customer/99", Customer::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }

    @Test
    fun `given available id when deleteCustomer then should return noContent`() {
        val result = testRestTemplate.exchange("/api/customer/1", HttpMethod.DELETE, HttpEntity.EMPTY, String::class.java)

        assertThat(result).isNotNull
        assertThat(result.statusCode).isEqualTo(HttpStatus.NO_CONTENT)
    }

    @Test
    fun `given not available id when deleteCustomer then should return notFound`() {
        val result = testRestTemplate.exchange("/api/customer/99", HttpMethod.DELETE, HttpEntity.EMPTY, String::class.java)

        assertThat(result).isNotNull
        assertThat(result.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }

    @Test
    fun `given newCustomer when createCustomer then should return customer`() {
        val newCustomer = Customer(firstName = "Brucel", lastName = "Lie", balance = 17.5)
        val httpEntity = HttpEntity<Customer>(newCustomer, headers)
        val result = testRestTemplate.exchange("/api/customer", HttpMethod.POST, httpEntity, Customer::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result?.body).isEqualTo(Customer(id = 4, firstName = "Brucel", lastName = "Lie", balance = 17.5))
    }

    @Test
    fun `given Customer with available id when updateCustomer then should return customer`() {
        val updateCustomer = Customer(id=2, firstName = "Maximilian",lastName = "Genus", balance = 55.55)
        val httpEntity = HttpEntity<Customer>(updateCustomer, headers)
        val result = testRestTemplate.exchange("/api/customer/2", HttpMethod.PUT, httpEntity, Customer::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(result?.body).isEqualTo(Customer(id = 2, firstName = "Maximilian", lastName = "Genus", balance = 55.55))
    }

    @Test
    fun `given Customer with not available id when updateCustomer then should return customer`() {
        val updateCustomer = Customer(id=99, firstName = "Maximilian",lastName = "Genus", balance = 55.55)
        val httpEntity = HttpEntity<Customer>(updateCustomer, headers)
        val result = testRestTemplate.exchange("/api/customer/99", HttpMethod.PUT, httpEntity, Customer::class.java)

        assertThat(result).isNotNull
        assertThat(result?.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }

}

class CustomerList : MutableList<Customer> by ArrayList()