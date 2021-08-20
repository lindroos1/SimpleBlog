package com.example.simpleblog.User.Repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.simpleblog.models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	
	@Query("SELECT u FROM UserEntity u WHERE u.Name = :Name")
	
	public UserEntity getUserByUsername(@Param("Name") String username);
	
	
	//public  <S extends UserRepository> UserEntity save(S UserEntity);
	
	//this method was used when extending JpaRepository, not CrudRepository!!!!
	//Optional<UserEntity> findByName(String username);
}
 