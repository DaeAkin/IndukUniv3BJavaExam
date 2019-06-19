package iducs.springboot.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iducs.springboot.board.entity.UserEntity;

@Repository
public interface UserRepository	extends JpaRepository<UserEntity, Long> {	
	UserEntity findByUserId(String userId);
	List<UserEntity> findByNameOrderByIdAsc(String name);
	List<UserEntity> findByCompany(String company);
	
	Page<UserEntity> findAll(Pageable pageable); 
}
