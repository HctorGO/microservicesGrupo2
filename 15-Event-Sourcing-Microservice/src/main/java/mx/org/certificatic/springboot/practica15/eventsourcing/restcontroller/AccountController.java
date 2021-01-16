package mx.org.certificatic.springboot.practica15.eventsourcing.restcontroller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.org.certificatic.springboot.practica15.eventsourcing.domain.Account;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.domainevents.AccountCreateEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.domainevents.MoneyDepositEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.events.domainevents.MoneyWithdrawalEvent;
import mx.org.certificatic.springboot.practica15.eventsourcing.holder.AccountHolder;
import mx.org.certificatic.springboot.practica15.eventsourcing.processor.DomainEventProcessor;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private DomainEventProcessor domainEventProcessor;

	@GetMapping("/")
	public Map<Integer, Account> accounts() {

		// Implementa
		return AccountHolder.getAll();
	}

	@GetMapping("/{tenant}")
	public Account accountOf(@PathVariable String tenant) {

		// Implementa
		return AccountHolder.getAccount(tenant);
	}

	@GetMapping("/{tenant}/create")
	public String createAccountOf(@PathVariable String tenant) {

		AccountCreateEvent newAccountEvent = new AccountCreateEvent(
				AccountHolder.nextEventId(),
				new Date().getTime(),
				AccountHolder.nextAccountId(),
				tenant);

		domainEventProcessor.process(newAccountEvent);
		
		Account tenantAccount = AccountHolder.getAccount(tenant);
		
		if(tenantAccount == null) {
			return "Cannot: " + tenant;
		} else return tenant + " account created";
	}

	@GetMapping("/{tenant}/deposit/{amount}")
	public String accountDeposit(@PathVariable String tenant, @PathVariable BigDecimal amount) {

		Account tenantAccount = AccountHolder.getAccount(tenant);
		
		if(tenantAccount != null) {
			MoneyDepositEvent money = new MoneyDepositEvent(AccountHolder.nextEventId(), new Date().getTime(), tenantAccount.getAccountNo(), amount);
			
			domainEventProcessor.process(money);
			return tenant + " deposit done !";
		}
		
		return tenant + " account doest exists";
	}

	@GetMapping("/{tenant}/withdrawal/{amount}")
	public String accountWithdrawal(@PathVariable String tenant, @PathVariable BigDecimal amount) {

		Account tenantAccount = AccountHolder.getAccount(tenant);
		
		if(tenantAccount != null) {
			MoneyWithdrawalEvent money = new MoneyWithdrawalEvent(AccountHolder.nextEventId(), new Date().getTime(), tenantAccount.getAccountNo(), amount);
			
			domainEventProcessor.process(money);
			return tenant + " Withdrawal done !";
		}
		
		return tenant + " account doest exists";
	}
}
