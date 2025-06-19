{\rtf1\ansi\ansicpg1252\cocoartf2821
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\froman\fcharset0 Times-Roman;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c0;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs24 \cf0 \expnd0\expndtw0\kerning0
\outl0\strokewidth0 \strokec2 package com.saidinesh.smartbank.service;\
\
import com.saidinesh.smartbank.model.Account;\
import com.saidinesh.smartbank.repository.AccountRepository;\
import org.springframework.beans.factory.annotation.Autowired;\
import org.springframework.stereotype.Service;\
\
import java.math.BigDecimal;\
import java.util.List;\
import java.util.Optional;\
\
@Service\
public class AccountService \{\
\
    @Autowired\
    private AccountRepository accountRepository;\
\
    public List<Account> getAllAccounts() \{\
        return accountRepository.findAll();\
    \}\
\
    public Optional<Account> getAccountById(Long id) \{\
        return accountRepository.findById(id);\
    \}\
\
    public Account createAccount(Account account) \{\
        account.setBalance(account.getBalance() != null ? account.getBalance() : BigDecimal.ZERO);\
        return accountRepository.save(account);\
    \}\
\
    public Account deposit(String accountNumber, BigDecimal amount) \{\
        Account account = accountRepository.findByAccountNumber(accountNumber)\
                .orElseThrow(() -> new RuntimeException("Account not found"));\
        account.deposit(amount);\
        return accountRepository.save(account);\
    \}\
\
    public Account withdraw(String accountNumber, BigDecimal amount) \{\
        Account account = accountRepository.findByAccountNumber(accountNumber)\
                .orElseThrow(() -> new RuntimeException("Account not found"));\
        if (account.getBalance().compareTo(amount) < 0) \{\
            throw new RuntimeException("Insufficient balance");\
        \}\
        account.withdraw(amount);\
        return accountRepository.save(account);\
    \}\
\
    public void deleteAccount(Long id) \{\
        accountRepository.deleteById(id);\
    \}\
\}\
}