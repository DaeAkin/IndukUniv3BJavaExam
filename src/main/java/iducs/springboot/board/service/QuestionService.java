package iducs.springboot.board.service;

import java.util.List;

import iducs.springboot.board.domain.Question;

public interface QuestionService {
	Question getQuestionById(long id); // primary key인 id 값을 가진 질문 조회
	List<Question> getQuestions(); // 모든 질문  조회
	
	List<Question> getQuestionsByUser(String name); // name으로 조회
	List<Question> getQuestionsByPage(int index, int size); // 페이지로 조회
	
	void saveQuestion(Question question); // 질문 생성
	void updateQuestion(Question question); // 질문 수정
	void deleteQuestion(Question question); // 질문 삭제
}
