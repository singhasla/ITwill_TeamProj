package adminMovie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MovieDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	DataSource dataFactory;
	String sql;

	private Connection getConnection() throws Exception {
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:/comp/env/jdbc/team");

		conn = ds.getConnection();

		return conn;
	}// getconnection

	public void freeResource() {
		try {
			if (conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			System.out.println("freeResource 오류 :" + e.getMessage());
		}
	}// freeResource();

	
public List<MovieVO> movieList() {
		
		List<MovieVO> list = new ArrayList<MovieVO>();

		try {
			conn = getConnection();

			sql = "SELECT movieNo, movieName, movieContent, "
					+ "movieCategoryNo1,movieCategoryNo2, moviePrice "
					+ "FROM team.movie "
					+ "order by movieReleaseDate desc";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MovieVO vo = new MovieVO(rs.getInt("movieNo"),
										 rs.getString("movieName"),
										 rs.getString("movieContent"),
										 rs.getInt("movieCategoryNo1"),
										 rs.getInt("movieCategoryNo2"),
										 rs.getInt("moviePrice"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("movieList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//movieList
	
	
	public void insertMoive(MovieVO vo) {
		try {
			conn = getConnection();

			String movieName = vo.getMovieName();
			String movieContent = vo.getMovieContent();
			String movieImage = vo.getMovieImage();
			int moviePrice = vo.getMoviePrice();
			int movieCategoryNo1 = vo.getMovieCategoryNo1();
			int movieCategoryNo2 = vo.getMovieCategoryNo2();
			String movieDirector = vo.getMovieDirector();
			String movieLink = vo.getMovieLink();
			String actorName = vo.getActorName();
			Date movieReleaseDate = vo.getMovieReleaseDate();
			String movieTime = vo.getMovieTime();

			// 쿼리로 중복체크 후 데이터 삽입(같은 userNo에 movieNo가 중복될 수 없도록...)

			sql = "INSERT INTO `team`.`movie` (`movieName`, `movieContent`, `movieImage`, "
					+ "`moviePrice`, `movieCategoryNo1`, `movieCategoryNo2`, `movieDirector`, `movieLink`, "
					+ "`movieReleaseDate`, `actorName`, `movieTime`) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// sql = "INSERT INTO order(userNo, movieNo, orderWriteDate)"
			// + " VALUES(?,?,sysdate())";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, movieName);
			pstmt.setString(2, movieContent);
			pstmt.setString(3, movieImage);
			pstmt.setInt(4, moviePrice);
			pstmt.setInt(5, movieCategoryNo1);
			pstmt.setInt(6, movieCategoryNo2);
			pstmt.setString(7, movieDirector);
			pstmt.setString(8, movieLink);
			pstmt.setDate(9, movieReleaseDate);
			pstmt.setString(10, actorName);
			pstmt.setString(11, movieTime);

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertMoive메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
	}// insertMoive

	public List<CategoryVO> categoryList() {
		List<CategoryVO> list = new ArrayList<CategoryVO>();

		try {
			conn = getConnection();

			sql = "SELECT * from team.category "
					+ "order by movieCategoryNo";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				
//				CategoryVO vo = new CategoryVO(rs.getInt("movieCategoryNo"),
//												rs.getString("movieCategoryName"));
				
				int movieCategoryNo = rs.getInt(1);
				String movieCategoryName = rs.getString(2);
				
				CategoryVO category = new CategoryVO();
				category.setMovieCategoryNo(movieCategoryNo);
				category.setMovieCategoryName(movieCategoryName);
				
				list.add(category);
				
				
				
//				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("categoryList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}
	

	
	

	
	
	
	
}