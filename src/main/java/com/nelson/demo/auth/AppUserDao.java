package com.nelson.demo.auth;

import java.util.Optional;

public interface AppUserDao {

    Optional<AppUser> getAppUserByUsername(String username);
}
