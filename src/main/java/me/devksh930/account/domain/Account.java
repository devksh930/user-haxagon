package me.devksh930.account.domain;

public record Account(
	Long id,
	String name,
	String email,
	String password
) {
	public Account updateEmail(String email) {
		return new Account(
			this.id,
			this.name,
			email,
			this.password
		);
	}
}
