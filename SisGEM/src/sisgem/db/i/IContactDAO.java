package sisgem.db.i;

import sisgem.model.Contact;

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
