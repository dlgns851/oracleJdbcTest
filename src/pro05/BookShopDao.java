package pro05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pro04.MemberVo;

public class BookShopDao {

	Connection con;
	
	public BookShopDao() {
		con= new DbConnect().getCon();
	}
	
	
	public void insert(BookVo vo) {

		try {

			String sql = "insert into bookshop(id,title,author_name,state_code)\r\n" + 
						 "values(seq_bookshop_id.nextval,?,?,'1')";
			
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1, vo.getTitle());
			pStmt.setString(2, vo.getAuthorName());
			
			
			


			int cnt = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void rent(int id) {
		
		PreparedStatement pStmt;
		try {
			String sql= "update bookshop set state_code=? where id=?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, "0");
			pStmt.setInt(2, id);

			
			int cnt = pStmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public List<BookVo> getListAll() {
		
		List<BookVo> list= new ArrayList<BookVo>() ;
		
	

		String query = " select * from bookshop";

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			BookVo vo ;
			while (rs.next()) {
				vo = new BookVo();
				vo.setId(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPubs(rs.getString(3));
				vo.setPubDate(rs.getString(4));
				vo.setAuthorName(rs.getString(5));
				vo.setStateCode(rs.getString(6));

				list.add(vo);

			}

			//con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}
	
	
}
