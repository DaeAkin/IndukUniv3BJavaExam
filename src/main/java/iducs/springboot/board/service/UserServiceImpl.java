package iducs.springboot.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import iducs.springboot.board.domain.User;
import iducs.springboot.board.entity.UserEntity;
import iducs.springboot.board.exception.ResourceNotFoundException;
import iducs.springboot.board.repository.UserRepository;
import iducs.springboot.board.utils.HttpSessionUtils;

@Service//("userService")
public class UserServiceImpl implements UserService {

	@Autowired UserRepository repository;

	
	@Override
	public User getUserById(long id) {
		UserEntity userEntity = null;
		try {
			userEntity = repository.findById(id).orElseThrow(() 
					-> new ResourceNotFoundException("not found " + id ));
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userEntity.buildDomain();
	}

	@Override
	public User getUserByUserId(String userId) {
		UserEntity userEntity = repository.findByUserId(userId);
		if(userEntity == null)
			return null;
		return userEntity.buildDomain();
	}

	public List<User> getUsers(PageRequest pageRequest) {
		List<User> users = new ArrayList<User>();
		Page<UserEntity> entities = repository.findAll(pageRequest);
		for(UserEntity entity : entities) {
			User user = entity.buildDomain();
			users.add(user);
		}
		return users;
	}
	
	@Override
	public List<User> getUsers(Long pageNo) {
		System.out.println("pageNo : " + pageNo);
		PageRequest pageRequest = PageRequest.of((int) (pageNo - 1), 3, new Sort(Sort.Direction.DESC, "id"));
		Page<UserEntity> entities = repository.findAll(pageRequest);
		List<User> users = new ArrayList<User>();
		for(UserEntity entity : entities) {
			User user = entity.buildDomain();
			users.add(user);
		}	
		
		System.out.println("total Page : " + entities.getTotalPages());
		
		System.out.println("pageRequest.getPageNumber() :" + pageRequest.getPageNumber());
		
		return users;
	}	
	// 내가수정한 getusers()
	public List<User> getUsers(Long pageNo , Model model) {
		
		PageRequest pageRequest = PageRequest.of((int) (pageNo - 1), 3, new Sort(Sort.Direction.DESC, "id"));
				
		Page<UserEntity> entities = repository.findAll(pageRequest);
		List<User> users = new ArrayList<User>();
		for(UserEntity entity : entities) {
			User user = entity.buildDomain();
			users.add(user);
		}	
		
		model.addAttribute("pageRequest",pageRequest);
	
	return getUsers(pageNo);
	}
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		List<UserEntity> entities = repository.findAll();
		for(UserEntity entity : entities) {
			User user = entity.buildDomain();
			users.add(user);
		}
		return users;
	}
	@Override
	public List<User> getUsersByName(String name) {
		List<User> users = new ArrayList<>();
		List<UserEntity> entities = repository.findByNameOrderByIdAsc(name);
		for(UserEntity entity : entities) {
			User user = entity.buildDomain();
			users.add(user);
		}
		
		return users;
	}

	@Override
	public List<User> getUsersByCompany(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByPage(int index, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		UserEntity entity = new UserEntity();
		entity.buildEntity(user);
		repository.save(entity);
	}
	@Override
	public void updateUser(User user) {
		UserEntity entity = new UserEntity();
		entity.buildEntity(user);
		repository.save(entity);
	}

	@Override
	public void deleteUser(User user) {
		UserEntity entity = new UserEntity();
		entity.buildEntity(user);
		repository.delete(entity);
	}
}
