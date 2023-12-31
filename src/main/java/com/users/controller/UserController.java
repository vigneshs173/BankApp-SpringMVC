package com.users.controller;

import com.users.Service.ValidationService;
import com.users.model.TransactionHistory;
import com.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.users.Service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    private ValidationService validationService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<User> userList = userService.getAllUser();
        model.addAttribute("users", userList);
        return "list";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/add")
    public String insert(@ModelAttribute User user, Model model) {
        return validationService.validateUserDetails(user, model);
    }

    @GetMapping("delete/{accountNo}")
    public String delete(@PathVariable("accountNo")Long accountNo) {
        userService.deleteUser(accountNo);
        return "redirect:/list";
    }

    @GetMapping("update/{accountNo}")
    public String update(@PathVariable Long accountNo, Model model) {
        model.addAttribute("user", userService.getUser(accountNo));
        return "update";
    }

    @PostMapping("update/updateUser")
    public String updateUser(@ModelAttribute User user, Model model) {
        return validationService.validateUpdatedUser(user, model);
    }

    @GetMapping("/send/{accountNo}")
    public String send(@PathVariable Long accountNo,Model model) {
        model.addAttribute("sender", userService.getUser(accountNo));
        return "send";
    }

    @PostMapping("send/debitAmount")
    public String debit(@ModelAttribute TransactionHistory transactionHistory,Model model) {
        return validationService.validateTransaction(transactionHistory, model);
    }

    @GetMapping("/history")
    public String history(Model model) {
        List<TransactionHistory> TransactionHistory = userService.getAllHistory();
        model.addAttribute("transactionHistory", TransactionHistory);
        return "history";
    }

    @GetMapping("/viewHistory/{accountNo}")
    public String sendHistory(@PathVariable Long accountNo, Model model) {

        List<TransactionHistory> debitTransaction = userService.getDebitTransaction(accountNo);
        List<TransactionHistory> creditTransaction = userService.getCreditTransaction(accountNo);

        model.addAttribute("debit", debitTransaction);
        model.addAttribute("credit", creditTransaction);
        model.addAttribute("accountNo", accountNo);

        return "viewHistory";
    }
}