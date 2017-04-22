表空间

create temporary tablespace 《tablespace_name》 force logging online permanent
temporary 存放数据
force logging 生成日志记录项，记录创建和更改操作
online立即可用
permanent持久保存表空间中的对象

datefile file_name size k autoextend on|off nextnumber k|m maxsize k|m|unlimited extent management local
size初始大小，autoextend是否自动扩展，nextnumber 每次扩展的大小，maxsize 扩展的最大限度unlimited代表不限制，file_name是一个dbf文件路径，extent management local表示是本地管理


为表空间增加数据文件
alter tablespace tablespace_name add datafile datafile_name size ;

修改数据文件大小
alter database datafile datafile_name resize m;

查询是否自动扩展autoextensible

修改表空间状态
alter tablespace tablespace_name offline|read only|read write

删除表空间
drop tablespace tablespace_name including contents and datafiles cascade constraints ;
