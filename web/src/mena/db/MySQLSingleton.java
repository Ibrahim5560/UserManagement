package mena.db;

import mena.model.Line;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ibrahim.mmh on 5/2/2018.
 */
public class MySQLSingleton {
    private static MySQLSingleton instance = null;
    private Connection conn = null;
    private MySQLSingleton(){
        try{
              DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static MySQLSingleton getInstance(){
        if (instance == null){
            synchronized (MySQLSingleton.class){
                if (instance == null)
                    instance = new MySQLSingleton();
            }
        }
        return instance;
    }
    public Connection getConnection(){
        if (conn == null){
            synchronized (DBSingleton.class){
                if (conn == null){
                    try
                    {
                        String dburl = "jdbc:mysql://localhost/arabics";
                        String dbuname = "root";
                        String dbpass = "";
                        conn=DriverManager.getConnection(dburl,dbuname,dbpass);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return conn;
    }
    //-------------------------------------------------------------------selectQuery
    public Line selectQuery(String query, Connection conn) throws Exception
    {
        Line line = null;
        Statement st=conn.createStatement();
        ResultSet result=st.executeQuery(query);
        while(result.next())
        {
            line = new Line(result.getInt(1),result.getTimestamp(2),result.getString(3), result.getString(4),result.getString(5));
        }
        result.close();
        st.close();
        return line;
    }
    //-------------------------------------------------------------------DeleteQuery
    public boolean isDeletedQuery(String query, Connection conn) throws Exception
    {
        Statement st=conn.createStatement();
        boolean flag = st.execute(query);
        st.close();
        return flag;
    }
    //-------------------------------------------------------------------CreateQuery + InsertQuery + UpdateQuery
    public int createQuery(String query,Connection conn) throws Exception
    {
        Statement st=conn.createStatement();
        int no = st.executeUpdate(query);
        st.close();
        return no;
    }
    //-------------------------------------------------------------------
    public List<Line> getAllNews(String query, Connection conn) throws Exception
    {
        List<Line> paperList = new ArrayList<Line>();
        Statement st=conn.createStatement();
        ResultSet result=st.executeQuery(query);
        while(result.next())
        {
            Line line = new Line(result.getInt(1),result.getTimestamp(2),result.getString(3), result.getString(4),result.getString(5));
            paperList.add(line);
        }
        result.close();
        st.close();
        return paperList;
    }
    //-------------------------------------------------------------------

}
