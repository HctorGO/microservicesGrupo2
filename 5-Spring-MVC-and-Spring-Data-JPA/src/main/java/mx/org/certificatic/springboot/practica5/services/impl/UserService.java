package mx.org.certificatic.springboot.practica5.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.org.certificatic.springboot.practica5.entities.User;
import mx.org.certificatic.springboot.practica5.repositories.UserRepository;
import mx.org.certificatic.springboot.practica5.services.api.IUserService;

// define service, imeplementa IUserService
@Service
public class UserService implements IUserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Page<User> findPaginated(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findAll(pageable);
	}

	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public User searchById(long id) {
		// TODO Auto-generated method stub
		return userRepository.
				findById(id).
				orElseThrow(
					() -> new IllegalArgumentException("Invalid user id: " + id)
				);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}
	
}