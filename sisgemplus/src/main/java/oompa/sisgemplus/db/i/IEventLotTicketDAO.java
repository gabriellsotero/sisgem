package oompa.sisgemplus.db.i;

import java.util.List;

import oompa.sisgemplus.model.EventLotTicket;

public interface IEventLotTicketDAO {
	
	/* CREATE */
	public void create(EventLotTicket e);
	
	/* RETRIEVE */
	public List<EventLotTicket> listAllByEvent(int eventCode);
	public EventLotTicket findByCode(int code);

	/* UPDATE */
	public void update(EventLotTicket e);
	
	/* DELETE */
	public void delete(EventLotTicket e);
}
