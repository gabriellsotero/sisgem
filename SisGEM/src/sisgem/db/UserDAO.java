package sisgem.db;

import java.util.List;

import sisgem.db.i.IUserDAO;
import sisgem.model.User;

public class UserDAO implements IUserDAO {

	@Override
	public void create(User u) {
		//TODO 072		
	}

	@Override
	public List<User> listAll() {
		//TODO 073
		return null;
	}

	@Override
	public User findByCode(int code) {
		//TODO 074
		return null;
	}

	@Override
	public User findByLogin(String login) {
		//TODO 075
		return null;
	}

	@Override
	public void update(User u) {
		//TODO 076		
	}

	@Override
	public void delete(User u) {
		//TODO 077		
	}
	

}
