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
	
	
	
}