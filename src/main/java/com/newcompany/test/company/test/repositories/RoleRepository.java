package com.newcompany.test.company.test.repositories;


import com.newcompany.test.company.test.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);

}
