package com.nueudu.dao;


import com.nueudu.pojo.User;
import com.nueudu.pool.DruidSource;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private QueryRunner qr=null;
   private DruidSource dds=DruidSource.getSource();

    public UserDaoImpl(){
        //构造器初始化QueryRunner对象
        qr=new QueryRunner();
    }

    @Override
    public List<User> getAllUser() {
        String sql="select * from user";
        List<User> users=null;
        Connection connection=dds.getConnection();
        try {
            users = qr.query(connection, sql, new BeanListHandler<>(User.class));
            System.out.println(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


        return users;
    }
    public void updateUser(User user){
        Connection connection=dds.getConnection();
        String sql="UPDATE user SET username=?,psw=? WHERE id=?";

        try {
            qr.update(connection,sql,user.getUsername(),user.getPsw(),user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delUser(User user){
        Connection connection=dds.getConnection();
        String sql="delete from user where id=?";

        try {
            qr.update(connection,sql,user.getUsername(),user.getId(),user.getPsw());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
