package com.core.customeraccount.controller;

import com.core.customeraccount.dto.AccountDTO;
import com.core.customeraccount.dto.CustomerDTO;
import com.core.customeraccount.dto.request.AccountReqDTO;
import com.core.customeraccount.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller to handle web operations
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/web/v1")
public class WebController {

    private final CustomerService customerService;

    private final AccountController accountController;

    @GetMapping("/customers")
    public String showAllCustomers(Model model) {
        List<CustomerDTO> customers = customerService.fetchAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/customers/{id}")
    public String showCustomerAccounts(Model model, @PathVariable Long id) {
        CustomerDTO customerInfo = customerService.fetchCustomerInfo(id);

        model.addAttribute("customerId", customerInfo.getId());
        model.addAttribute("name", customerInfo.getName());
        model.addAttribute("surname", customerInfo.getSurname());
        model.addAttribute("accounts", customerInfo.getAccounts());

        AccountReqDTO accountReqDTO = AccountReqDTO.builder()
                .customerId(id)
                .build();
        model.addAttribute("accountReqDTO", accountReqDTO);
        return "accounts";
    }

    @GetMapping("/customers/{customerId}/accounts/{accountId}")
    public String showAccountTransactions(Model model,
                                          @PathVariable Long customerId,
                                          @PathVariable Long accountId) {

        CustomerDTO customerInfo = customerService.fetchCustomerInfo(customerId);

        AccountDTO found = customerInfo.getAccounts().stream()
                .filter(account -> accountId.equals(account.getId()))
                .findFirst()
                .orElse(null);

        model.addAttribute("customerId", customerId);
        model.addAttribute("customerName", customerInfo.getName());
        model.addAttribute("customerSurname", customerInfo.getSurname());
        model.addAttribute("accountNumber", found.getAccountNumber());
        model.addAttribute("transactions", found.getTransactions());
        return "transactions";
    }

    @PostMapping("/accounts")
    public String openAccount(@ModelAttribute("accountReqDTO") AccountReqDTO accountReqDTO) {
        accountController.openAccount(accountReqDTO);
        return "redirect:/web/v1/customers/" + accountReqDTO.getCustomerId();
    }
}
