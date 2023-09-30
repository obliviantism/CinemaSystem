package cinemasystem.frame.MovieManagement;


import cinemasystem.dao.ManagerHelper;
import cinemasystem.model.MovieModel;
import cinemasystem.util.CreateSql;
import cinemasystem.util.WindowUtil;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//删除学生界面
public class DeleteMovieFrame extends JDialog{
    private JPanel jp1,jp2,jp3;	//面板。
    private JLabel query_Label;	//标签。
    private JButton query_Button;	//"查询"按钮。

    private JButton preciseQuery_Button;	//"精确查询"按钮。
    private JButton delete_Button;	//"删除"按钮。
    private JButton confirm_Button;// "确认"按钮
    private JButton cancel_Button;//"取消"按钮
    private JTextField query_Text;	//"查询"文本域。
    private JTable jt;	//表格。
    private JScrollPane jsp;	//滚动条。
    private JDialog jd;	//当前窗口。
    private MovieModel movieModel;	//学生数据模型
    private static Vector<String> query_Option;

    /**
     *
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public DeleteMovieFrame(JFrame owner, String title, boolean modal){
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
        delete_Button = new JButton("删除");
        //注册"删除"按钮事件监听
        delete_Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int rowNum = jt.getSelectedRow();
                if(rowNum==-1){
                    JOptionPane.showMessageDialog(jd, "请选择一行！", "", JOptionPane.WARNING_MESSAGE);
                    return ;
                }
                String studentID = jt.getValueAt(rowNum,0).toString();
                ManagerHelper helper = new ManagerHelper();
                if(helper.deleteMovie(studentID)){
                    JOptionPane.showMessageDialog(jd,"请您确定是否删除？");
                    confirm_Button = new JButton("确定删除");
                    confirm_Button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(jd, "删除成功！");
                            //更新
                            //构建新的数据模型类，并更新
                            String sql = CreateSql.getMovie_Sql(null, "全部");//查询全部内容
                            movieModel = new MovieModel(sql,jd);//构建新的数据模型类，并更新
                            jt.setModel(movieModel);
                            return ;
                        }
                    });


                    cancel_Button = new JButton("取消");
                    cancel_Button.setBounds(230, 330, 60, 25);
                    //注册"取消"按钮事件监听
                    cancel_Button.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                            jd.dispose();
                        }
                    });


                }else{
                    JOptionPane.showMessageDialog(jd, "删除失败！","",JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        jp3.add(delete_Button);
        c.add(jp3,BorderLayout.SOUTH);

        this.setSize(600,540);
        this.setResizable(false);
        WindowUtil.setFrameCenter(this);//设置窗体居中。
        this.setVisible(true);
    }
}