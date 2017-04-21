

sed -i 直接在原文件操作
“s/原/改/g” 文件路径 将文件里面原全部修改成改  
s/代表修改
g代表全部修改，不加g修改每行第一个 
a/代表添加
i/插入

sed '/bbbb/a\xiaowu' file 在指定bbbb下面添加一行
sed '/b/i\xiaowu' file 在指定bbbb上面添加一行
sed -e '4a\xiaowu' file 在第4行后面添加一行
sed 's/cc.*/& eeeee/g' file 在指定ccc行尾增加 eeee

/dev/null ：代表空设备文件
>  ：代表重定向到哪里，例如：echo "123" > /home/123.txt
1  ：表示stdout标准输出，系统默认值是1，所以">/dev/null"等同于"1>/dev/null"
2  ：表示stderr标准错误
&  ：表示等同于的意思，2>&1，表示2的输出重定向等同于1

1 > /dev/null 2>&1 语句含义：
1 > /dev/null ： 首先表示标准输出重定向到空设备文件，也就是不输出任何信息到终端，说白了就是不显示任何信息。
2>&1 ：接着，标准错误输出重定向（等同于）标准输出，因为之前标准输出已经重定向到了空设备文件，所以标准错误输出也重定向到空设备文件。

sed -i '2a\dddd' install.log  插入dddd到文件第二行
sed -i '2d' install.log 删除文件第二行
sed '2p' install.log 打印第二行
sed -n '1,/caieuvo/'p install.log 输出第一行到模式匹配到的那一行

sed命令中$表示最后一行

grep -i 忽略大小写 -n输出行数 -r循环查找 -G 正则表达式 --color 彩色标示查找项
