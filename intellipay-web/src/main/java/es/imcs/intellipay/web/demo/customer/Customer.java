package es.imcs.intellipay.web.demo.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="CUSTOMERS")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@EqualsAndHashCode(of={"id"})
@ToString(of={"firstName", "lastName"})
public class Customer {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;

	private String lastName;
}
