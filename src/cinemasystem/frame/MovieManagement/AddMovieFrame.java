package cinemasystem.frame.MovieManagement;

import cinemasystem.bean.Movie;
import cinemasystem.dao.ManagerHelper;
import cinemasystem.util.WindowUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//添加学生界面
public class AddMovieFrame extends JDialog{
    private JButton add_Button;	//"添加"按钮。
    private JButton cancel_Button;	//"取消"按钮。
    private JComboBox Type_Box;	//"类型"选项。
    private JLabel MovInfo_ID_Label;    //"电影ID"标签。
    private JLabel MovInfo_Name_Label;	//"电影名称"标签。
    private JLabel MovInfo_Director_Label;	//"导演"标签。
    private JLabel MovInfo_Cast_Label;	//"主演"标签。
    private JLabel MovInfo_Type_Label;	//"类型"标签。
    private JLabel MovInfo_Duration_Label;	//"时长"标签。
    private JLabel MovInfo_Intro_Label;	//"剧情简介"标签。
    private JLabel MovInfo_Price_Label;	//"票价"标签。
    private JTextField MovInfo_ID_Text;	//"电影ID"文本域。
    private JTextField MovInfo_Name_Text;	//"电影名称"文本域。
    private JTextField MovInfo_Director_Text;	//"导演"文本域。
    private JTextField MovInfo_Cast_Text;	//"主演"文本域。
    private JTextField MovInfo_Duration_Text;	//"时长"文本域。
    private JTextField MovInfo_Intro_Text;	//"剧情简介"文本域。
    private JTextField MovInfo_Price_Text;	//"价格"文本域。
    private JDialog jd;	//当前窗口。
    private HashMap<String, String> movies;	//所有电影集合
    private ManagerHelper helper;	//数据库业务处理对象

