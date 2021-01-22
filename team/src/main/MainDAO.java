package main;

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

public class MainDAO {

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

	public List<MainMovieVO> latestList() {

		List<MainMovieVO> list = new ArrayList<MainMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNO, m.movieName, m.movieImage, "
					+ "m.movieCategoryNo1, c1.movieCategoryName AS cn1, "
					+ "m.movieCategoryNo2, c2.movieCategoryName AS cn2, m.movieTime "
					+ "from team.movie m left outer join team.category c1 "
					+ "on m.movieCategoryNo1 = c1.movieCategoryNo "
					+ "left outer join team.category c2 "
					+ "on m.movieCategoryNo2 = c2.movieCategoryNo "
					+ "ORDER BY m.movieReleaseDate DESC";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MainMovieVO vo = new MainMovieVO(rs.getInt("movieNo"), 
										rs.getString("movieName"),
										rs.getString("movieImage"),
										rs.getInt("movieCategoryNo1"), 
										rs.getString("cn1"),
										rs.getInt("movieCategoryNo2"), 
										rs.getString("cn2"),
										rs.getString("movieTime"));

				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("latestList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}// latestList

	public List<MainMovieVO> hotList() {
		List<MainMovieVO> list = new ArrayList<MainMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNO, m.movieName, m.movieImage, "
					+ "m.movieCategoryNo1, c1.movieCategoryName AS cn1, "
					+ "m.movieCategoryNo2, c2.movieCategoryName AS cn2, m.movieTime "
					+ "from team.movie m left outer join team.category c1 "
					+ "on m.movieCategoryNo1 = c1.movieCategoryNo "
					+ "left outer join team.category c2 "
					+ "on m.movieCategoryNo2 = c2.movieCategoryNo "
					+ "ORDER BY m.movieAvgRating DESC";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MainMovieVO vo = new MainMovieVO(rs.getInt("movieNo"), 
										rs.getString("movieName"),
										rs.getString("movieImage"),
										rs.getInt("movieCategoryNo1"), 
										rs.getString("cn1"),
										rs.getInt("movieCategoryNo2"), 
										rs.getString("cn2"),
										rs.getString("movieTime"));

				list.add(vo);
			}
		} catch (Exception e) {
			System.out.println("hotList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//hotList

}