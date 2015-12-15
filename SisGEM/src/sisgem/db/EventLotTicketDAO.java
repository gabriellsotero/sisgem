package sisgem.db;

import java.util.List;

import sisgem.db.i.IEventLotTicketDAO;
import sisgem.model.EventLotTicket;

public class EventLotTicketDAO implements IEventLotTicketDAO {

	@Override
	public void create(EventLotTicket e) {
		//TODO 032
	}

	@Override
	public List<EventLotTicket> listAllByEvent(int eventCode) {
		//TODO 033
		return null;
	}

	@Override
	public EventLotTicket findByCode(int code) {
		//TODO 034
		return null;
	}

	@Override
	public void update(EventLotTicket e) {
		//TODO 035		
	}

	@Override
	public void delete(EventLotTicket e) {
		//TODO 036		
	}


}
