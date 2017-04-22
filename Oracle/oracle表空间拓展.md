oracle表空间拓展

第一步：查看表空间的名字及文件所在位置：

 

select tablespace_name, file_id, file_name,round(bytes/(1024*1024),0) total_spacefrom dba_data_filesorder by tablespace_name;

第二步：表空间拓展

 

方法一：增大数据文件大小：

alter database datafile '表空间位置'resize 新的尺寸

例如：ALTER DATABASE datafile '/opt/oracle/oradb/oradata/i2kdb/omsperfdb.dbf' resize 35G;

 

方法二：增加数据文件个数 

alter tablespace 表空间名称     

            add datafile '新的数据文件地址' size 数据文件大小

例如：alter tablespace ESPS_2008     add datafile '\oracle\oradata\anita_2010.dbf' size 1000m 

 

方法三：设置表空间自动扩展。

alter database datafile '数据文件位置'     autoextend on next 自动扩展大小 maxsize 最大扩展大小

例如：alter database datafile '/opt/oracle/oradb/oradata/i2kdb/omsperfdb.dbf' autoextend on next 100m maxsize 50G; 

 

第三步：查询表空间使用情况：

SELECT a.tablespace_name, a.total_m, b.fee_m, (a.total_m - b.fee_m) / a.total_m AS "used%"  FROM (SELECT a.tablespace_name, SUM(a.bytes) / 1024 / 1024 AS total_m          FROM dba_data_files a         GROUP BY a.tablespace_name) a  LEFT JOIN (SELECT a.tablespace_name, SUM(a.bytes) / 1024 / 1024 AS fee_m               FROM dba_free_space a              GROUP BY a.tablespace_name) b    ON a.tablespace_name = b.tablespace_name ORDER BY 4 DESC;
