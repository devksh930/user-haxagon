package me.devksh930.account.adapter.in.web.request;

public record CreateAccountRequest(
	String name,
	String email,
	String password
) {
}
