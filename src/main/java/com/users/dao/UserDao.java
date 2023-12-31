package com.users.dao;

import com.users.model.TransactionHistory;
import com.users.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveUser(User user) {
        try (Session session = sessionFactory.openSession()) {

            Transaction tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }
    }

    public void saveTransaction(TransactionHistory transactionHistory) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(transactionHistory);
            tx.commit();
        }
    }

    public List<User> getAllUser() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM User where active = 1";
            return session.createQuery(hql, User.class).getResultList();
        }
    }

    public List<TransactionHistory> getAllHistory() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM TransactionHistory";
            return session.createQuery(hql, TransactionHistory.class).getResultList();
        }
    }

    public User getUserById(Long accountNo) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, accountNo);
        }
    }

    public List<TransactionHistory> getSendTransactionById(Long senderNo) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM TransactionHistory WHERE senderNo = " + senderNo;
            return session.createQuery(hql, TransactionHistory.class).getResultList();
        }
    }
    public List<TransactionHistory> getReceiveTransactionById(Long receiverNo) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM TransactionHistory WHERE receiverNo = " + receiverNo;
            return session.createQuery(hql, TransactionHistory.class).getResultList();
        }
    }

    public void updateUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        }
    }
}
