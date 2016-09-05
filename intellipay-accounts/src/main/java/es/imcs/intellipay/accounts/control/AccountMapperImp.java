package es.imcs.intellipay.accounts.control;

import org.springframework.stereotype.Service;

import es.imcs.intellipay.accounts.boundary.AccountDTO;
import es.imcs.intellipay.accounts.boundary.AccountMapper;
import es.imcs.intellipay.accounts.entity.Account;

@Service
public class AccountMapperImp implements AccountMapper {

    public Account fromDto(AccountDTO accountDTO) {
	// TODO Auto-generated method stub
	Account account = new Account();
	account.setAccountType(accountDTO.getAccountType());
	account.setCitizenshipCountryCode(accountDTO.getCitizenshipCountryCode());
	account.setContactPhoneNumber(accountDTO.getContactPhoneNumber());
	account.setCurrencyCode(accountDTO.getCurrencyCode());
	account.setDateOfBirth(accountDTO.getDateOfBirth());
	account.setEmail(accountDTO.getEmail());
	account.setMobilePhoneNumber(accountDTO.getMobilePhoneNumber());
	account.setId(accountDTO.getIdAccount());
	return account;
    }

    public AccountDTO fromEntity(Account account) {
	// TODO Auto-generated method stub
	AccountDTO accountDTO = new AccountDTO();
	accountDTO.setAccountType(account.getAccountType());
	accountDTO.setCitizenshipCountryCode(account.getCitizenshipCountryCode());
	accountDTO.setContactPhoneNumber(account.getContactPhoneNumber());
	accountDTO.setCurrencyCode(account.getCurrencyCode());
	accountDTO.setDateOfBirth(account.getDateOfBirth());
	accountDTO.setEmail(account.getEmail());
	accountDTO.setMobilePhoneNumber(account.getMobilePhoneNumber());
	accountDTO.setIdAccount(account.getId());
	return accountDTO;
    }
   

}
