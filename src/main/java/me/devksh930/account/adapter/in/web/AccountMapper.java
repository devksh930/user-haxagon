package me.devksh930.account.adapter.in.web;

import org.springframework.stereotype.Component;

import me.devksh930.account.adapter.in.web.request.CreateAccountRequest;
import me.devksh930.account.application.port.in.command.CreateAccountCommand;

@Component
public class AccountMapper {
	public CreateAccountCommand toCreateAccountCommand(
		CreateAccountRequest request
	) {
		return new CreateAccountCommand(
			request.name(),
			request.email(),
			request.password()
		);
	}
}
