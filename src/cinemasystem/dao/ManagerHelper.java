package cinemasystem.dao;

import cinemasystem.bean.*;

import java.util.HashMap;
import java.util.Vector;


//数据库业务处理类
public class ManagerHelper {
    private JdbcHelper helper;	//与数据库通信的对象



    /**
     * 登陆业务处理
     * @param manager	经理对象
     * @return 返回是否成功登陆
     */
    public boolean Login(Manager manager){
        boolean b = true;
        helper = new JdbcHelper();	//创建与数据库通信的对象
        Manager newManager = helper.getUser(manager);	//获得经理数据
        if(!manager.getPassword().equals(newManager.getPassword())){	//比对密码与数据库中的对应密码是否一致
            b = false;
        }
        helper.close();//关闭资源
        return b;
    }



    /**
     * 注册业务处理
     * @param manager 对象
     * @return	返回是否注册成功
     */
    public boolean Register(Manager manager){
        helper = new JdbcHelper();//创建与数据库通信的对象
        boolean b = helper.register(manager);
        helper.close();//关闭资源
        return b;
    }



    /**
     * 检查是否重复登陆的方法
     * @param manager 经理对象
     * @return 是否重复登陆,登陆过的返回true,否则返回false
     */
    public boolean Check_IsLogin(Manager manager){
        boolean b = true;
        int isLogin;
        helper = new JdbcHelper();//创建与数据库通信的对象
        Manager newManager = helper.getUser(manager);
        if(newManager.getIsLogin()==0){
            b = false;
        }
        helper.close();//关闭资源
        return b;
    }



    /**
     * 返回成功修改登陆情况
     * @param manager 用户对象
     */
    public boolean  Update_IsLogin(Manager manager){
        helper = new JdbcHelper();//创建与数据库通信的对象
        boolean b = helper.update_IsLogin(manager);
        helper.close();//关闭资源
        return b;
    }



    /**
     * 修改密码业务处理
     * @param manager	用户对象
     * @param new_Password	新密码
     * @return 返回是否修改成功
     */
    public boolean update_Password(Manager manager,String new_Password){
        boolean b;
        helper = new JdbcHelper();//创建与数据库通信的对象
        b = helper.update_Password(manager, new_Password);
        helper.close();//关闭资源
        return b;
    }



    /**
     * 获列出所有正在上映的电影
     * @return	返回电影HashMap集合
     */
    public HashMap<String, String> getAllMovies(){
        helper = new JdbcHelper();
        HashMap<String, String> map;
        map = helper.getAllMovies();
        helper.close();//关闭资源
        return map;
    }


    /**
     * 添加电影业务
     * @param movie 电影对象
     * @return 返回是否添加成功
     */
    public boolean addMovie(Movie movie){
        boolean b = true;
        helper = new JdbcHelper();
        b = helper.addMovie(movie);
        helper.close();//关闭资源
        return b;
    }


    /**
     * 修改电影信息业务
     * @param newMovie	新电影对象
     * @param oldMovieID	旧电影信息
     * @return	返回是否添加成功
     */
    public boolean updateMovie(Movie newMovie,String oldMovieID){
        boolean b = true;
        helper = new JdbcHelper();
        b = helper.updateMovie(newMovie, oldMovieID);
        helper.close();//关闭资源
        return b;
    }


    /**
     * 删除电影业务
     * @param movieID	电影ID
     * @return	返回是否删除成功
     */
    public boolean deleteMovie(String movieID){
        boolean b = true;
        helper = new JdbcHelper();
        b = helper.deleteMovie(movieID);
        helper.close();
        return b;
    }

    /**
     * 根据sql语句返回特定的电影对象集合
     * @param sql	sql语句
     * @return	返回电影集合
     */
    public Vector<Movie> getMovie(String sql){
        Vector<Movie> movies;
        helper = new JdbcHelper();
        movies = helper.getMovie(sql);
        helper.close();
        return movies;
    }

}
