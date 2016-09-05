package es.imcs.intellipay.accounts.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import es.imcs.intellipay.accounts.boundary.AccountDTO;
import es.imcs.intellipay.accounts.boundary.AccountMapper;
import es.imcs.intellipay.accounts.boundary.AccountService;
import es.imcs.intellipay.accounts.entity.Account;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    	
	  private AccountRepository accountRepository;
	  private AccountMapper accountMapper;

	    @Autowired
	    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
		this.accountRepository = accountRepository;
		this.accountMapper = accountMapper;

	    }

    public Boolean validateAccount(Long idAccount) {
	// TODO Auto-generated method stub
	return Boolean.TRUE;

    }
    
    @Transactional
    @HystrixCommand
    public Account addAccount(AccountDTO accountDTO) {
	Account account = accountMapper.fromDto(accountDTO);
	return accountRepository.save(account);
    }
    
    @HystrixCommand
    public List<Account> findAll() {	
	return accountRepository.findAll();
    }
    
    @HystrixCommand
    public Account add (Account account){
	return accountRepository.save(account);
    }
    
}
