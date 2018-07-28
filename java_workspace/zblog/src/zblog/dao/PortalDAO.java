package zblog.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import zblog.bean.Portal;
import zblog.util.DBUtil;

public class PortalDAO {
	public void add(Portal bean) {
		String sql="insert into portal values(?,?)";
		try (Connection c=DBUtil.getConnection();PreparedStatement ps=c.prepareStatement(sql);){
			ps.setString(1, bean.getTage());
			ps.setString(2, bean.getContent());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
    public void update(Portal bean) {
        String sql = "update portal set content= ? where tage = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, bean.getContent());
            ps.setString(2, bean.getTage());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
  
    }
    public void delete(String tage) {
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
            String sql = "delete from portal where tage ="+"'" + tage+"'";
            
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PortalDAO obj=new PortalDAO();
		Portal tittle=new Portal();
		tittle.setTage("tittle");
		tittle.setContent("最爱家乡菜le的博客");
//		obj.add(tittle);
//		obj.update(tittle);
//		obj.delete("tittle");
		System.out.println("sql is over");
	}

}
