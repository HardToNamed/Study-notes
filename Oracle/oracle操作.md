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
