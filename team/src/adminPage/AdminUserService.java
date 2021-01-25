package adminPage;

import java.util.ArrayList;
import java.util.List;

import customerService.QnaVO;
import order.MovieVO;
import user.UserVO;

public class AdminUserService {
	
	AdminUserDAO adminUserDAO;

	
	public AdminUserService() {
		adminUserDAO = new AdminUserDAO();
	}

	public  List userlist(String searchKeyword) {
		
		List<UserVO> userList = new ArrayList<UserVO>();
		
		userList= adminUserDAO.getUserList(searchKeyword);
		/*System.out.println(userList);*/
		
		return userList;
	}
	
	public int total(String searchKeyword){
		
		int totalCount = adminUserDAO.getUserListCount(searchKeyword);
		
		return totalCount;
	}

	public UserVO getUser(String userID) {
		
		return adminUserDAO.getUser(userID);
	}

	public int userUpate(UserVO userVO) {
		int result = adminUserDAO.userUpdate(userVO);
		return result;
	}

	public int deleteUser(String userID) {
		
		return adminUserDAO.deleteUser(userID);
	}

	public MovieVO getuserM(int userNo) {
		
		return adminUserDAO.getuserM(userNo);
	}

	public List getUsermList(int userNo) {
		
		List<MovieVO> getUserM = new ArrayList<MovieVO>();
		getUserM = adminUserDAO.getUserM(userNo);
		/*System.out.println(getUserM);*/
		return getUserM;
	}

	public List getUserqList(int userNo) {
		List<QnaVO> getUserQ = new ArrayList<QnaVO>();
		getUserQ = adminUserDAO.getUserQ(userNo);
		return getUserQ;
	}



}
