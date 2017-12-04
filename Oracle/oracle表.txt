表

create table 【schema】 table_name （column_name data_type 【default expression】【constraint】）括号是必须的 tablespace tablespace_name
schema 表所属的用户名或用户模式名称
column_name列名，具有唯一性
data_type列的数据类型（number整型、varchar2(40)1-40长度字符串、number(4,2)6位有效数字精确到小数点后2位最大为9999.99，date日期，）
default expression列的默认值
constraint 列的约束，必须满足的规则（not null 非空）
两个列之间用英文逗号隔开
constraint 主键名 primary key(主键列)括号必须 添加主键约束

primary key加在列后面表示唯一性约束
check约束，对输入的每一个数据进行检查【constraint 约束名 check（表达式）】
