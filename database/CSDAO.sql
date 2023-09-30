create database CSDAO;

use CSDAO;
create table tb_MovInfo( #电影信息表
    MovInfo_ID varchar(30),                        #电影ID变长字符串作为主键
    MovInfo_Name nvarchar(50),             #电影名Unicode
    MovInfo_Director nvarchar(50) not null,         #导演
    MovInfo_Cast nvarchar(50) not null,             #主演
    MovInfo_Type nvarchar(50) not null,             #电影类型
    MovInfo_Duration nvarchar(50) not null,         #电影时长
    MovInfo_Intro nvarchar(200) not null,                    #电影简介
    MovInfo_Price nvarchar(20) not null            #票价
);


use CSDAO;
create table tb_Hall( #影厅排片表
    Hall_ID varchar(100) primary key, #影厅编号
    Hall_Name nvarchar(100) unique not null, #影厅名称
    MovInfo_ID varchar(30) not null,
    MovInfo_Name nvarchar(50) not null
);

use CSDAO;
create table tb_Seats( #座位信息表
    Seat_ID int primary key,
    Hall_ID varchar(30) not null,
    foreign key(Hall_ID) references tb_Hall(Hall_ID),
    isOccupied char(2) default 'O' not null check(isOccupied in ('O', 'X'))
);



use CSDAO;
create table tb_Receptionist( #前台信息表
    Recept_ID varchar(30),  #前台用户名
    Recept_Password varchar(30),  #前台密码
    primary key(Recept_ID,Recept_Password) #共为主键
);

use CSDAO;
create table tb_Admin( #管理员信息表
    Admin_ID varchar(30),  #管理员账号
    Admin_Password varchar(30),  #管理员密码
    primary key(Admin_ID,Admin_Password) #账号和密码共为主键
);

use CSDAO;
create table tb_Manager( #经理信息表
    Manager_ID varchar(30),  #经理账号
    Manager_Password varchar(30),  #经理密码
    IsLogin bit not null DEFAULT 0, 	#是否重复登陆
    primary key(Manager_ID,Manager_Password) #账号和密码共为主键
);


use CSDAO;
create table tb_User( #用户信息表
    User_ID varchar(30),  #用户账号
    User_Password varchar(30),  #用户密码
    primary key (User_ID, User_Password),
    User_PhoneNum char(20) unique not null, #用户手机号码
    CostMoney int not null,  #累积消费金额
    CostCnt int not null,  #累积消费次数
    User_RegistDate date, #注册时间
    User_Level nchar(10), #用户等级
    IsLogin bit not null DEFAULT 0 	#是否重复登陆
);



/*插入电影信息*/
insert into tb_MovInfo(MovInfo_ID, MovInfo_Name, MovInfo_Director, MovInfo_Cast, MovInfo_Type, MovInfo_Duration, MovInfo_Intro, MovInfo_Price)
values('202309001', '奥本海默', '克里斯托弗·诺兰','基里安·墨菲,艾米莉·布朗特,马特·达蒙,小罗伯特·唐尼','剧情,传记,历史','181分钟','一二三四五六七','80元');
insert into tb_MovInfo(MovInfo_ID, MovInfo_Name, MovInfo_Director, MovInfo_Cast, MovInfo_Type, MovInfo_Duration, MovInfo_Intro, MovInfo_Price)
values('202309002', '芭比', '格雷塔·葛韦格','玛格特·罗比,瑞恩·高斯林,亚美莉卡·费雷拉','喜剧,冒险,奇幻','114分钟','AEDASDAWD', '90元');
insert into tb_MovInfo(MovInfo_ID, MovInfo_Name, MovInfo_Director, MovInfo_Cast, MovInfo_Type, MovInfo_Duration, MovInfo_Intro, MovInfo_Price)
values('202309003', '盗马贼', '田壮壮','才项仁增,旦枝姬,蒂巴','剧情','88分钟','锟斤拷awd123', '100元');


/*插入影厅信息*/
insert into tb_Hall(Hall_ID, Hall_Name, MovInfo_ID, MovInfo_Name) values ('H001','楸厅', '202309001', '奥本海默');
insert into tb_Hall(Hall_ID, Hall_Name, MovInfo_ID, MovInfo_Name) values ('H002','桦厅', '202309001','奥本海默');
insert into tb_Hall(Hall_ID, Hall_Name, MovInfo_ID, MovInfo_Name) values ('H003','梓厅', '202309002','芭比');
insert into tb_Hall(Hall_ID, Hall_Name, MovInfo_ID, MovInfo_Name) values ('H004','楠厅', '202309003','盗马贼');

/*插入管理员信息*/
insert into tb_Admin(Admin_ID, Admin_Password) values('admin', 'ynuadmin');

/*插入经理信息*/
insert into tb_Manager(Manager_ID, Manager_Password) values('manager', 'ynuManager');

/*插入前台信息*/
insert into tb_Receptionist(Recept_ID, Recept_Password) values('recept', 'ynurecept');

/*插入用户信息*/
insert into tb_User(User_ID, User_Password, User_PhoneNum, CostMoney, CostCnt, User_RegistDate)
values('zhang3', 'zhang3001','12312341234',1000,5,'2020-02-12');
insert into tb_User(User_ID, User_Password, User_PhoneNum, CostMoney, CostCnt, User_RegistDate)
values('li4', 'li4002','13522223333',10,1,'2023-06-06');
insert into tb_User(User_ID, User_Password, User_PhoneNum, CostMoney, CostCnt, User_RegistDate)
values('wang5', 'wang5003','14285714285',100,19,'2000-08-01');
insert into tb_User(User_ID, User_Password, User_PhoneNum, CostMoney, CostCnt, User_RegistDate)
values('zhao6', 'zhao6004','11451411451',49,1,'1989-09-11');
insert into tb_User(User_ID, User_Password, User_PhoneNum, CostMoney, CostCnt, User_RegistDate)
values('hong7', 'hong7005','19966778899',10,100,'20210101');
insert into tb_User(User_ID, User_Password, User_PhoneNum, CostMoney, CostCnt, User_RegistDate)
values('wang8', 'wang8666','16666666666',1,1000,'19750101');


delimiter $$
create trigger update_User_CostNum_Level
    before insert on tb_User for each row
begin
    if NEW.CostCnt >= 100 | NEW.CostMoney >= 1000 then
        set NEW.User_Level = '金牌';
    elseif NEW.CostCnt >= 50 | NEW.CostMoney >= 500 then
        set NEW.User_Level = '银牌';
    else
        set NEW.User_Level = '铜牌';
    end if;
end;
$$
delimiter ;