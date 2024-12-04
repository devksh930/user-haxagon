package me.devksh930.account.application.port.in.command;

public record UpdateEmailCommand(
	Long id,
	String email
) {
}
