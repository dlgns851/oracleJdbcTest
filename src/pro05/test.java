package pro05;

import java.sql.SQLException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookShopDao dao = new BookShopDao();
		BookVo vo = new BookVo();
		
		vo.setTitle( "바바바" );
		vo.setAuthorName( "보보보" );
		dao.insert( vo );
		
		try {
			dao.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
