package com.core.customeraccount.controller;

import com.core.customeraccount.dto.AccountDTO;
import com.core.customeraccount.dto.request.AccountReqDTO;
import com.core.customeraccount.service.AccountService;
import com.core.customeraccount.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Mock
    AccountService accountService;

    @InjectMocks
    AccountController accountController;

    @Test
    public void givenAccountReq_whenOpenAccount_thenReturnJson() throws Exception {

        BigDecimal credit = BigDecimal.TEN;
        AccountReqDTO accountReqDTO = AccountReqDTO.builder()
                .customerId(1L)
                .initialCredit(credit)
                .build();

        AccountDTO accountDTO = AccountDTO.builder()
                .accountNumber("test account")
                .balance(credit)
                .build();

        given(accountService.openAccount(accountReqDTO)).willReturn(accountDTO);

        mvc.perform(post("/api/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Util.objectToString((accountReqDTO))))
                .andExpect(status().isOk());
    }

    @Test
    public void givenAccountReq_whenOpenAccount_andCustomerNotFound_thenReturnError() throws Exception {

        Long customerId = 100L;
        AccountReqDTO accountReqDTO = AccountReqDTO.builder()
                .customerId(customerId)
                .initialCredit(BigDecimal.TEN)
                .build();

        mvc.perform(post("/api/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Util.objectToString((accountReqDTO))))
                .andExpect(status().isNotFound());
    }

    @Test
    public void givenAccountReq_whenOpenAccount_andValueNotValid_thenReturnError() throws Exception {

        AccountReqDTO accountReqDTO = AccountReqDTO.builder()
                .customerId(null)
                .initialCredit(BigDecimal.TEN)
                .build();

        mvc.perform(post("/api/v1/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Util.objectToString((accountReqDTO))))
                .andExpect(status().is4xxClientError());
    }
}
