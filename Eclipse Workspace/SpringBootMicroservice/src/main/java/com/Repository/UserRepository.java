package com.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findById(int id);
	
	@Query(value = "select * from user where username = :un and password = :p",nativeQuery = true)
	public User validate(@Param("un") String username, @Param("p") String password);
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);

}
