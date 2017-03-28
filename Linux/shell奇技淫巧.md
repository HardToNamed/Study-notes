# vi
vi ${sudo_conf_file} << END
:%s#SUDO_PATH#${path}#g
:wq
END

# read循环
while read -r line  #使用read命令从file中读取一行并赋给line变量
do
echo $line 
done < $file

# read
read -t 5 -p "Enter your name:" username 读取键盘输入，加上-s时隐藏输入
