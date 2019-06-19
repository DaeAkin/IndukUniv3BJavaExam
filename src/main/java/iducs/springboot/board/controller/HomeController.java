package iducs.springboot.board.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import iducs.springboot.board.domain.Question;
import iducs.springboot.board.domain.User;
import iducs.springboot.board.service.QuestionService;
import iducs.springboot.board.service.UserService;

@Controller
public class HomeController {
	
	@Autowired 
	private UserService userService; // 의존성 주입(Dependency Injection) : 
	
	@Autowired 
	private QuestionService questionService;
	
	@GetMapping("/initdb") 
	public String initialize() {
		for(int i = 1;i <= 10; i++)
			userService.saveUser(new User("u" + i, "p" + i, "name" + i, "contact" + i));	
		for(int i = 1;i <= 5; i++) {
			for(int j = 1; j <= 2; j++)
			questionService.saveQuestion(new Question("제목 " + j, userService.getUserByUserId("u"+i) , "내용 " + j));
		}
		return "index";
	}
	@GetMapping("/")
	public String home() {		
		return "index";
	}
	@GetMapping("/questions/form") // 등록폼은 form URL을 가지도록 규칙화하겠음
	public String questionForm(HttpSession session, Model model) {
		User writer = (User) session.getAttribute("user");
		model.addAttribute("writer", writer);
		return "/questions/register";
	}	
	@GetMapping("/users/login-form")
	public String loginForm(Model model) {
		return "/users/login";
	}
	@PostMapping("/users/login")
	public String loginUser(@Valid User user, HttpSession session) {
		System.out.println("login process : ");
		User sessionUser = userService.getUserByUserId(user.getUserId()); 
		
		if(sessionUser == null) {
			System.out.println("id error : ");
			return "redirect:/users/login-form";
		}
		if(!sessionUser.getUserPw().equals(user.getUserPw())) {
			System.out.println("pw error : ");
			return "redirect:/users/login-form";
		}
		session.setAttribute("user", sessionUser);
		return "redirect:/";
	}	
	
	@GetMapping("/users/form") // 등록폼은 form URL을 가지도록 함, 다른 폼은 이름을 명명하기로 수정함
	public String registerForm() {
		return "/users/register";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	/*
	@GetMapping("/userinfo")
	public String datail(HttpSession session) {
		System.out.println("-------");
		User user = (User) session.getAttribute("user");
		return "/users/" + user.getId();
	}	
	*/
}
