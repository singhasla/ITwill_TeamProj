package event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventService {

	EventDAO eventDAO;
	
	public EventService() {
		eventDAO = new EventDAO();
	}
	
	//이벤트 글
	public Map listEvents(Map pagingMap){
		Map eventMap = new HashMap();
		List<EventVO> eventList = eventDAO.selectAllEvents(pagingMap);
		int allEvents = eventDAO.allEvents(pagingMap);
		eventMap.put("eventList", eventList);
		eventMap.put("allEvents", allEvents);
		return eventMap;
	}
	//이벤트글 추가
	public int addEvent(EventVO event) {
		return eventDAO.insertNewEvent(event);
	}
	
	//이벤트글 상세정보 조회
	public EventVO viewEvent(int eventNo) {
		EventVO event = null;
		event = eventDAO.selectEvent(eventNo);
		return event;
	}
	
	//이벤트글 수정
	public void modifyEvent(EventVO event) {
		eventDAO.updateEvent(event);
	}
	
	//이벤트글 삭제
	public List<Integer> removeEvent(int eventNo) {
		List<Integer> removeEventNo = eventDAO.selectRemoveEvent(eventNo);
		eventDAO.deleteEvent(eventNo);
		return removeEventNo;
	}
	
}
