package cinemasystem.frame;


import cinemasystem.bean.Manager;
import cinemasystem.dao.ManagerHelper;
import cinemasystem.frame.LogInOutManagement.CinemaSystemLoginFrame;
import cinemasystem.frame.LogInOutManagement.UpdatePasswordFrame;
import cinemasystem.frame.MovieManagement.AddMovieFrame;
import cinemasystem.frame.MovieManagement.DeleteMovieFrame;
import cinemasystem.frame.MovieManagement.ListMovieFrame;
import cinemasystem.frame.MovieManagement.ModifyMovieFrame;
import cinemasystem.util.WindowUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;


//主界面
public class CinemaSystemMainFrame extends JFrame {
    private JMenuBar menuBar;	//应用菜单条。
    private JMenu Movies_Management;	//"影片管理"菜单。
    private JMenu Arrange_Management;	//"排片管理"菜单。
    private JMenu LogInOut_Management;	//"登录管理"菜单。

    /*影片管理*/
    private JMenuItem add_Movie;	//"添加影片信息"菜单项。
    private JMenuItem List_Movie;	//"列出上映影片信息"菜单项。
    private JMenuItem modify_Movie;	//"修改影片信息"菜单项。
    private JMenuItem delete_Movie;	//"删除影片"菜单项。

    /*排片管理*/
    private JMenuItem add_Release;	//"添加上映场次"菜单项。
    private JMenuItem modify_Release;	//"修改上映场次"菜单项。
    private JMenuItem delete_Release;  //"删除场次"菜单项
    private JMenuItem list_Release;	//"列出所有场次"菜单项。


    /*登录管理*/
    private JMenuItem change_Password;	//"修改密码"菜单项。
    private JMenuItem logout;	//"退出登录"菜单项。
    private JFrame jf;	//当前窗口。
    private Manager manager;//当前用户。


    public CinemaSystemMainFrame(Manager manager){
        super("影院管理系统,欢迎你！经理："+manager.getID());
        this.manager = manager;
        this.jf = this;
        menuBar = new JMenuBar();	//创建菜单条。
        this.setJMenuBar(menuBar);	//添加菜单条。

        Movies_Management = new JMenu("影片管理");	//创建"影片管理"菜单。
        menuBar.add(Movies_Management);	//添加"影片管理"菜单。

        add_Movie = new JMenuItem("添加影片");	//创建"添加影片"菜单项。
        //注册"添加影片"菜单项事件监听
        add_Movie.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                AddMovieFrame addMovieFrame = new AddMovieFrame(jf,"添加影片",true);
            }
        });
        Movies_Management.add(add_Movie);	//添加"添加影片"菜单项。

        List_Movie = new JMenuItem("列出上映影片");	//创建"列出影片"菜单项。
        //注册"查询学生"菜单项事件监听。
        List_Movie.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ListMovieFrame listMovieFrame = new ListMovieFrame(jf, "列出影片信息", true);

            }
        });
        Movies_Management.add(List_Movie);	//添加"列出影片信息"菜单项。

        modify_Movie = new JMenuItem("修改影片信息");	//创建"修改影片信息"菜单项。
        //注册"修改学生信息"菜单项事件监听
        modify_Movie.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyMovieFrame modifyMovieFrame = new ModifyMovieFrame(jf, "修改影片信息", true);

            }
        });
        Movies_Management.add(modify_Movie);	//添加"修改影片信息"菜单项。

        delete_Movie = new JMenuItem("删除电影");	//创建"删除电影"菜单项。
        //注册"删除电影"按钮事件监听
        delete_Movie.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteMovieFrame deleteMovieFrame = new DeleteMovieFrame(jf, "删除电影", true);

            }
        });
        Movies_Management.add(delete_Movie);	//添加"删除电影"菜单项.



        Arrange_Management = new JMenu("排片管理");	//创建"成绩管理"菜单。
        menuBar.add(Arrange_Management);	//添加"成绩管理"菜单。

        add_Release = new JMenuItem("增加场次");	//创建"添加场次"菜单项。
        //注册"添加场次"菜单项事件监听
        add_Release.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                //AddReleaseFrame frame = new AddReleaseFrame(jf, "添加场次", true);

            }
        });
        Arrange_Management.add(add_Release);	//添加"添加场次"菜单项。

        modify_Release = new JMenuItem("修改场次信息");	//创建"修改场次信息"菜单项。
        //注册"修改场次信息"菜单项事件监听
        modify_Release.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //UpdateReleaseFrame frame = new UpdateReleaseFrame(jf, "修改场次", true);
            }
        });
        Arrange_Management.add(modify_Release);	//添加"修改场次"菜单项。

        list_Release = new JMenuItem("列出所有场次");	//创建"列出所有场次"菜单项。
        //注册"成绩查询"菜单项事件监听
        list_Release.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //ListReleaseFrame frame = new  ListReleaseFrame(jf, "列出所有场次", true);
            }
        });
        Arrange_Management.add(list_Release);	//添加"列出所有场次"菜单项。

        delete_Release = new JMenuItem("删除场次");	//创建"删除场次"菜单项。
        //注册"删除场次"按钮事件监听
        delete_Release.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               // DeleteReleaseFrame deleteReleaseFrame = new DeleteReleaseFrame(jf, "删除场次", true);
            }
        });
        Arrange_Management.add(delete_Release);	//添加"删除场次"菜单项.


        LogInOut_Management = new JMenu("登录管理");	//创建"登录管理"菜单。
        menuBar.add(LogInOut_Management);	//添加"登录管理"菜单。

        change_Password = new JMenuItem("修改密码");	//创建"修改密码"菜单项。
        //注册"修改密码"菜单项事件监听
        change_Password.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePasswordFrame frame = new UpdatePasswordFrame(jf, "修改密码", true,manager);
            }
        });
        LogInOut_Management.add(change_Password);	//添加"修改密码"菜单项。

        logout = new JMenuItem("退出登录");	//创建"退出登录"菜单项。
        //注册"退出登录"菜单项时间监听
        logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();	//关闭当前窗口
                //修改登陆状态
                ManagerHelper helper = new ManagerHelper();
                manager.setIsLogin(0);//设置登陆状态为未登录。
                helper.Update_IsLogin(manager);
                CinemaSystemLoginFrame frame = new CinemaSystemLoginFrame();	//打开登陆界面

            }
        });
        LogInOut_Management.add(logout);	//添加"退出登录"菜单项。

        this.setSize(578, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        WindowUtil.setFrameCenter(this);//设置窗体居中。
        ImagePanel imagePanel = new ImagePanel();
        setContentPane(imagePanel);

        try {
            Image img = ImageIO.read(this.getClass().getResource("../2.png"));
            this.setIconImage(img);

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }



        this.setVisible(true);//设置窗体可见。
        this.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeiconified(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowDeactivated(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowClosing(WindowEvent arg0) {
                // TODO Auto-generated method stub
                //修改登陆状态
                ManagerHelper helper = new ManagerHelper();
                manager.setIsLogin(0);//设置登陆状态为未登录。
                helper.Update_IsLogin(manager);

            }

            @Override
            public void windowClosed(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowActivated(WindowEvent arg0) {
                // TODO Auto-generated method stub

            }
        });
    }
}
