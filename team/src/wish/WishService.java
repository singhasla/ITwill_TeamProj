package wish;

import java.util.List;
import java.util.Map;

public class WishService {
	WishDAO wishDAO = new WishDAO();
	
	public List<MovieVO> myWishList(int userNo){	//회원 찜 목록
		return wishDAO.myWishList(userNo);
	}

	public void addItemWish(WishVO vo) {	//찜에 추가
		wishDAO.addItemWish(vo);
	}

	public void allDelItem(int userNo) { //찜 리스트에 담긴 목록 전부 삭제
		wishDAO.allDelItem(userNo);
	}

	public void delSelectedItem1(int userNo, int movieNo){ //찜 리스트에 일부 상품만 삭제
		wishDAO.delSelectedItem1(userNo, movieNo);
	}

}