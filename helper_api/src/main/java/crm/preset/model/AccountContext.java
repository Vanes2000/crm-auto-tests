package crm.preset.model;

public record AccountContext(long id,String token) {

	public AccountContext {
		if (id <= 0) {
			throw new IllegalArgumentException("id должен быть больше 0, получено " + id);
		}
		if (token == null || token.isBlank()) {
			throw new IllegalArgumentException("токен не должен быть пустым");
		}
	}

	public static AccountContext root(long rootId,String rootToken) {
		return new AccountContext(rootId,rootToken);
	}
}