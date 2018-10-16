create database pilot character set utf8;
use pilot;
set character_set_client=utf8;
set character_set_connection=utf8;

/*==============================================================*/
/* Table: admins                                  */
/*==============================================================*/
create table admin_user
(
   id                   int not null auto_increment,
   username             varchar(50) unique,
   password             varchar(100),
   salt	                varchar(100),
   register_date        datetime,
   admin_role_id		int, -- version 1.1
   managed_groups		varchar(1000), -- 管辖的组 SELECT_ALL 表示所有管辖组
   managed_accounts		varchar(1000), -- 管辖的结算账户id列表 SELECT_ALL 表示所有结算账户
   managed_companies	varchar(1000), -- 管辖的公司id列表 SELECT_ALL 表示所有结算账户
   company_id			int, 
   row_count			int, -- 每页默认显示条数
   cell_row_count		int, -- 手机版每页显示条数
   investor_refresh_interval  int, -- in ms, 1000表示1秒， 账户信息的刷新频率
   company_count		int, -- 当管辖多个公司时， 公司页面默认显示的个数
   cell_company_count	int, -- 手机版 公司默认个数
   retry_count			int, -- 重试次数
   retry_start_date		datetime, -- 重计开始计时时间
   retry_threshold		int, -- 重试次数上限
   status				tinyint, -- 状态   0、normal  1、锁定
   cell					char(11), -- 注册绑定的手机号
   nickname             varchar(30),
   admin_level			tinyint, --	值范围0到10
   admin_token          varchar(10),
   gang_id				int, -- 对应的gangid， 可以为空。
   primary key (id)
);

/*==============================================================*/
/* Table: admins                                  */
/*==============================================================*/
create table admin_user_group
(
   id                   int not null auto_increment,
   admin_user_id		int,
   admin_group_id		int,
   primary key (id)
);

alter table admin_user_group add constraint FK_admin_user_id_admin_user foreign key (admin_user_id)
      references admin_user (id) on delete cascade on update cascade; 
      