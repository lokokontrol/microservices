package es.imcs.intellipay.web.demo;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.imcs.intellipay.accounts.entity.Account;

//@FeignClient(name = "AccountClient" , url="http://localhost:8082")
@FeignClient("zuul")
public interface AccountClient {
    
    @RequestMapping(method = RequestMethod.GET, value = "/accounts")
    List<Account> getAccounts();
    

    @RequestMapping(method = RequestMethod.POST, value = "/accounts")
    Account createAccount(Account account);

}