    /**
     *
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public AddMovieFrame(JFrame owner, String title, boolean modal){
        super(owner, title, modal);
        helper = new ManagerHelper();	//创建数据库业务处理对象

        movies = this.helper.getAllMovies();	//获得所有院系

        this.jd = this;
        this.setSize(350,429);	//设置窗体大小。
        this.setLayout(null);	//设置空布局。

        MovInfo_ID_Label = new JLabel("电影ID:");
        MovInfo_ID_Label.setBounds(78, 48, 100, 20);
        this.add(MovInfo_ID_Label);

        MovInfo_ID_Text = new JTextField();
        MovInfo_ID_Text.setBounds(116, 48, 150, 20);
        this.add(MovInfo_ID_Text);


        MovInfo_Name_Label = new JLabel("名称:");
        MovInfo_Name_Label.setBounds(78, 78, 30, 20);
        this.add(MovInfo_Name_Label);

        MovInfo_Name_Text = new JTextField();
        MovInfo_Name_Text.setBounds(116, 78, 150, 20);
        this.add(MovInfo_Name_Text);


        MovInfo_Type_Label = new JLabel("类型:");
        MovInfo_Type_Label.setBounds(78, 108, 30, 20);
        this.add(MovInfo_Type_Label);

        Type_Box = new JComboBox(new String[]{"","动作","喜剧","冒险","传记","爱情","恐怖","卡通"});
        Type_Box.setBounds(116, 108, 60, 20);
        this.add(Type_Box);


        MovInfo_Director_Label = new JLabel("导演:");
        MovInfo_Director_Label.setBounds(78, 138, 30, 20);
        this.add(MovInfo_Director_Label);

        MovInfo_Director_Text = new JTextField();
        MovInfo_Director_Text.setBounds(116, 138, 150, 20);
        this.add(MovInfo_Director_Text);


        MovInfo_Cast_Label = new JLabel("主演:");
        MovInfo_Cast_Label.setBounds(78, 168, 30, 20);
        this.add(MovInfo_Cast_Label);

        MovInfo_Cast_Text = new JTextField();
        MovInfo_Cast_Text.setBounds(116, 168, 150, 20);
        this.add(MovInfo_Cast_Text);


        MovInfo_Duration_Label = new JLabel("时长:");
        MovInfo_Duration_Label.setBounds(78, 198, 30, 20);
        this.add(MovInfo_Duration_Label);

        MovInfo_Duration_Text = new JTextField();
        MovInfo_Duration_Text.setBounds(116, 198, 150, 20);
        this.add(MovInfo_Duration_Text);


        MovInfo_Intro_Label = new JLabel("剧情简介:");
        MovInfo_Intro_Label.setBounds(68, 228, 120, 20);
        this.add(MovInfo_Intro_Label);

        MovInfo_Intro_Text = new JTextField();
        MovInfo_Intro_Text.setBounds(116, 228, 150, 20);
        this.add(MovInfo_Intro_Text);



        MovInfo_Price_Label = new JLabel("票价:");
        MovInfo_Price_Label.setBounds(78, 258, 120, 20);
        this.add(MovInfo_Price_Label);

        MovInfo_Price_Text = new JTextField();
        MovInfo_Price_Text.setBounds(116, 258, 150, 20);
        this.add(MovInfo_Price_Text);


        add_Button = new JButton("添加");
        add_Button.setBounds(70, 330, 60, 25);

        //注册"确认"按钮事件监听
        add_Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Movie movie = new Movie();
                String id = MovInfo_ID_Text.getText().trim();
                String name = MovInfo_Name_Text.getText().trim();
                String director = MovInfo_Director_Text.getText().trim();
                String cast = MovInfo_Cast_Text.getText().trim();
                String duration = MovInfo_Duration_Text.getText().trim();
                String intro = MovInfo_Intro_Text.getText().trim();
                String type = Type_Box.getSelectedItem().toString();
                String price = MovInfo_Intro_Text.getText().trim();

                //数据校验部分
                if(id.equals("")){
                    JOptionPane.showMessageDialog(jd, "电影ID不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
                if(id.length()<=2){
                    JOptionPane.showMessageDialog(jd, "ID必须大于两位数！", "", JOptionPane.WARNING_MESSAGE);
                    MovInfo_ID_Text.setText("");
                    return ;
                }
                if(name.equals("")){
                    JOptionPane.showMessageDialog(jd, "电影名称不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
                if(type.equals("")){
                    JOptionPane.showMessageDialog(jd, "类型不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
                if(director.equals("")){
                    JOptionPane.showMessageDialog(jd, "导演不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
                if(cast.equals("")){
                    JOptionPane.showMessageDialog(jd, "主演不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
                if(duration.equals("")){
                    JOptionPane.showMessageDialog(jd, "时长不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
                if(intro.equals("")){
                    JOptionPane.showMessageDialog(jd, "剧情简介不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
                if(price.equals("")){
                    JOptionPane.showMessageDialog(jd, "票价不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }


                MovInfo_ID_Label.setText("电影ID:");
                MovInfo_ID_Text.setText(id);	//设置ID文本域
                movie.setID(id);
                movie.setName(name);
                movie.setType(type);
                movie.setDirector(director);
                movie.setDuration(duration);
                movie.setCast(cast);
                movie.setIntro(intro);
                movie.setPrice(price);

                if(helper.addMovie(movie)){
                    JOptionPane.showMessageDialog(jd, "添加成功！");
                    jd.dispose();	//关闭当前窗口
                    return ;
                }else{
                    JOptionPane.showMessageDialog(jd, "添加失败！", "", JOptionPane.WARNING_MESSAGE);
                    jd.dispose();	//关闭当前窗口
                    return ;
                }


            }
        });
        this.add(add_Button);

        cancel_Button = new JButton("取消");
        cancel_Button.setBounds(230, 330, 60, 25);
        //注册"取消"按钮事件监听
        cancel_Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                jd.dispose();

            }
        });
        this.add(cancel_Button);

        WindowUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }
}