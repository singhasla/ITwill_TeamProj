package order;

import java.util.List;
import java.util.Map;

public class OrderService {
	OrderDAO orderDAO = new OrderDAO();
	MovieVO movieVO = new MovieVO();
	
	public List<MovieVO> myCartList(int userNo){	//회원 카트 목록
		return orderDAO.myCartList(userNo);
	}
	
	public List<MovieVO> myOrderList(int userNo) {	//회원 결제 목록
		return orderDAO.myOrderList(userNo);
	}

	public void addItemCart(OrderVO vo) {	//카트에 추가
		orderDAO.addItemCart(vo);
	}

	public void allDelItem(int userNo) { //카트에 담긴 목록 전부 삭제
		orderDAO.allDelItem(userNo);
	}

	public void delSelectedItem1(int userNo, int movieNo){ //카트에 일부 상품만 삭제
		orderDAO.delSelectedItem1(userNo, movieNo);
	}
	
	public void delSelectedItem2(int userNo, int movieNo){ //구매내역에 일부 상품만 삭제
		orderDAO.delSelectedItem2(userNo, movieNo);
	}
	
	public int cartTotalPrice(int userNo) {	//카트에 담긴 상품 전체 금액
		return orderDAO.cartTotalPrice(userNo);
	}

	public int cartTotalCount(int userNo) {	//카트 목록 갯수
		return orderDAO.cartTotalCount(userNo);
	}

	public int myUserNo(String userID) {
		return orderDAO.myUserNo(userID);
	}

	public String firstMovieName(int userNo) {
		return orderDAO.firstMovieName(userNo);
	}

	public void updateStatus(int userNo) {
		orderDAO.updateStatus(userNo);
		
	}

	
	
}