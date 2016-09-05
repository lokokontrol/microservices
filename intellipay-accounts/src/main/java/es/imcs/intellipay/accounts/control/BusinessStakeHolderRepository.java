package es.imcs.intellipay.accounts.control;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.imcs.intellipay.accounts.entity.BusinessStakeHolder;

@Repository
public interface BusinessStakeHolderRepository extends JpaRepository<BusinessStakeHolder, Long> {

}
