package oompa.sisgemplus.db.i;

import java.util.List;

import oompa.sisgemplus.model.User;

public interface IUserDAO {
	
	/* CREATE */
	public void create(User u);
	
	/* RETRIEVE */
	public List <User> listAll();
	public User findByCode(int code);
	public String findLoginByCode(int userCode);
	public User findByLogin(String login);
	
	/* UPDATE */
	public void update(User u);
	
	/* DELETE */
	public void delete(User u);


}
