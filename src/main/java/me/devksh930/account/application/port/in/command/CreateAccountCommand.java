package me.devksh930.account.application.port.in.command;

public record CreateAccountCommand(
	String name,
	String email,
	String password
) {
}
