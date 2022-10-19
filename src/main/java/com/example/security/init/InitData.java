package com.example.security.init;

import com.example.security.Entity.Role;
import com.example.security.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {
    final RoleRepository repo;

    public InitData(RoleRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {

        Role role1=new Role();
        role1.setAuthority("USER");
        repo.save(role1);

        Role role2=new Role();
        role2.setAuthority("MODER");
        repo.save(role2);

        Role role3=new Role();
        role3.setAuthority("ADMIN");
        repo.save(role3);

    }
}
