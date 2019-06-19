package iducs.springboot.board.controller;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;
import iducs.springboot.board.domain.Answer;
import iducs.springboot.board.domain.Question;
import iducs.springboot.board.domain.User;
import iducs.springboot.board.exception.ResourceNotFoundException;
import iducs.springboot.board.repository.UserRepository;
import iducs.springboot.board.service.AnswerService;
import iducs.springboot.board.service.QuestionService;
import iducs.springboot.board.service.UserService;

@Controller
@RequestMapping("/questions/{questionId}/answers")
public class AnswerController {
	@Autowired AnswerService answerService; // 의존성 주입(Dependency Injection) 
	@Autowired QuestionService questionService;
		
	@PostMapping("")
	// public String createUser(Answer answer, Model model, HttpSession session) {
	public String createAnswer(@PathVariable Long questionId, String contents,HttpSession session) {
		// 로그인한 유저 
		User sessionUser = (User) session.getAttribute("user");
		//
		System.out.println("답글내용?  :" + contents);
		Question question = questionService.getQuestionById(questionId);
		Answer newAnswer = new Answer(sessionUser, question, contents);
		answerService.saveAnswer(newAnswer);
		return String.format("redirect:/questions/%d", questionId);
	}
	
	// 댓글 삭제하기
	@DeleteMapping("/{answer_id}")
	public String deleteAnswer(@PathVariable(value = "answer_id") Long answerId,HttpSession session) {
		//로그인 한 유저와 댓글단 유저가 일치하는지 확인은 안했음! ㅎㅎ
//		User sessionUser = (User) session.getAttribute("user");
		
		System.out.println("삭제하기!");
		System.out.println("삭제할 댓글 번호 :" + answerId);
		Answer removedAnswer = answerService.getAnswerById(answerId);
		answerService.deleteAnswer(removedAnswer);
		System.out.println(removedAnswer.toString());
		
		return String.format("redirect:/questions/%d", removedAnswer.getQuestion().getId());
		
	}
	
	// 댓글 가져오기
	@GetMapping("/{answer_id}")
	public String getAnswer(@PathVariable(value = "answer_id") Long answerId,
			@PathVariable(value = "questionId") Long questionId,Model model) {
		
		Answer answer = answerService.getAnswerById(answerId);
		Question question = new Question();
		question.setId(questionId);
		model.addAttribute("answer",answer);
		model.addAttribute("question",question);
		return "/questions/editanswer";
		
	}
	
	@PutMapping("/{answer_id}")
	public String updateAnswer(@PathVariable(value = "answer_id") Long answerId,
			@PathVariable(value = "questionId") Long questionId,String contents,HttpSession session) {
		
		Answer answer = answerService.getAnswerById(answerId);
		answer.setContents(contents);
		answerService.saveAnswer(answer);
		return String.format("redirect:/questions/%d", answer.getQuestion().getId());
	}
	

}
