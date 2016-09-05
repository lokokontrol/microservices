package es.imcs.intellipay.account.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.imcs.intellipay.accounts.boundary.AccountService;
import es.imcs.intellipay.accounts.entity.Account;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    
    @RequestMapping( value = "/accounts/{id}/validate", method = RequestMethod.GET)
    public Boolean validateAccount() {
        return Boolean.TRUE;
    }
    
    @RequestMapping (value = "/accounts", method = RequestMethod.GET)
    public List<Account> getAccounts(){
	return accountService.findAll() ;

    }
    
    @RequestMapping (value = "/accounts", method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account){
	log.info("Pasamos por el restController");
	log.info(account.toString());
	
    return accountService.add(account);

    }
    
    
    
	
}
