package me.devksh930.account.adapter.in.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.devksh930.account.adapter.in.web.request.CreateAccountRequest;
import me.devksh930.account.application.port.in.command.CreateAccountCommand;
import me.devksh930.account.application.port.in.usecase.CreateAccountUseCase;

@RestController
@RequestMapping("/account")
public class AccountController {
	private final CreateAccountUseCase createAccountUseCase;
	private final AccountMapper accountMapper;

	public AccountController(
		final CreateAccountUseCase createAccountUseCase,
		final AccountMapper accountMapper
	) {
		this.createAccountUseCase = createAccountUseCase;
		this.accountMapper = accountMapper;
	}

	@PostMapping
	public ResponseEntity<Void> createAccount(
		@RequestBody final CreateAccountRequest request
	) {
		final CreateAccountCommand command = accountMapper.toCreateAccountCommand(request);
		createAccountUseCase.createAccount(command);
		return ResponseEntity.created(URI.create("/account/me")).build();
	}
}
