package cinemasystem.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Vector;

import cinemasystem.bean.Movie;
import cinemasystem.dao.ManagerHelper;
import cinemasystem.model.MovieModel;
import cinemasystem.util.WindowUtil;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class ModifyFrame extends JDialog{
    private JButton modify_Button;	//"修改"按钮。
    private JButton cancel_Button;	//"取消"按钮。
    private JComboBox type_Box;	//"电影类型"选项。
    private JLabel MovInfo_ID_Label; //"电影ID"标签。
    private JLabel MovInfo_Name_Label;	//"姓名"标签。
    private JLabel MovInfo_Director_Label;	//"导演"标签。
    private JLabel MovInfo_Cast_Label;	//"主演"标签。
    private JLabel MovInfo_Type_Label;	//"类型标签"。
    private JLabel MovInfo_Duration_Label;	//"时长"标签。
    private JLabel MovInfo_Intro_Label;	//"剧情简介"标签。
    private JLabel MovInfo_Price_Label;	//"票价"标签。


    private JTextField MovInfo_ID_Text;	//"学号"文本域。
    private JTextField MovInfo_Name_Text;	//"姓名"文本域。
    private JTextField MovInfo_Director_Text;	//"导演"文本域。
    private JTextField MovInfo_Cast_Text;	//"主演"文本域。
    private JTextField MovInfo_Type_Text;	//"种类"文本域。
    private JTextField MovInfo_Duration_Text;	//"时长"文本域。
    private JTextField MovInfo_Intro_Text;	//"剧情简介"文本域。
    private JTextField MovInfo_Price_Text;	//"票价"文本域。

    private JDialog jd;	//当前窗口。
    private HashMap<String, String> movies;	//所有电影集合
    private ManagerHelper helper;	//数据库业务处理对象
    private MovieModel mm;	//电影数据模型对象
    /**
     *
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public ModifyFrame(JDialog owner, String title, boolean modal,int rowNum,MovieModel mm){
        super(owner, title, modal);
        helper = new ManagerHelper();	//创建数据库业务处理对象

        movies = this.helper.getAllMovies();	//获得所有院系
        this.jd = this;
        this.mm = mm;
        this.setSize(350,429);	//设置窗体大小。
        this.setLayout(null);	//设置空布局。
        //获取信息
        String MovInfo_id = mm.getValueAt(rowNum, 0).toString();
        String MovInfo_name = mm.getValueAt(rowNum, 1).toString();
        String MovInfo_director = mm.getValueAt(rowNum, 2).toString();
        String MovInfo_cast = mm.getValueAt(rowNum, 3).toString();
        String MovInfo_type = mm.getValueAt(rowNum, 4).toString();
        String MovInfo_duration = mm.getValueAt(rowNum,5).toString();
        String MovInfo_intro =  mm.getValueAt(rowNum, 6).toString();
        String MovInfo_price =  mm.getValueAt(rowNum, 7).toString();

        MovInfo_ID_Label = new JLabel("电影ID:");
        MovInfo_ID_Label.setBounds(58, 48, 50, 20);
        this.add(MovInfo_ID_Label);

        MovInfo_ID_Text = new JTextField();
        MovInfo_ID_Text.setBounds(116, 48, 150, 20);
        MovInfo_ID_Text.setText(MovInfo_id);	//设置电影ID并显示
        this.add(MovInfo_ID_Text);

        MovInfo_Name_Label = new JLabel("名称:");
        MovInfo_Name_Label.setBounds(78, 78, 30, 20);
        this.add(MovInfo_Name_Label);


        MovInfo_Name_Text = new JTextField();
        MovInfo_Name_Text.setBounds(116, 78, 150, 20);
        MovInfo_Name_Text.setText(MovInfo_name);	//设置电影名称并显示
        this.add(MovInfo_Name_Text);

        MovInfo_Director_Label = new JLabel("导演:");
        MovInfo_Director_Label.setBounds(78, 108, 30, 20);
        this.add(MovInfo_Director_Label);

        MovInfo_Director_Text = new JTextField();
        MovInfo_Director_Text.setBounds(116, 108, 150, 20);
        MovInfo_Director_Text.setText(MovInfo_director);	//设置导演并显示
        this.add(MovInfo_Director_Text);

        MovInfo_Cast_Label = new JLabel("主演:");
        MovInfo_Cast_Label.setBounds(78, 138, 30, 20);
        this.add(MovInfo_Cast_Label);

        MovInfo_Cast_Text = new JTextField();
        MovInfo_Cast_Text.setBounds(116, 138, 150, 20);
        MovInfo_Cast_Text.setText(MovInfo_cast);	//设置主演并显示
        this.add(MovInfo_Cast_Text);

        MovInfo_Type_Label = new JLabel("类型：");
        MovInfo_Type_Label.setBounds(78, 168, 40, 20);
        this.add(MovInfo_Type_Label);

        type_Box = new JComboBox(new String[]{"","动作","喜剧","科幻","恐怖","剧情"});
        type_Box.setSelectedItem(mm.getValueAt(rowNum, 2));
        type_Box.setBounds(116, 168, 60, 20);
        this.add(type_Box);//设置电影类型


        MovInfo_Duration_Label = new JLabel("时长:");
        MovInfo_Duration_Label.setBounds(78, 198, 30, 20);
        this.add(MovInfo_Duration_Label);

        MovInfo_Duration_Text = new JTextField();
        MovInfo_Duration_Text.setBounds(116, 198, 150, 20);
        MovInfo_Duration_Text.setText(MovInfo_duration);	//设置时长并显示
        this.add(MovInfo_Duration_Text);

        MovInfo_Intro_Label = new JLabel("剧情简介:");
        MovInfo_Intro_Label.setBounds(58, 228, 60, 20);
        this.add(MovInfo_Intro_Label);

        MovInfo_Intro_Text = new JTextField();
        MovInfo_Intro_Text.setBounds(116, 228, 150, 20);
        MovInfo_Intro_Text.setText(MovInfo_intro);	//设置剧情简介并显示
        this.add(MovInfo_Intro_Text);

        MovInfo_Price_Label = new JLabel("票价:");
        MovInfo_Price_Label.setBounds(78, 258, 30, 20);
        this.add(MovInfo_Price_Label);

        MovInfo_Price_Text = new JTextField();
        MovInfo_Price_Text.setBounds(116, 258, 150, 20);
        MovInfo_Price_Text.setText(MovInfo_price);	//设置票价并显示
        this.add(MovInfo_Price_Text);



        modify_Button = new JButton("修改");
        modify_Button.setBounds(70, 330, 60, 25);


        //注册"修改"按钮事件监听
        modify_Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Movie newMovie = new Movie();
                String id = MovInfo_ID_Text.getText().trim();
                String name = MovInfo_Name_Text.getText().trim();
                String director = MovInfo_Director_Text.getText().trim();
                String cast = MovInfo_Cast_Text.getText().trim();
                String duration = MovInfo_Duration_Text.getText().trim();
                String intro = MovInfo_Intro_Text.getText().trim();
                String price = MovInfo_Price_Text.getText().trim();
                String type = type_Box.getSelectedItem().toString();

                //数据校验部分
                if(id.equals("")){
                    JOptionPane.showMessageDialog(jd, "ID不能为空！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
                if(id.length()<=2){
                    JOptionPane.showMessageDialog(jd, "ID不能少于两位数！", "", JOptionPane.WARNING_MESSAGE);
                    MovInfo_ID_Text.setText("");
                    return ;
                }
                if(name.equals("")){
                    JOptionPane.showMessageDialog(jd, "电影名称不能为空！", "", JOptionPane.WARNING_MESSAGE);
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

                newMovie.setPrice(price);
                newMovie.setID(id);
                newMovie.setName(name);
                newMovie.setDirector(director);
                newMovie.setType(type);
                newMovie.setCast(cast);
                newMovie.setDuration(duration);
                newMovie.setIntro(intro);

                if(helper.updateMovie(newMovie, MovInfo_id)){
                    JOptionPane.showMessageDialog(jd, "修改成功！");
                    jd.dispose();	//关闭当前窗口
                    return ;
                }else{
                    JOptionPane.showMessageDialog(jd, "修改失败！", "", JOptionPane.WARNING_MESSAGE);
                    jd.dispose();	//关闭当前窗口
                    return ;
                }
            }

        });
        this.add(modify_Button);

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
