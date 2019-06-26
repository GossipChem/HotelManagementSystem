package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.stuffModel;

public class StuffDao {
public int delete(Connection con,String id)throws Exception{
	String sql="delete from stuff where Stuff_id=?";
	PreparedStatement pstmt= con.prepareStatement(sql);
	pstmt.setString(1, id);
	return pstmt.executeUpdate();
}
public int update(Connection con,stuffModel stuffmodel)throws Exception{

	String sql="UPDATE stuff SET  Stuff_name = ?, Gender = ?, Job =?, Status =? WHERE Stuff_id = ?";
PreparedStatement pstmt=con.prepareStatement(sql);

pstmt.setString(1, stuffmodel.getStuff_name());
pstmt.setString(2, stuffmodel.getGender());
pstmt.setString(3, stuffmodel.getJob());
pstmt.setString(4, stuffmodel.getStatus());
pstmt.setString(5, stuffmodel.getStuff_id());

return pstmt.executeUpdate();
}

public static ResultSet list(Connection con) throws Exception {
	StringBuffer sb=new StringBuffer("select*from stuff ");
	PreparedStatement pstmt=con.prepareStatement(sb.toString());
	
	return pstmt.executeQuery();
}

public int add(Connection con,stuffModel stuffmodel) throws Exception {
	String sql ="insert into stuff values(?,?,?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql);
	pstmt.setString(1, stuffmodel.getStuff_id());
	pstmt.setString(2, stuffmodel.getStuff_name());
	pstmt.setString(3, stuffmodel.getGender());
	pstmt.setString(4, stuffmodel.getJob());
	pstmt.setString(5, stuffmodel.getStatus());

	return pstmt.executeUpdate();
}
}