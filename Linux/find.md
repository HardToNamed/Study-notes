

-name
-perm按文件权限
-prune不在当前指定目录查找
-user     -nouser
-group   -nogroup
-mtime 按修改直接 -n代表现在n天以内，+n代表n天以前
-newer file1 ！file2 查找更改时间比file1新但比file2旧的文件
-type某一类型的文件 d目录 p管道文件 l符号连接文件 f普通文件
-depth 首先查找当前目录的文件，然后再在其子目录查找
-follow 跟踪至连接说指向的文件

xargs命令
如find 。 -name *\-type f -print | xargs chmod o-w【xargs后面接命令】
