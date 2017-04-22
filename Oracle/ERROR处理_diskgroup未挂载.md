表现：diskgroup "DG_ORA" does not exist or is not mounted

解决方法：srvctl start asm;srvctl start diskgroup -g DG_ORA
或者crsctl stat res -t; 查看服务状态
crsctl start res dg.rsm 启动rsm
