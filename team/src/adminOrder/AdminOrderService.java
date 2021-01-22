package adminOrder;

import java.sql.Date;
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

	public List<AdminOrderVO> periodList(Date start, Date end) { //기간내 결제된 주문 목록
		return adminOrderDAO.periodList(start, end);
	}

	public int periodSales(Date start, Date end) { //관리자페이지 기간내 매출액
		return adminOrderDAO.periodSales(start, end);
	}

	public int totalSales() {
		return adminOrderDAO.totalSales();
	}

	
	
}