package com.nelson.demo.auth;



import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.nelson.demo.security.AppUserRole.*;

@Repository("nelson")
public class AppUserDaoService implements AppUserDao{

    private final PasswordEncoder passwordEncoder;

    public AppUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AppUser> getAppUserByUsername(String username) {
        return getAppUsers()
                .stream()
                .filter(appUser -> username.equals(appUser.getUsername()))
                .findFirst();
    }

    private List<AppUser> getAppUsers(){
        List<AppUser> appUsers = Lists.newArrayList(
                new AppUser(
                     "nel",
                      passwordEncoder.encode("123"),
                      STUDENT.grantedAuthorities(),
                     true,
                     true,
                     true,
                     true
             ),
                new AppUser(
                        "tan",
                        passwordEncoder.encode("123"),
                        ADMIN.grantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new AppUser(
                        "pet",
                        passwordEncoder.encode("123"),
                        ADMINTRAINEE.grantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );
        return appUsers;
    }
}
