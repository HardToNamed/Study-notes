oracle初始化参数
spfile永久参数文件，/opt/oracle/oradb/home/dbs查看参数文件 select value from v$parameter where name = 'spfile';查看存放地址，修改方法：SQL>create pfile='$ORACLE_HOME/dbs/temp_pfile.ora' from spfile='+DG_ORA/i2kdb/spfilei2kdb.ora';#vi $ORACLE_HOME/dbs/temp_pfile.ora;SQL>create spfile='+DG_ORA/i2kdb/spfilei2kdb.ora' from pfile='$ORACLE_HOME/dbs/temp_pfile.ora';

/opt/oracle/oradb/diag/rdbms/i2kdb/i2kdb/trace/alert_i2kdb.log 

V$PARAMETER/V$SPPARAMETER初始化参数视图，常用参数：sort_area_size排序所使用的最大内存，control_files控制文件名，shared_pool_size共享池，java_pool_size缓存池，processes进程的最大数量，db_cache_size高速缓存大小
ALTER SESSION SET parameter_name = parameter_value [SCOPE = MEMORY|SPFILE|BOTH] [SID = 'sid'|'*]修改初始化参数，memory代表临时修改，spfile表示永久修改，sid表示使用特定的sid，*表示默认sid

用户
create user UNIQUEUSER
identified by Atae1234
default tablespace tablespace_name
quota [unlimited|n M] on tablespace_name
account unlock [password expire]; 创建新用户,n代表一个数字, password expire表示强制登陆时重置口令

赋于基本权限，如果不赋于相应的权限，则不能连接数据库
grant connect,resource to username;
赋于用户其它权限
grant privilege_name to username;
删除用户权限
revoke privilege_name from username;
修改用户密码
alter user username identified by password;
修改用户默认表空间
alter user username default tablespace tablespace_name;
删除用户
drop user username cascade;

select username,use_id,account_status,lock_date,expiry_date from dba_users;
权限名称：INDEX(CREATE ANY INDEX,ALTER ANY INDEX,DROP ANY INDEX),TABLE(CREATE ANY TABLE,ALTER ANY TABLE,DROP ANY TABLE,SELECT ANY TABLE,UPDATE ANY TABLE,DELETE ANY TABLE),SESSION(CREATE SESSION,ALTER SESSION,RESTRICTED SESSION),TABLESPACE(CREATE TABLESPACE,ALTER TABLESPACE,DROP TABLESPACE,UNLIMITED TABLESPACE)

角色
查看系统中存在的所有角色
select role from dba_roles;
查看赋于用户或者角色的角色：
select grantee,granted_role from dba_role_privs where grantee='role_name';
查看角色信息
select role,password_required from dba_roles where role='role_name';
查看角色的系统权限
Select role,privilege from role_sys_privs where role='role_name';
查看角色的对象权限
select role,owner,table_name,privilege from role_tab_privs where role='role_name';
创建角色
create role role_name identified by password;
赋于角色权限
grant create session,create table, create view to role_name;
删除角色权限
revoke privilege_name from role_name;
删除角色
drop role role_name;

将角色授予用户grant role_name to user_name；
