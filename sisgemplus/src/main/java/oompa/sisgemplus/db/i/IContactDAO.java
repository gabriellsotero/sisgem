package oompa.sisgemplus.db.i;

import oompa.sisgemplus.model.Contact;

public interface IContactDAO {
	
	/* CREATE */
	public void create(Contact c);
	
	/* RETRIEVE */
	public Contact findByCode(int code);
	
	/* UPDATE */
	public void update(Contact c);
	
	/* DELETE */
	public void delete(Contact c);
	
}
