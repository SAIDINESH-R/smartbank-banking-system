{\rtf1\ansi\ansicpg1252\cocoartf2821
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 package com.saidinesh.smartbank.model;\
\
import jakarta.persistence.*;\
import java.math.BigDecimal;\
\
@Entity\
public class Account \{\
\
    @Id\
    @GeneratedValue(strategy = GenerationType.IDENTITY)\
    private Long id;\
\
    private String holderName;\
\
    @Column(unique = true, nullable = false)\
    private String accountNumber;\
\
    private BigDecimal balance;\
\
    // Constructors\
    public Account() \{\}\
\
    public Account(String holderName, String accountNumber, BigDecimal balance) \{\
        this.holderName = holderName;\
        this.accountNumber = accountNumber;\
        this.balance = balance;\
    \}\
\
    // Getters and setters\
    public Long getId() \{\
        return id;\
    \}\
\
    public String getHolderName() \{\
        return holderName;\
    \}\
\
    public void setHolderName(String holderName) \{\
        this.holderName = holderName;\
    \}\
\
    public String getAccountNumber() \{\
        return accountNumber;\
    \}\
\
    public void setAccountNumber(String accountNumber) \{\
        this.accountNumber = accountNumber;\
    \}\
\
    public BigDecimal getBalance() \{\
        return balance;\
    \}\
\
    public void setBalance(BigDecimal balance) \{\
        this.balance = balance;\
    \}\
\
    public void deposit(BigDecimal amount) \{\
        this.balance = this.balance.add(amount);\
    \}\
\
    public void withdraw(BigDecimal amount) \{\
        this.balance = this.balance.subtract(amount);\
    \}\
\}\
}