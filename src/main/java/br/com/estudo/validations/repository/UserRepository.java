package br.com.estudo.validations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.estudo.validations.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserId(int id);

}
