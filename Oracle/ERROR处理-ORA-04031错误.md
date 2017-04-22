ORA-04031错误

ORA-04031: unable to allocate 393240 bytes of shared memory ("large pool","unknown object","large pool","ASM map operations hashtable")

sqlplus / as sysdba
create pfile='$ORACLE_HOME/dbs/temp_pfile.ora' from spfile='+DG_ORA/i2kdb/spfilei2kdb.ora';
exit
vi $ORACLE_HOME/dbs/temp_pfile.ora
修改值  
i2kdb.__large_pool_size=53554432
*.memory_target=9823022592 
这两项都改大一点。
sqlplus / as sysdba
create spfile='+DG_ORA/i2kdb/spfilei2kdb.ora' from pfile='$ORACLE_HOME/dbs/temp_pfile.ora';
startup
