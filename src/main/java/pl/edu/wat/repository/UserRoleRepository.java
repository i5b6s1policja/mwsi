package pl.edu.wat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wat.entity.UserRole;

/**
 * Created by Paweł Skrzypkowski
 * Wojskowa Akademia Techniczna im. Jarosława Dąbrowskiego, Warszawa 2017.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
    UserRole findByRole(String role);
}
