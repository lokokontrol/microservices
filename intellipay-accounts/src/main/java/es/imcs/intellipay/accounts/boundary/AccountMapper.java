package es.imcs.intellipay.accounts.boundary;

import es.imcs.intellipay.accounts.entity.Account;

public interface AccountMapper {
	
	Account fromDto (AccountDTO accountDTO);
	AccountDTO fromEntity (Account account);

}
