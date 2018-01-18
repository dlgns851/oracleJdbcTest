package pro05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookShopDao {

	Connection con;
	
	public BookShopDao() {
		con= new DbConnect().getCon();
	}
	
	
	public void insert(BookVo vo) {

		try {

			String sql = "insert into bookshop(id,title,author_name)\r\n" + 
						 "values(seq_bookshop_id.nextval,sd,aa);";
			 

			PreparedStatement pStmt = con.prepareStatement(sql);
			/*String str="1";
			pStmt.setString(1, vo.getTitle());
			pStmt.setString(2, vo.getAuthorName());
			*/
			
			//pStmt.setString(3, str);
			


			int cnt = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
