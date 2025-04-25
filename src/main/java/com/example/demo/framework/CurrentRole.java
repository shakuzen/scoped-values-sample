package com.example.demo.framework;

import java.lang.ScopedValue;

public final class CurrentRole {
    static ScopedValue<Role> ROLE = ScopedValue.newInstance();

    private CurrentRole() {}

    public static Role get() {
        return ROLE.orElse(Role.UNKNOWN);
    }

}
