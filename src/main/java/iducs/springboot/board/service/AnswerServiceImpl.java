package iducs.springboot.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iducs.springboot.board.domain.Answer;
import iducs.springboot.board.entity.AnswerEntity;
import iducs.springboot.board.repository.AnswerRepository;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
	@Autowired 
	private AnswerRepository repository;
	
	@Override
	public Answer getAnswerById(long id) {
		
		AnswerEntity answerEntity = null ;
		answerEntity = repository.getOne(id);
		return answerEntity.buildDomain();
	}

	@Override
	public List<Answer> getAnswers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAnswer(Answer answer) {
		AnswerEntity entity = new AnswerEntity();
		entity.buildEntity(answer);
		repository.save(entity);
	}

	@Override
	public void updateAnswer(Answer answer) {
		AnswerEntity entity = new AnswerEntity();
		entity.buildEntity(answer);
		repository.save(entity);

	}

	@Override
	public void deleteAnswer(Answer answer) {
		System.out.println("댓글 삭제하기 ");
		AnswerEntity entity = new AnswerEntity();
		entity.buildEntity(answer);
		repository.delete(entity);

	}

}
