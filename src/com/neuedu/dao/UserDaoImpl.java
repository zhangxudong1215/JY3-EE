package com.neuedu.dao;

import com.neuedu.pojo.User;
import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public void regsiter(String user, String psw) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO user(username,psw) VALUES(?,?)";
            System.out.println(conn);
            pstmt = conn.prepareStatement(sql);
            System.out.println(pstmt);
            System.out.println(conn);
            pstmt.setString(1, user);
            pstmt.setString(2, psw);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closePstmt(pstmt);
            DBUtils.closeConnection(conn);
        }

    }
    public User login(User user){
        Connection connection=DBUtils.getConnection();
        String sql="SELECT username,psw from user where username=? and psw=? ";
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=null;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return  user;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeRs(resultSet);
            DBUtils.closePstmt(preparedStatement);
            DBUtils.closeConnection(connection);
        }




        return  null;

    }


}
