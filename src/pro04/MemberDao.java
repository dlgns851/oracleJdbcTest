package pro04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class MemberDao {
	// MemberDao 를 작성합니다.
	Connection con;
	MemberVo vo;
	
	public MemberDao() {
		con= new DbConnect().getCon();
	}
	
	public void insertMember(MemberVo vo) {
		try {

			String sql = "INSERT INTO member Values(seq_member_id.nextval,?,?,?,?)";
			// PreparedStatementS pStmt =con.createStatement();

			PreparedStatement pStmt = con.prepareStatement(sql);
			
			pStmt.setString(1, vo.getName());
			pStmt.setString(2, vo.getEmail());
			pStmt.setString(3, vo.getPassword());
			pStmt.setString(4, vo.getGender());

			int cnt = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updatePassword(MemberVo vo) {
		PreparedStatement pStmt;
		try {
			String sql= "update member set password=? where email=?    ";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, vo.getPassword());
			pStmt.setString(2, vo.getEmail());

			
			int cnt = pStmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteMember(String email) {
		PreparedStatement pStmt;
		try {
			String sql= "delete from member where email=?";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1, email);
			
			int cnt = pStmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public List<MemberVo> getListAll() {
		
		List<MemberVo> list= new ArrayList<MemberVo>() ;
		
	

		String query = " select * from member";

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			MemberVo vo ;
			while (rs.next()) {
				vo = new MemberVo();
				vo.setId(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setEmail(rs.getString(3));
				vo.setPassword(rs.getString(4));
				vo.setGender(rs.getString(5));

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