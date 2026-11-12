package crm.preset.model;

import crm.preset.role.Role;

public record AccountPreset(long id,
                            String login,
                            String password,
                            Role role,
                            AccountContext context) {

    public AccountPreset {
        if (id <= 0) {
            throw new IllegalArgumentException("id должен быть > 0, получено " + id);
        }
        if (login == null || login.isBlank( )) {
            throw new IllegalArgumentException("login не может быть пустым или null");
        }
        if (password == null || password.isBlank( )) {
            throw new IllegalArgumentException("password не может быть пустым или null");
        }
        if (role == null) {
            throw new IllegalArgumentException("роль не может быть null");
        }
        if (context == null) {
            throw new IllegalArgumentException("контекст не может быть null");
        }

    }

}
