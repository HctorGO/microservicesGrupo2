package mx.org.certificatic.springboot.practica15.eventsourcing.events.domainevents;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.org.certificatic.springboot.practica15.eventsourcing.domain.Account;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.DomainEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.exception.AccountException;
import mx.org.certificatic.springboot.practica15.eventsourcing.holder.AccountHolder;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
//descomenta @EqualsAndHashCode(callSuper = true)
//descomenta @ToString(callSuper = true)
public class MoneyDepositEvent extends DomainEvent /* descomenta extends DomainEvent */{

	private static final long serialVersionUID = 1L;

	private BigDecimal money;
	private int accountNo;

	// Define constructor
	public MoneyDepositEvent(long sequenceId, long createdTime, int accountNo, BigDecimal money) {
		super(sequenceId, createdTime, MoneyDepositEvent.class.getSimpleName());
		this.accountNo = accountNo;
		this.money = money;
	}
	
	
	// @Override
	public void process() {
		// Implementa
		
		Account account = AccountHolder.getAccount(accountNo);
		if(account == null) {
			throw new AccountException("Account '" + accountNo + "' not found");
		}
		
		account.handleEvent(this);
	}
}
