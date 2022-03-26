package duthris.ecommerce.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import duthris.ecommerce.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
