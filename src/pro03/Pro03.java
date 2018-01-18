package pro03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Pro03 {
	Connection con;

	public Pro03() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "hr";
		String pwd = "hr";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버로드성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("데이터베이스 연결 준비...");
			con = DriverManager.getConnection(url, userid, pwd);
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void sqlRun() {
	
				    
		String query = "select em.employee_id, em.email,jo.job_title,de.department_name,lo.city\r\n" + 
				" from departments de, employees em, locations lo, jobs jo\r\n" + 
				" where de.department_id= em.department_id \r\n" + 
				" and   de.LOCATION_ID=lo.location_id\r\n" + 
				" and   em.job_id = jo.job_id\r\n" + 
				" and lo.city= 'Seattle'\r\n" + 
				" and em.job_id = 'PU_CLERK'" +
				" order by em.employee_id desc";
				    

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("EmployeeId LastName Email jobTitle DepartmentName City ");
			while (rs.next()) {
				
				System.out.print(rs.getInt("employee_id")+" ");
				System.out.print(rs.getString("email")+" " );
				System.out.print(rs.getString("job_title")+" ");
				System.out.print(rs.getString("department_name")+" ");
				System.out.print(rs.getString("city")+" ");
				System.out.println("");
			}

			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pro03 pro03 = new Pro03();
		pro03.sqlRun();
	}

}
