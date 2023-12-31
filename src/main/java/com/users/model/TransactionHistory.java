package com.users.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionNo ;

    /*@ManyToOne
    @JoinColumn(name = "senderNo", referencedColumnName = "accountNo")
    private User sender;*/

    private Long senderNo;
    private Long receiverNo;
    private Long transactionalAmount;
    private LocalDateTime dateTime;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @PrePersist
    protected void onCreate() {
        dateTime = LocalDateTime.now();
    }

    public Long getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(Long transactionNo) {
        this.transactionNo = transactionNo;
    }

    public Long getSenderNo() {
        return senderNo;
    }

    public void setSenderNo(Long senderNo) {
        this.senderNo = senderNo;
    }

    public Long getReceiverNo() {
        return receiverNo;
    }

    public void setReceiverNo(Long receiverNo) {
        this.receiverNo = receiverNo;
    }

    public Long getTransactionalAmount() {
        return transactionalAmount;
    }

    public void setTransactionalAmount(Long transactionalAmount) {
        this.transactionalAmount = transactionalAmount;
    }
}
