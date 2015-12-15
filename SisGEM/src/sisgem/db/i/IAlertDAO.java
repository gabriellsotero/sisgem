	package sisgem.db.i;

import java.util.List;
import sisgem.model.Alert;

public interface IAlertDAO {
	
	/* CREATE */	
	public void create(Alert a);

	/* RETRIEVE */
	public Alert findByCode(int code);
	public List<Alert> listAllByUser(int userCode);
	
	/* UPDATE */
	public void update(Alert a);
	
	/* DELETE */
	public void delete(Alert a);

}
