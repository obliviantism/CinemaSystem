package cinemasystem.model;

import cinemasystem.dao.ManagerHelper;
import cinemasystem.bean.Movie;


import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
//rowData用来存放行数据
//columnNames存放列名
public class MovieModel extends AbstractTableModel {
    private ManagerHelper helper;
    private Vector<Movie> movies;
    private  Vector<String> columnNames = null;	//列名
    private Vector<Vector<String>> rowData = null;	//行数据

    public MovieModel(String sql,JDialog jd) {
        helper = new ManagerHelper();
        movies = helper.getMovie(sql);

        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("电影ID");
        columnNames.add("电影名称");
        columnNames.add("导演");
        columnNames.add("主演");
        columnNames.add("类型");
        columnNames.add("时长");
        columnNames.add("简介");
        columnNames.add("票价");
        for(Movie movie : movies){
            Vector<String> hang = new Vector<String>();
            hang.add(movie.getID());
            hang.add(movie.getName());
            hang.add(movie.getDirector());
            hang.add(movie.getCast());
            hang.add(movie.getType());
            hang.add(movie.getDuration());
            hang.add(movie.getIntro());
            hang.add(movie.getPrice());
            rowData.add(hang);
        }
        if(getRowCount()!=0){
            JOptionPane.showMessageDialog(jd, "一共有"+getRowCount()+"条记录！");
            return ;
        }else{
            JOptionPane.showMessageDialog(jd, "没有任何记录！");
            return ;
        }
    }

    //得到共有多少行
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return this.rowData.size();
    }
    //得到共有多少列
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.columnNames.size();
    }
    //得到某行某列的数据
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
    }

    //重写方法 getColumnName
    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return this.columnNames.get(column);
    }


}
