操作

select ... from ...【 where ...】【order by 列名'可多个'【asc默认升序|desc降序】】 ;where可用表达式比较操作符（<,>,=,!=,>=,<=,and, or, not, between..and...在两值之间，in(列表)匹配列表值，like‘样式’匹配字符样式（%表示0个或多个字符，_表示单个字符），isnull测试null）可使用子查询
group by 列名 进行单列分组

连接查询select table1.column，table2.column from table1，table2, where table1.column=table2.column；


desc查看属性

insert 添加行insert into table_name 【column1、2】 values【1、2】；

update修改行 update table_name set column1=value1 【，column2=value2】 where 表达式；

delete删除行 delete from table_name 【where 表达式】；

merge合并（插入或修改）

create创建
alter修改数据库的结构
drop删除数据库的结构
rename更改表名
truncate删除表的所有内容

grant授予其他用户对数据库结构的访问权限
revoke收回用户访问数据库结构的权限

关键字

dba_data_files数据字典：file_name；file_id；tablespace_name；bytes大小；blocks数据块数；status；autoextensible 数据文件是否可扩展；

v$controlfile控制文件：name；status；

tablespace表空间

数据字典纵观

dba以DBA_为前缀，记录数据库实例的所有对象的信息，如DBA_TABLES视图，可以访问所有用户的表信息

user是以user_为前缀，记录用户对象的信息，如user_tables视图

all以ALL_为前缀，记录用户信息与被授权访问的对象信息



v$以V$为前缀，记录与数据库活动有关的性能统计动态信息，如V$DATAFILE视图，记录了有关数据文件的统计信息

【无视】  gv$以GV$为前缀，记录分布式环境下所有实例的动态信息

常用数据字典

tables 表
table_name表名
tablespace表空间
users 用户
status状态
column_name列名
dba_users
