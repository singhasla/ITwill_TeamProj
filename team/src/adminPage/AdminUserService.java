package adminPage;

import java.util.ArrayList;
import java.util.List;

import user.UserVO;

public class AdminUserService {
	
	AdminUserDAO adminUserDAO;

	
	public AdminUserService() {
		adminUserDAO = new AdminUserDAO();
	}

	public  List userlist(String searchKeyword) {
		
		List<UserVO> userList = new ArrayList<UserVO>();
		
		userList= adminUserDAO.getUserList(searchKeyword);
		System.out.println(userList);
		
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

}
