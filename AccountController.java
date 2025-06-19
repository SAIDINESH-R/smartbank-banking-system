{\rtf1\ansi\ansicpg1252\cocoartf2821
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 package com.saidinesh.smartbank.controller;\
\
import com.saidinesh.smartbank.model.Account;\
import com.saidinesh.smartbank.service.AccountService;\
import org.springframework.beans.factory.annotation.Autowired;\
import org.springframework.http.ResponseEntity;\
import org.springframework.web.bind.annotation.*;\
\
import java.math.BigDecimal;\
import java.util.List;\
import java.util.Optional;\
\
@RestController\
@RequestMapping("/api/accounts")\
public class AccountController \{\
\
    @Autowired\
    private AccountService accountService;\
\
    @GetMapping\
    public List<Account> getAllAccounts() \{\
        return accountService.getAllAccounts();\
    \}\
\
    @GetMapping("/\{id\}")\
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) \{\
        Optional<Account> account = accountService.getAccountById(id);\
        return account.map(ResponseEntity::ok)\
                      .orElseGet(() -> ResponseEntity.notFound().build());\
    \}\
\
    @PostMapping\
    public ResponseEntity<Account> createAccount(@RequestBody Account account) \{\
        return ResponseEntity.ok(accountService.createAccount(account));\
    \}\
\
    @PostMapping("/\{accountNumber\}/deposit")\
    public ResponseEntity<Account> deposit(@PathVariable String accountNumber,\
                                           @RequestParam BigDecimal amount) \{\
        return ResponseEntity.ok(accountService.deposit(accountNumber, amount));\
    \}\
\
    @PostMapping("/\{accountNumber\}/withdraw")\
    public ResponseEntity<Account> withdraw(@PathVariable String accountNumber,\
                                            @RequestParam BigDecimal amount) \{\
        return ResponseEntity.ok(accountService.withdraw(accountNumber, amount));\
    \}\
\
    @DeleteMapping("/\{id\}")\
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) \{\
        accountService.deleteAccount(id);\
        return ResponseEntity.noContent().build();\
    \}\
\}\
}