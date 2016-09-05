package es.imcs.intellipay.payments.control;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.imcs.intellipay.payments.entity.Payer;

@Repository
public interface PayerRepository extends JpaRepository<Payer, Long> {
	
	List<Payer> findBylastnameStartsWithIgnoreCase(String lastname);

}