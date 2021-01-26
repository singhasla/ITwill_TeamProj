package category;

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

public class CtgrDAO {

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

	public List<CtgrMovieVO> romanceList() {

		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "WHERE m.movieCategoryNo1 = 1 OR m.movieCategoryNo2 = 1 ORDER BY m.movieNo;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("romanceList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}// romanceList

	public List<CtgrMovieVO> adventureList() {
		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "WHERE m.movieCategoryNo1 = 2 OR m.movieCategoryNo2 = 2 ORDER BY m.movieNo;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("adventureList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//adventureList

	public List<CtgrMovieVO> comedyList() {
		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "WHERE m.movieCategoryNo1 = 3 OR m.movieCategoryNo2 = 3 ORDER BY m.movieNo;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("comedyList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//comedyList

	public List<CtgrMovieVO> dramaList() {
		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "WHERE m.movieCategoryNo1 = 4 OR m.movieCategoryNo2 = 4 ORDER BY m.movieNo;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("dramaList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//dramaList

	public List<CtgrMovieVO> thrillerList() {
		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "WHERE m.movieCategoryNo1 = 5 OR m.movieCategoryNo2 = 5 ORDER BY m.movieNo;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("thrillerList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//thrillerList

	public List<CtgrMovieVO> phantasyList() {
		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "WHERE m.movieCategoryNo1 = 6 OR m.movieCategoryNo2 = 6 ORDER BY m.movieNo;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("phantasyList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//phantasyList

	public List<CtgrMovieVO> animationList() {
		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "WHERE m.movieCategoryNo1 = 7 OR m.movieCategoryNo2 = 7 ORDER BY m.movieNo;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("animationList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//animationList

	public List<CtgrMovieVO> documentaryList() {
		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "WHERE m.movieCategoryNo1 = 8 OR m.movieCategoryNo2 = 8 ORDER BY m.movieNo;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("documentaryList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//documentaryList

	public List<CtgrMovieVO> crimeList() {
		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "WHERE m.movieCategoryNo1 = 9 OR m.movieCategoryNo2 = 9 ORDER BY m.movieNo;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("crimeList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//crimeList

	public List<CtgrMovieVO> latestAllList() {
		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "ORDER BY m.movieReleaseDate DESC;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("latestAllList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//latestAllList

	public List<CtgrMovieVO> hotAllList() {
		List<CtgrMovieVO> list = new ArrayList<CtgrMovieVO>();

		try {
			conn = getConnection();

			sql = "select m.movieNo, m.movieName, m.movieImage, "
				+ "m.movieCategoryNo1, c1.movieCategoryName AS CN1, "
				+ "m.movieCategoryNo2, c2.movieCategoryName AS CN2, m.movieTime "
				+ "from team.movie m "
				+ "left outer join team.category c1 on m.movieCategoryNo1 = c1.movieCategoryNo "
				+ "left outer join team.category c2 on m.movieCategoryNo2 = c2.movieCategoryNo "
				+ "ORDER BY m.movieAvgRating DESC;";

			pstmt = conn.prepareStatement(sql);

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
			System.out.println("hotAllList메소드 오류 :" + e.getMessage());
			e.printStackTrace();
		} finally {
			freeResource();
		}
		return list;
	}//hotAllList


}