package me.devksh930.account.adapter.out.persistence;

import org.springframework.stereotype.Component;

import me.devksh930.account.application.port.out.LoadAccountPort;
import me.devksh930.account.application.port.out.SaveAccountPort;
import me.devksh930.account.domain.Account;

@Component
public class AccountPersistenceAdapter implements LoadAccountPort, SaveAccountPort {
	private final AccountRepository accountRepository;

	public AccountPersistenceAdapter(
		final AccountRepository accountRepository
	) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Account loadAccount(
		final Long accountId
	) {
		return accountRepository.findById(accountId)
			.map(entity -> new Account(
				entity.getId(),
				entity.getName(),
				entity.getEmail(),
				entity.getPassword()
			))
			.orElseThrow(() -> new RuntimeException("Account not found"));
	}

	@Override
	public Long saveAccount(final Account account) {
		final AccountEntity entity = new AccountEntity(
			account.id(),
			account.name(),
			account.email(),
			account.password()
		);
		final AccountEntity save = accountRepository.save(entity);
		return save.getId();
	}
}
