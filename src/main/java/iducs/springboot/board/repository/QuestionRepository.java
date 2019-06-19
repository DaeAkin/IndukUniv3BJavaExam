package iducs.springboot.board.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iducs.springboot.board.entity.QuestionEntity;
import iducs.springboot.board.entity.UserEntity;

@Repository
public interface QuestionRepository 
	extends JpaRepository<QuestionEntity, Long> {		
	List<QuestionEntity> findAll(Sort sort); 
	Page<QuestionEntity> findAll(Pageable pageable); 
	//Page<QuestionEntity> findAllByUserId(Pageable pageable, String userId); 
	//Page<QuestionEntity> findAllByCategory(Pageable pageable, String category); 
}
