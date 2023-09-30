package cinemasystem.frame.MovieManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cinemasystem.frame.ModifyFrame;
import cinemasystem.model.*;
import cinemasystem.util.*;

public class ModifyMovieFrame extends JDialog{
    private JPanel jp1,jp2,jp3;	//面板。

    private JButton modify_Button;	//"详细信息"按钮。

    private JTable jt;	//表格。
    private JScrollPane jsp;	//滚动条。
    private JDialog jd;	//当前窗口。
    private MovieModel movieModel;	//电影数据模型


    /**
     *
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public ModifyMovieFrame(JFrame owner, String title, boolean modal){
        super(owner, title, modal);
        this.jd = this;
        Container c = this.getContentPane();

        jp2 = new JPanel();
        jt = new JTable();
        String sql = CreateSql.getMovie_Sql(null, "全部");//查询全部内容
        movieModel = new MovieModel(sql,jd);//构建新的数据模型类，并更新
        jt.setModel(movieModel);


        jsp = new JScrollPane(jt);
        jp2.add(jsp);
        c.add(jp2,BorderLayout.CENTER);	//添加面板

        jp3 = new JPanel();
        modify_Button = new JButton("修改信息");
        //注册"修改信息"按钮事件监听
        modify_Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int rowNum = jt.getSelectedRow();
                if(rowNum==-1){
                    JOptionPane.showMessageDialog(jd, "请选择一行！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
                ModifyFrame frame = new ModifyFrame(jd, "修改电影信息", true, rowNum, movieModel);
                //更新
                //构建新的数据模型类，并更新
                String sql = CreateSql.getMovie_Sql(null, "全部");//查询全部内容
                movieModel = new MovieModel(sql,jd);//构建新的数据模型类，并更新
                jt.setModel(movieModel);
            }
        });
        jp3.add(modify_Button);
        c.add(jp3,BorderLayout.SOUTH);

        this.setSize(600,540);
        this.setResizable(false);
        WindowUtil.setFrameCenter(this);//设置窗体居中。
        this.setVisible(true);
    }
}

