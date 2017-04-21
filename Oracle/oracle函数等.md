字符串函数
UPPER 
LOWER
INITCAP 首字母大写

CONCAT(char1，char2)连接
SUBSTR(char，[m[,n]])获取子串，从1开始计算
LENGTH
INSTR(char1,char2,[n[,m]])获取子串在源串的位置，n为搜索位置，m为第几次出现


LPAD(char1,n,char2)、RPAD(char1,n,char2)左右补位函数，用char2把char1补足到N位
TRIM(c2 from c1)左右截取子串，常用于去空格，LTRIM(c1[,c2])左边截去子串，RTRIM(c1[,c2])右边截去子串
REPLACE(char,search_string[,replace_string])

数字函数
ROUND(n[,m])四舍五入，m为小数点后第几位
TRUNC(n[,m])截取，m为小数点后第几位
CEIL(n)取大于或等于n的最小整数值
FLOOR(n)取小于或等于n的最大整数值
ABS绝对值
MOD(n,m)余数
SIGN检查数字正负
POWER(m,n)m的n次幂
SQRT(n)n的平方根

日期函数
SYSDATE返回当前系统时间
NEXT_DAY(date, char)获取下一个周几的日期,可以用1-7代替周几，1为周日
LAST_DAY(date)本月最后一天
MONTH_BETWEEN(date1,date2)两个日期间隔多少个月
ROUND/TRUNC
SESSIONTIMEZONE返回时区

转换函数
TO_CHAR(date[,fmt[,nlsparams]])nlsparams用于指定日期语言，常用fmt格式：YY两位数字年份，YYYY四位数字年份，YEAR英文全拼年份，MM两位数字月份，MON简拼月份，MONTH全拼月份，DD两位数字天，DDSPTH英文全拼天，DY周几缩写，DAY周几全拼，HH24二十四小时制(默认)，HH12十二小时制，MI分钟，SS秒
TO_DATE字符转日期

NULL函数
COALESCE(expr1[,expr2..])返回第一个非空表达式的结果
NVL(expr1,expr2)如果expr1为null，则取值expr2
NVL2(expr1,expr2,expr3)如果expr1不为null，则取值expr2，否则取值expr3
NULLIF(expr1,expr2)如果expr1与expr2相等则返回null，否则返回expr1
GREATEST/LEAST返回最大最小值


其他
CASE expr1 WHEN expr2 THEN .. ELSE expr END 
DUMP数据类型码


数据操纵与事务控制
INSERT INTO table_name[(column[,column..])] VALUES(value[,value..]);
INSERT INTO table_name[(column[,column..])] SELECT ..;使用子查询插入
INSERT ALL|FIRST [CASE .. WHEN ..THEN INTO .. ELSE INTO .. END] SELECT ..;使用子查询查出来的结果按照case语句分别插入不同的表，当前面设为ALL时可以重复插入，FIRST只插入一次

UODATE table_name SET column = value .. [WHERE ..];
UPDATE table_name SET (column，column..) = (SELECT ..) WHERE ..;使用子查询更新

DELETE FROM table_name WHERE ..;

数据库对象
CHAR(n)长度为n的字符串，如果长度不足，用空格补齐
VARCHAR(n)最大长度为n的字符串
NUMBER(p，s)固定长度的整数和浮点数，总位数p，小数位数s，定位整数时也可以用INT
DATE日期
TIMESTAMP 时间日期
BLOB二进制数据大对象类型，小于等于4gb
CLOB字符数据大对象类型，小于等于4gb
BFILE数据库外部二进制文件

数据字典
DBA_***：指整个数据库包含的对象信息，如DBA_TABLES,DBA_OBJECTS;DBA_DATA_FILES,DBA_USERS;DBA_CONSTRAINTS约束条件，DBA_DATA_FILES数据文件，DBA_TABLESPACES，V$FIXED_TABLE动态性能视图，V$INSTANCE实例状态,V$SGA共享池，V$SGAINFO内存分配数据，V$CONTROLFILE控制文件，V$DATAFILE所有数据文件，V$LOGFILE重做日志文件,V$DATABASE数据库信息

ALL_***：指用户可以访问的对象信息，如ALL_INDEXS

USER_***：指用户自己方案下的对象信息
DICT表记录所有的数据字典

create table [用户名.]table_name (column_name datatype[default expr]...); 可以用子查询建表，相当于复制create table name as select ..;
ALTER TABLE table_name add ();增加列
ALTER TABLE table_name modify ();修改列
ALTER TABLE table_name DROP ();删除列
ALTER TABLE table_name RENAME COLUMN column_name TO new_name;修改列名
RENAME OLD_NAME TO NEW_NAME;修改表名
DROP TABLE table_name CASCADE CONSTRAINT; 删除表

CONSTRAINT约束条件：NOT NULL,UNIQUE,PRIMARY KEY, FOREIGN KEY,CHECK
ALTER TABLE table_name ADD [CONSTRAINT [NAME ] constraint_type(column,..)]添加表约束，CHECK(expr)
ALTER TABLE table_name ADD CONSTRAINT [NAME ] foreign key (column) REFERENCES table_name2(column);建立外键
ALTER TABLE table_name DISABLE|ENABLE CONSTRAINT constraint_name CASCADE;禁用|启用约束，先在DBA_CONSTRAINTS查询约束名称

CREATE[OR REPLACE] VIEW view_name[(column,..)] AS SELECT .. [WITH READ ONLY];创建或修改视图
DROP VIEW view_name;

