package es.imcs.intellipay.accounts.boundary;

import java.util.List;

import es.imcs.intellipay.accounts.entity.Account;

public interface AccountService {
    
   Account addAccount(AccountDTO accountDTO);
    Boolean validateAccount(Long idAccount);
    List<Account> findAll();
    Account add(Account account);
    
    
}
