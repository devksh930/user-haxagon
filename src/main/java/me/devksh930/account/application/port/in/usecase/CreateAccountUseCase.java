package me.devksh930.account.application.port.in.usecase;

import me.devksh930.account.application.port.in.command.CreateAccountCommand;

public interface CreateAccountUseCase {
	Long createAccount(CreateAccountCommand command);
}
