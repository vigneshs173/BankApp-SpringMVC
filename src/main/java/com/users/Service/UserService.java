package com.users.Service;

import com.users.dao.UserDao;
import com.users.model.TransactionHistory;
import com.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

	private final UserDao userDao;

	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void addUser(User user) {
		userDao.saveUser(user);
	}

	@Transactional
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Transactional
	public List<TransactionHistory> getAllHistory() {
		return userDao.getAllHistory();
	}

	@Transactional
	public void deleteUser(Long accountNo) {
		User user = userDao.getUserById(accountNo);
		if(user != null) {
			user.setActive(0);
		}
		userDao.updateUser(user);
	}

	@Transactional
	public User getUser(Long accountNo) {
		return userDao.getUserById(accountNo);
	}

	@Transactional
	public List<TransactionHistory> getDebitTransaction(Long senderNo) {
		return userDao.getSendTransactionById(senderNo);
	}
	@Transactional
	public List<TransactionHistory> getCreditTransaction(Long receiverNo) {
		return userDao.getReceiveTransactionById(receiverNo);
	}

	@Transactional
	public void updateNow(User user) {
		userDao.updateUser(user);
	}

	@Transactional
	public void moneyTransaction(TransactionHistory transactionHistory) {
		User sender = getUser(transactionHistory.getSenderNo());
		User receiver = getUser(transactionHistory.getReceiverNo());
		moneyTransfer(sender,receiver,transactionHistory.getTransactionalAmount());
		userDao.saveTransaction(transactionHistory);
	}

	@Transactional
	public void moneyTransfer(User sender, User receiver, Long amount) {

		Long debitAmount = sender.getBalance() - amount;
		Long creditAmount = receiver.getBalance() + amount;

		sender.setBalance(debitAmount);
		receiver.setBalance(creditAmount);

		updateNow(sender);
		updateNow(receiver);

	}
}
