package cinemasystem.dao;


import cinemasystem.bean.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//与数据库通信的类
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;

public class JdbcHelper implements JdbcConfig{
    //定义连接数据库所需要的对象
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection ct = null;

    private  void init(){//初始化
        try {
            Class.forName(DRIVER);
            ct = DriverManager.getConnection(URL, USERNAME, PASSWORD);// 获得数据库连接
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //无参构造函数
    public JdbcHelper(){
        this.init();
    }



    /**
     * 获取经理对象
     * 根据传入的经理的用户名，获取对应的经理，并返回经理对象
     * @return 用户对象
     */
    public Manager getUser(Manager manager){
        Manager newManager = new Manager();
        try {
            ps = ct.prepareStatement("select * from tb_manager where Manager_ID=?");
            ps.setString(1, manager.getID());
            rs = ps.executeQuery();
            if(rs.next()){
                newManager.setID(rs.getString(1));	//设置用户名
                newManager.setPassword(rs.getString(2));	//设置密码
                newManager.setIsLogin(rs.getInt(3));	//设置是否登陆
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return newManager;
    }



    /**
     * 经理对象注册处理
     * @param manager	经理对象
     * @return	返回是否注册成功
     */
    public boolean register(Manager manager){
        boolean b = true;
        try {
            ps = ct.prepareStatement("insert into tb_manager(Manager_ID,Manager_Password) values(?,?)");
            ps.setString(1, manager.getID());
            ps.setString(2, manager.getPassword());
            if(ps.executeUpdate()!=1){	//执行sql语句
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }



    /**
     * 修改用户"是否"登陆状态
     * @param manager
     * @return
     */
    public boolean update_IsLogin(Manager manager){
        boolean b = true;
        try {
            ps = ct.prepareStatement("update tb_manager set IsLogin=? where Manager_ID=?");
            ps.setInt(1, manager.getIsLogin());
            ps.setString(2, manager.getID());
            if(ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }



    /**
     * 修改密码
     * @param manager  用户对象
     * @param new_Password 新密码
     * @return	返回是否修改成功
     */
    public boolean update_Password(Manager manager,String new_Password){
        boolean b = true;
        try {
            ps = ct.prepareStatement("update tb_manager set Manager_Password=? where Manager_ID=?");
            ps.setString(1, new_Password);
            ps.setString(2, manager.getID());
            if(ps.executeUpdate()!=1){	//执行sql语句
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }



    /**
     * 获得所有电影信息
     * @return 返回所有电影信息的HashMap集合
     */
    public HashMap<String, String> getAllMovies(){
        HashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("", "");//添加一个空的元素
        try {
            ps = ct.prepareStatement("select * from tb_movInfo order by MovInfo_ID");
            rs = ps.executeQuery();
            while(rs.next()){
                map.put(rs.getString(2),rs.getString(1));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }
    /**
     * 添加影片
     * @param movie	影片对象
     * @return	返回是否添加成功
     */
    public boolean addMovie(Movie movie){
        boolean b = true;
        try {
            ps = ct.prepareStatement("insert into tb_movInfo(MovInfo_ID,MovInfo_Name,MovInfo_Director,MovInfo_Cast,MovInfo_Type,MovInfo_Duration,MovInfo_Intro, MovInfo_Price) values(?,?,?,?,?,?,?,?)");
            ps.setString(1, movie.getID());
            ps.setString(2, movie.getName());
            ps.setString(3, movie.getDirector());
            ps.setString(4, movie.getCast());
            ps.setString(5, movie.getType());
            ps.setString(6, movie.getDuration());
            ps.setString(7, movie.getIntro());
            ps.setString(8, movie.getPrice());

            if(ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }


    /**
     * 修改电影信息
     * @param newMovie	新电影对象
     * @param oldMovieID	旧电影信息
     * @return	是否修改成功
     */
    public boolean updateMovie(Movie newMovie,String oldMovieID){
        boolean b = true;
        try {
            //update
            ps = ct.prepareStatement("update tb_movinfo set MovInfo_ID=?, MovInfo_Name=?, MovInfo_Director=? ,MovInfo_Cast=? ,MovInfo_Type=?  ,MovInfo_Duration=? ,MovInfo_Intro=? ,MovInfo_Price=?");
            ps.setString(1, newMovie.getID());
            ps.setString(2, newMovie.getName());
            ps.setString(3, newMovie.getDirector());
            ps.setString(4, newMovie.getCast());
            ps.setString(5, newMovie.getType());
            ps.setString(6, newMovie.getDuration());
            ps.setString(7, newMovie.getIntro());
            ps.setString(8, newMovie.getPrice());

            if(ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            b = false;
            e.printStackTrace();
        }
        return b;
    }

    /**
     * 根据电影ID从数据库移除该电影
     * @param MovieID	电影ID
     * @return	返回是否删除成功
     */
    public boolean deleteMovie(String MovieID){
        boolean b = true;
        try {
            ps = ct.prepareStatement("delete from tb_movInfo where MovInfo_ID=?");
            ps.setString(1, MovieID);
            if(ps.executeUpdate()!=1){
                b = false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            b = false;
            e.printStackTrace();
        }
        return b;
    }


    /**
     * 根据sql语句返回特定的电影集合
     * @param sql	sql语句
     * @return	返回Vector<Movie>对象
     */
    public Vector<Movie> getMovie(String sql){
        Vector<Movie> movies = new Vector<Movie>();
        try {
            ps = ct.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Movie movie = new Movie();
                movie.setID(rs.getString(1));
                movie.setName(rs.getString(2));
                movie.setDirector(rs.getString(3));
                movie.setCast(rs.getString(4));
                movie.setType(rs.getString(5));
                movie.setDuration(rs.getString(6));
                movie.setIntro(rs.getString(7));
                movie.setPrice(rs.getString(8));
                movies.add(movie);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return movies;
    }



    //关闭数据库资源
    public void close()	{
        try {
            if(rs!=null) rs.close();
            if(ps!=null) ps.close();
            if(ct!=null) ct.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}