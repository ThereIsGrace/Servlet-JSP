package sec02.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	/*
	private static final String driver="oracle.jdbc.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user="hr";
	private static final String pwd="12345";
	*/
	private Connection con;
	private PreparedStatement psmt;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<>();
		try {
			//connDB();
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println("prepareStatement:" + query);
			psmt = con.prepareStatement(query);
			ResultSet rs= psmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			psmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/*
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			conn = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	public void addMember(MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = "insert into t_member";
			query += "(id, pwd, name, email)";
			query += "values(?,?,?,?)";
			System.out.println("prepareStatement: " + query);
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			psmt.setString(3, name);
			psmt.setString(4, email);
			psmt.executeUpdate();
			psmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			
			String query = "delete from t_member" + " where id = ?";
			System.out.println("prepareStatement:" + query);
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.executeUpdate();
			psmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
