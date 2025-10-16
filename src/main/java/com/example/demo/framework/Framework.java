package com.example.demo.framework;

import java.util.Random;

public final class Framework {

    private final Application application;

    public static Framework withApplication(Application application) {
        return new Framework(application);
    }

    private Framework(Application application) {
        this.application = application;
    }

    public void serve(Request request, Response response) {
        Role role = determineRole(request);
        ScopedValue.where(CurrentRole.ROLE, role)
                .run(() -> application.handle(request, response));
    }

    public static String readKey(String ignored) {
        checkRole();
        return "something";
    }

    private static void checkRole() {
        Role role = CurrentRole.get();
        if (role != Role.USER && role != Role.ADMIN) {
            throw new InsufficientRoleException(role);
        }
    }

    private static Role determineRole(Request ignored) {
        return new Random().nextBoolean() ? Role.USER : Role.ADMIN;
    }

    public static class InsufficientRoleException extends RuntimeException {
        public InsufficientRoleException(Role role) {
            super("Insufficient role: " + role);
        }
    }
}
