测试功能

test -e /test && echo "exist"  || echo "not exist"测试文件是否存在
-e文件名是否存在
-f文件名是否存在且为文件
-d文件名是否存在且为目录
-L文件名是否存在且为一个连接文件
-z 是否为空字符串
文件权限检测
-r文件名是否存在且有可读权限
-w文件名是否存在且有可写权限
-x文件名是否存在且有可执行权限
-s文件名是否存在且非空白文件

test file1 -nt file2文件比较
-nt检测file1是否比file2新
-ot检测file1是否比file2旧

test n1 -eq n2整数判定
-eq相等
-ne不等
-gt n1大于n2
-lt n1小于n2
-ge n1大于等于n2
-le n1小于等于n2
