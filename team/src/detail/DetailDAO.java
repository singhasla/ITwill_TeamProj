package detail;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import adminMovie.MovieVO;
import category.CtgrMovieVO;

public class DetailDAO {

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

	
	public DetailVO movieDetail(int movieNo) {
		DetailVO vo = new DetailVO();
		try {
			conn = getConnection();

			sql = "SELECT m.*, c1.movieCategoryName CN1, c2.movieCategoryName CN2 "
					+ "FROM team.movie m "
					+ "LEFT JOIN team.category c1 "
					+ "ON m.movieCategoryNo1 = c1.movieCategoryNo "
					+ "LEFT JOIN team.category c2 "
					+ "ON m.movieCategoryNo2 = c2.movieCategoryNo "
					+ "WHERE movieNo = ?;";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setMovieNo(rs.getInt("movieNo"));
				vo.setMovieName(rs.getString("movieName"));
				vo.setMovieContent(rs.getString("movieContent"));
				vo.setMovieImage(rs.getString("movieImage"));
				vo.setMoviePrice(rs.getInt("moviePrice"));
				vo.setMovieCategoryNo1(rs.getInt("movieCategoryNo1"));
				vo.setCN1(rs.getString("CN1"));
				vo.setMovieCategoryNo2(rs.getInt("movieCategoryNo2"));
				vo.setCN2(rs.getString("CN2"));
				vo.setMovieAvgRating(rs.getDouble("movieAvgRating"));
				vo.setMovieLink(rs.getString("movieLink"));
				vo.setMovieReleaseDate(rs.getDate("movieReleaseDate"));
				vo.setMovieWriteDate(rs.getTimestamp("movieWriteDate"));
				vo.setMovieUpdateDate(rs.getTimestamp("movieUpdateDate"));
				vo.setMovieDirector(rs.getString("movieDirector"));
				vo.setActorName(rs.getString("actorName"));
				vo.setMovieTime(rs.getString("movieTime"));
			}
		} catch (Exception e) {
			System.out.println("movieDetail메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return vo;
	}//movieDetail

	public List<CtgrMovieVO> searchMovie(String text) {	//입력한 검색어로 영화번호 가져오기
		
			sql = "SELECT movieNo FROM team.movie WHERE movieName like %?%";

			List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

			try {
				conn = getConnection();

				sql = "select m.movieNo, m.movieName, m.movieImage, "
					+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
					+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
					+ "from team.movie m "
					+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
					+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
					+ "WHERE m.movieName like '%"+text+"%'";

				pstmt = conn.prepareStatement(sql);
				//pstmt.setString(1, text);
				
				rs = pstmt.executeQuery();

				while (rs.next()) {
					CtgrMovieVO vo = new CtgrMovieVO(rs.getInt("movieNo"), 
											rs.getString("movieName"),
											rs.getString("movieImage"),
											rs.getInt("movieCategoryNo1"), 
											rs.getString("CN1"),
											rs.getInt("movieCategoryNo2"), 
											rs.getString("CN2"),
											rs.getString("movieTime"));

					list.add(vo);
				}
			} catch (Exception e) {
				System.out.println("searchMovie메소드 오류 :" + e.getMessage());
				e.printStackTrace();
			} finally {
				freeResource();
			}
			return list;
	}//searchMovie

	public List<CMTVO> cmtList(int movieNo) {
		List<CMTVO> list = new ArrayList();

		try {
			conn = getConnection();

			sql = "SELECT c.*, u.userNickName FROM comment c join user u "
					+ "ON c.userNo = u.userNo WHERE movieNo=?;";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, movieNo);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				CMTVO vo = new CMTVO(rs.getInt("commentNo"), 
										 rs.getInt("userNo"), 
										 rs.getInt("movieNo"), 
										 rs.getString("commentContent"), 
										 rs.getDate("commentWriteDate"),
										 rs.getInt("rating"),
										 rs.getString("userNickName"));
				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("cmtList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}

	public void addCmt(CMTVO vo) {
		
		try {
			conn = getConnection();

			int userNo = vo.getUserNo();
			int movieNo = vo.getMovieNo();
			String comment = vo.getCommentContent();
			int rating = vo.getRating();

			sql = "INSERT INTO comment (userNo,movieNo,commentContent,commentWriteDate,rating)"
					+ "VALUES (?,?,?,sysdate(),?);";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, userNo);
			pstmt.setInt(2, movieNo);
			pstmt.setString(3, comment);
			pstmt.setInt(4, rating);

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("addCmt메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
	}//addCmt

	public double avgRating(int movieNo) {

		double star = 0;

		try {
			conn = getConnection();

			sql = "SELECT AVG(rating) AS avg FROM comment WHERE movieNo=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				star = rs.getDouble("avg");
			}
			
		} catch (Exception e) {
			System.out.println("avgRating메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return star;
	}//avgRating
	
	
	
}