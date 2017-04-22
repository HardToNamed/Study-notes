fmt.Printf()
fmt.Sprintf()
fmt.Errorf()

%v 以默认的方式打印变量的值
%T 类型

整型
%d 整型 %+d 带数字的整型
%q 打印单引号
%o 不带零的八进制
%#o 带零的八进制
%x 小写的十六进制
%X 大写的十六进制
%#x 带0x的十六进制
%U 打印Unicode字符
%#U 打印带字符的Unicode
%b 打印整型的二进制
%5d 表示该整型最小长度是5

浮点数
%f (=%.6f) 6位小数点
%e (=%.6e) 6位小数点（科学计数法）

String
%s 正常输出字符串
%q 字符串带双引号，字符串中的引号带转义符

Struct
%v 正常打印。比如：{sam {12345 67890}}
%+v 带字段名称。比如：{name:sam phone:{mobile:12345 office:67890}
%#v 用Go的语法打印。
