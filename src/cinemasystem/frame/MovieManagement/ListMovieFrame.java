package cinemasystem.frame.MovieManagement;

import cinemasystem.bean.Movie;
import cinemasystem.model.MovieModel;
import cinemasystem.util.WindowUtil;
import cinemasystem.util.CreateSql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class  ListMovieFrame extends JDialog{
    private JPanel jp1;	//面板。
    private JTable jt;	//表格。
    private JScrollPane jsp;	//滚动条。
    private JDialog jd;	//当前窗口。
    private MovieModel movieModel;//电影数据模型类

    /**
     *
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public ListMovieFrame(JFrame owner, String title, boolean modal){
        super(owner, title, modal);
        this.jd = this;
        Container c = this.getContentPane();
        jp1 = new JPanel();
        jt = new JTable();
        String sql = CreateSql.getMovie_Sql(null, "全部");//查询全部内容
        movieModel = new MovieModel(sql,jd);//构建新的数据模型类，并更新
        jt.setModel(movieModel);

        jsp = new JScrollPane(jt);
        jp1.add(jsp);
        c.add(jp1,BorderLayout.CENTER);	//添加面板

        this.setSize(600,540);
        this.setResizable(false);
        WindowUtil.setFrameCenter(this);//设置窗体居中。
        this.setVisible(true);
    }
}

