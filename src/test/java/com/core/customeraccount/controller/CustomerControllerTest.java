package com.core.customeraccount.controller;

import com.core.customeraccount.dto.CustomerDTO;
import com.core.customeraccount.exception.CustomerNotFoundException;
import com.core.customeraccount.exception.ValueNotValidException;
import com.core.customeraccount.service.CustomerService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
@RunWith(SpringRunner.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void givenCustomerID_whenFetchCustomerInfo_thenReturnJson() throws Exception {

        CustomerDTO customer = CustomerDTO.builder()
                .name("testName")
                .surname("testSurname").build();
        given(customerService.fetchCustomerInfo(1L)).willReturn(customer);

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/customers/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is(customer.getName())));
    }

    @Test
    public void givenCustomerID_whenFetchCustomerInfo_andCustomerNotFound_thenReturnError() throws Exception {

        given(customerService.fetchCustomerInfo(2L)).willThrow(new CustomerNotFoundException(2L));

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/customers/{id}", 2L))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void givenCustomerID_whenFetchCustomerInfo_andValueNotValid_thenReturnError() throws Exception {

        given(customerService.fetchCustomerInfo(-1L)).willThrow(new ValueNotValidException());

        mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/customers/{id}", -1))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
