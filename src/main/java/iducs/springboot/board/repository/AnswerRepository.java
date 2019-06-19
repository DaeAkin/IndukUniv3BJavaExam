package iducs.springboot.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import iducs.springboot.board.entity.AnswerEntity;
import iducs.springboot.board.entity.UserEntity;

@Repository
public interface AnswerRepository 
	extends JpaRepository<AnswerEntity, Long> {		
//	Optional<AnswerEntity>  findById(Long id);
	
}
