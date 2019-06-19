package iducs.springboot.board.service;

import java.util.List;

import iducs.springboot.board.domain.Answer;
import iducs.springboot.board.domain.Question;

public interface AnswerService {
	Answer getAnswerById(long id); // primary key인 id 값을 가진 질문 조회
	List<Answer> getAnswers(); // 모든 질문  조회
	
	void saveAnswer(Answer question); // 질문 생성
	void updateAnswer(Answer question); // 질문 수정
	void deleteAnswer(Answer question); // 질문 삭제
}
