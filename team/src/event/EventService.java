package event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventService {

	EventDAO eventDAO;
	
	public EventService() {
		eventDAO = new EventDAO();
	}
	
	public Map listEvents(Map pagingMap){
		Map eventMap = new HashMap();
		List<EventVO> eventList = eventDAO.selectAllEvent();
		eventDAO.selectAllEvent();

		return eventMap;
	}
	
	public int addEvent(EventVO event){
		return eventDAO.insertNewEvent(event);
	}
	
	
	
}
