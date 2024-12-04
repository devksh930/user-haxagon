package me.devksh930.account.application.port.in.usecase;

import me.devksh930.account.application.port.in.command.UpdateEmailCommand;

public interface UpdateEmailUseCase {
	Long updateEmail(UpdateEmailCommand command);
}
