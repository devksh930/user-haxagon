package me.devksh930.account.application.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.devksh930.account.application.port.in.command.CreateAccountCommand;
import me.devksh930.account.application.port.in.usecase.CreateAccountUseCase;
import me.devksh930.account.application.port.in.command.UpdateEmailCommand;
import me.devksh930.account.application.port.in.usecase.UpdateEmailUseCase;
import me.devksh930.account.application.port.out.LoadAccountPort;
import me.devksh930.account.application.port.out.SaveAccountPort;
import me.devksh930.account.domain.Account;

@Service
public class AccountService implements CreateAccountUseCase, UpdateEmailUseCase {
	private final PasswordEncoder passwordEncoder;
	private final SaveAccountPort saveAccountPort;
	private final LoadAccountPort loadAccountPort;

	public AccountService(
		final SaveAccountPort saveAccountPort,
		final LoadAccountPort loadAccountPort,
		final PasswordEncoder passwordEncoder
	) {
		this.saveAccountPort = saveAccountPort;
		this.loadAccountPort = loadAccountPort;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Long createAccount(
		final CreateAccountCommand command
	) {
		final Account account = new Account(
			0L,
			command.name(),
			command.email(),
			passwordEncoder.encode(command.password())
		);
		return saveAccountPort.saveAccount(account);
	}

	@Override
	public Long updateEmail(
		final UpdateEmailCommand command
	) {
		final Account account = loadAccountPort.loadAccount(command.id());
		final Account updateAccount = account.updateEmail(command.email());

		return saveAccountPort.saveAccount(updateAccount);
	}

}
