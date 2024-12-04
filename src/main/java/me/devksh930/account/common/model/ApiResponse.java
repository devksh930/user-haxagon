package me.devksh930.account.common.model;

public record ApiResponse<T>(
	String status,
	T data
) {

	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<>(
			"success",
			data
		);
	}

	public static <T> ApiResponse<T> error(T error) {
		return new ApiResponse<>(
			"error",
			error
		);
	}

}