package adminOrder;

import java.util.List;
import java.util.Map;

import order.MovieVO;
import order.OrderVO;

public class AdminOrderService {
	AdminOrderDAO adminOrderDAO = new AdminOrderDAO();

	public void delSelectedItem(int orderNo){ //관리자페이지 주문내역 일부 주문만 삭제
		adminOrderDAO.delSelectedItem(orderNo);
	}	
	
	public List<AdminOrderVO> orderList() {	//관리자페이지 주문 전체 목록
		return adminOrderDAO.orderList();
	}

	
	
}