package me.devksh930.account.application.port.out;

import me.devksh930.account.domain.Account;

public interface SaveAccountPort {
	Long saveAccount(Account account);
}
