package cinemasystem.util;

public class CreateSql {

    //根据查询内容、选项从电影表里返回特定的sql语句
    public static String getMovie_Sql(String str,String option){
        String sql = null;
        if("全部".equals(option)){
            sql = "select * from tb_movInfo" ;
        }else if("ID".equals(option)){
            sql = "select * from tb_movInfo where MovInfo_ID like '%"+str+"%'";
        }else if("名称".equals(option)){
            sql = "select * from tb_movInfo where MovInfo_Name like '%"+str+"%'";
        }else if("导演".equals(option)){
            sql = "select * from tb_movInfo where MovInfo_Director like '%"+str+"%'";
        }else if("主演".equals(option)){
            sql = "select * from tb_movInfo where MovInfo_Cast like '%"+str+"%'";
        }else if("类型".equals(option)){
            sql = "select * from tb_movInfo where MovInfo_Type like '%"+str+"%'";
        }else if("时长".equals(option)){
            sql = "select * from tb_movInfo where MovInfo_Duration  like '%"+str+"%'";
        }else if("剧情简介".equals(option)){
            sql = "select * from tb_movInfo where MovInfo_Intro like '%"+str+"%'";
        }else if("票价".equals(option)){
            sql = "select * from tb_movInfo where MovInfo_Price like '%"+str+"%'";
        }
        return sql;
    }

    //多条件查询的sql语句创建
    public static String getConditions_Sql(String id,String name,String director,String cast,String type,String duration,String intro, String price){
        StringBuilder sql = new StringBuilder("select * from tb_MovInfo where 1=1");
        if(!id.equals("")){
            sql.append(" and MovInfo_ID like '%" + id + "%'  ");
        }
        if(!name.equals("")){
            sql.append(" and MovInfo_Name like '%" + name + "%'  ");
        }
        if(!director.equals("")){
            sql.append(" and MovInfo_Director like '%" + director + "%'  ");
        }
        if(!cast.equals("")){
            sql.append(" and MovInfo_Cast like '%" + cast + "%'  ");
        }
        if(!type.equals("")){
            sql.append(" and MovInfo_Type like '%" + type + "%'  ");
        }
        if(!duration.equals("")){
            sql.append(" and MovInfo_Duration like '%" + duration + "%'  ");
        }
        if(!intro.equals("")){
            sql.append(" and MovInfo_Intro like '%" + intro + "%'  ");
        }
        if(!price.equals("")){
            sql.append(" and MovInfo_Price like '%" + price + "%'  ");
        }

        return sql.toString();
    }
}
