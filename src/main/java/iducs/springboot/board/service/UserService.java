package iducs.springboot.board.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import iducs.springboot.board.domain.User;

public interface UserService {
	User getUserById(long id); // primary key에 해당하는 id로  조회
	User getUserByUserId(String userId); // unique key에 해당하는 userId로 조회
	
	List<User> getUsers(Long pageNo); // 모든 사용자 조회
	List<User> getUsers(); // 모든 사용자 조회
	List<User> getUsersByName(String name); // name으로 조회
	List<User> getUsersByCompany(String company); // company으로 조회
	List<User> getUsersByPage(int index, int size); // 페이지로 조회
	public List<User> getUsers(Long pageNo , Model model);
	
	void saveUser(User user); // 생성
	void updateUser(User user); // 수정
	void deleteUser(User user); // 삭제
}
