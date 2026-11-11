package crm.preset.model;

public record AccountContext(long id, String token) {

    public AccountContext {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be > 0, got " + id);
        }
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("token must be non-blank");
        }
    }
    public static AccountContext root(long rootId, String rootToken){
        return new AccountContext(rootId, rootToken);
    }
}