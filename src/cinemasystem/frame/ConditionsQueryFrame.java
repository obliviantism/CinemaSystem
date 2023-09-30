package cinemasystem.frame;

import cinemasystem.dao.*;
import cinemasystem.util.*;
import cinemasystem.model.MovieModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ConditionsQueryFrame extends JDialog {
    private JLabel MovInfo_ID_Label;    //"电影ID"标签。
    private JLabel MovInfo_Name_Label;	//"名称"标签。
    private JLabel MovInfo_Director_Label;	//"导演"标签。
    private JLabel MovInfo_Cast_Label;	//"主演"标签。
    private JLabel MovInfo_Type_Label;	//"类型"标签。
    private JLabel MovInfo_Duration_Label;	//"时长"标签。
    private JLabel MovInfo_Intro_Label;	//"剧情简介"标签。
    private JLabel MovInfo_Price_Label;	//"剧情简介"标签。
    private JTextField MovInfo_ID_Text;	//"ID"文本域。
    private JTextField MovInfo_Name_Text;	//"名称"文本域。
    private JTextField MovInfo_Director_Text;	//导演选项
    private JTextField MovInfo_Cast_Text;	//主演选项
    private JTextField MovInfo_Type_Text;	//主演选项
    private JTextField MovInfo_Duration_Text;	//时长
    private JTextField MovInfo_Intro_Text;	//剧情简介
    private JTextField MovInfo_Price_Text;	//票价

    private JButton conditions_button;	//多条件查询按钮
    private ManagerHelper helper;
    private JDialog jd;	//当前窗口
    /**
     *
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public ConditionsQueryFrame(JDialog owner, String title, boolean modal,JTable jt){
        super(owner, title, modal);
        this.jd = this;
        this.setLayout(null);
        setBackground(Color.WHITE);//设置背景颜色
        MovInfo_ID_Label = new JLabel("电影ID:");
        MovInfo_ID_Label.setBounds(29, 19, 30, 20);
        this.add(MovInfo_ID_Label);

        MovInfo_ID_Text= new JTextField();
        MovInfo_ID_Text.setBounds(65, 19, 100, 20);
        this.add(MovInfo_ID_Text);

        MovInfo_Name_Label = new JLabel("姓名:");
        MovInfo_Name_Label.setBounds(200, 19, 30, 20);
        this.add(MovInfo_Name_Label);

        MovInfo_Name_Text = new JTextField();
        MovInfo_Name_Text.setBounds(240, 19, 100, 20);
        this.add(MovInfo_Name_Text);

        MovInfo_Director_Label = new JLabel("导演:");
        MovInfo_Director_Label.setBounds(29, 50, 30, 20);
        this.add(MovInfo_Director_Label);

        MovInfo_Director_Text = new JTextField();
        MovInfo_Director_Text.setBounds(65, 50, 100, 20);
        this.add(MovInfo_Director_Text);

        MovInfo_Cast_Label = new JLabel("主演:");
        MovInfo_Cast_Label.setBounds(200, 50, 30, 20);
        this.add(MovInfo_Cast_Label);

        MovInfo_Cast_Text = new JTextField();
        MovInfo_Cast_Text.setBounds(240, 50, 100, 20);
        this.add(MovInfo_Cast_Text);

        MovInfo_Type_Label = new JLabel("类型:");
        MovInfo_Type_Label.setBounds(29, 83, 30, 20);
        this.add(MovInfo_Type_Label);

        MovInfo_Cast_Text = new JTextField();
        MovInfo_Cast_Text.setBounds(65, 83, 100, 20);
        this.add(MovInfo_Cast_Text);

        MovInfo_Duration_Label = new JLabel("时长:");
        MovInfo_Duration_Label.setBounds(200, 83, 30, 20);
        this.add(MovInfo_Duration_Label);

        MovInfo_Duration_Text = new JTextField();
        MovInfo_Duration_Text.setBounds(240, 83, 100, 20);
        this.add(MovInfo_Duration_Text);

        MovInfo_Intro_Label = new JLabel("剧情简介:");
        MovInfo_Intro_Label.setBounds(29,116, 30, 20);
        this.add(MovInfo_Intro_Label);

        MovInfo_Intro_Text = new JTextField();
        MovInfo_Intro_Text.setBounds(65, 116, 100, 20);
        this.add(MovInfo_Intro_Text);

        MovInfo_Price_Label = new JLabel("票价");
        MovInfo_Price_Label.setBounds(29,136, 30, 20);
        this.add(MovInfo_Price_Label);

        MovInfo_Price_Text = new JTextField();
        MovInfo_Price_Text.setBounds(65, 136, 100, 20);
        this.add(MovInfo_Price_Text);

        conditions_button = new JButton("多条件查询");
        conditions_button.setBounds(230, 130, 100, 30);
        //注册"多条件查询"按钮事件监听
        conditions_button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = MovInfo_ID_Text.getText().trim();
                String name = MovInfo_Name_Text.getText().trim();
                String Director = MovInfo_Director_Text.getText().trim();
                String Cast = MovInfo_Cast_Text.getText().trim();
                String Type = MovInfo_Type_Text.getText().trim();
                String Duration = MovInfo_Duration_Text.getText().trim();
                String Intro = MovInfo_Intro_Text.getText().trim();
                String Price = MovInfo_Price_Text.getText().trim();
                if(id.equals("")&&name.equals("")&&Director.equals("")&&Cast.equals("")&&Type.equals("")&&Duration.equals("")&&Intro.equals("")){
                    JOptionPane.showMessageDialog(jd, "条件不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }else{
                    String sql = CreateSql.getConditions_Sql(id, name, Director, Cast, Type, Duration, Intro, Price);
                    MovieModel mm = new MovieModel(sql,jd);
                    jt.setModel(mm);
                    jd.dispose();
                }

            }
        });
        this.add(conditions_button);


        this.setSize(411, 222);
        this.setResizable(false);
        WindowUtil.setFrameCenter(this);
        this.setVisible(true);
    }
}
