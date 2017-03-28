# setfacl和getfacl设置细分控制权限

getfacl test   #查看acl权限列表
getfacl -c test  #查看acl权限，省略头信息

setfacl -m u:username:rw- filename
