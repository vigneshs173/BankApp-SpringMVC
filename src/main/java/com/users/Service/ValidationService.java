package com.users.Service;

import com.users.dao.UserDao;
import com.users.model.TransactionHistory;
import com.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Objects;

@Service
public class ValidationService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;


    public String validateTransaction(TransactionHistory transactionHistory, Model model) {
        if(transactionHistory.getReceiverNo() != null && transactionHistory.getTransactionalAmount() != null) {
            User receiver = userService.getUser(transactionHistory.getReceiverNo());
            User sender = userService.getUser(transactionHistory.getSenderNo());

            if (receiver != null) {
                if (!Objects.equals(sender.getAccountNo(), receiver.getAccountNo())) {
                    if (sender.getBalance() >= transactionHistory.getTransactionalAmount()) {
                        userService.moneyTransaction(transactionHistory);
                        return "redirect:/list";
                    } else
                        model.addAttribute("balance", "Sorry! You don't have enough balance");
                } else
                    model.addAttribute("receiver", "Sorry! this is your accoumt no!");
            } else
                model.addAttribute("receiver", "Sorry! This account No is not exist");
        }
        else if(transactionHistory.getReceiverNo() == null && transactionHistory.getTransactionalAmount() == null) {
            model.addAttribute("receiver", "please enter Account No");
            model.addAttribute("balance", "please enter transactional amount");
        }
        else if(transactionHistory.getReceiverNo() == null)
            model.addAttribute("receiver", "please enter Account No");
        else
            model.addAttribute("balance", "please enter transactional amount");
        return "send";
    }

    public String validateUserDetails(User user, Model model) {
        if(isPresent(user)) {
            if(!user.getName().matches("^[a-zA-Z\\s]*$")){
                model.addAttribute("name", "Name should only alphabets");
                return "home";
            }
            else if(!user.getEmail().contains("@") || !user.getEmail().contains(".")){
                model.addAttribute("invalidEmail", "Please enter valid Email");
                return "home";
            }
           else if(isIdNotExist(user.getAccountNo())) {
               userService.addUser(user);
               return "redirect:/list";
            }
            model.addAttribute("accountNo", "Account No is alredy exist in DB");
            return "home";
        }
        else {
            if (user.getAccountNo() == null && user.getName().isEmpty() && user.getBalance() == null && user.getEmail().isEmpty() && user.getAddress().isEmpty()) {
                model.addAttribute("isAllEmpty", "Please enter all fields");
                return "home";
            }
            if (user.getAccountNo() == null)
                model.addAttribute("accountNo", "Please enter Account No");
            if (user.getName().isEmpty() || !user.getName().matches("^[a-zA-Z\\s]*$"))
                model.addAttribute("name", "Please enter valid Name");
            if (user.getBalance() == null)
                model.addAttribute("balance", "Please enter Balance");
            if (user.getEmail().isEmpty() || !user.getEmail().contains("@") || !user.getEmail().contains("."))
                model.addAttribute("invalidEmail", "Please enter valid Email");
            if (user.getAddress().isEmpty())
                model.addAttribute("address", "Please enter Address");
            return "home";
        }
    }

    public boolean isPresent(User user) {
        return user.getAccountNo() != null && !user.getName().isEmpty() && user.getBalance() != null && !user.getEmail().isEmpty() && !user.getAddress().isEmpty();
    }
    public boolean isIdNotExist(Long accountNo) {
        User user = userDao.getUserById(accountNo);
        return user == null;
    }

    public String validateUpdatedUser(User user, Model model) {

        if(isPresent(user)) {
            if(!user.getName().matches("^[a-zA-Z\\s]*$")){
                model.addAttribute("name", "Name only should alphabets");
                return "update";
            }
            userService.updateNow(user);
            return "redirect:/list";
        }
        else {
            if (user.getName().isEmpty() && !user.getName().matches("^[a-zA-Z\\s]*$"))
                model.addAttribute("name", "Please valid Name");
            if (user.getBalance() == null)
                model.addAttribute("balance", "Please enter Balance");
            if (user.getEmail().isEmpty() || !user.getEmail().contains("@") || !user.getEmail().contains("."))
                model.addAttribute("invalidEmail", "Please enter valid Email");
            if (user.getAddress().isEmpty())
                model.addAttribute("address", "Please enter Address");
            return "update";
        }
    }
}
