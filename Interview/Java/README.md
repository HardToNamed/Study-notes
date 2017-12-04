## hello Java

1. java的垃圾管理机制  
java使用被称作垃圾收集器的技术来监控java程序的运行, 当对象不再使用时就自动释放对象占用的内存. java使用软指针来跟踪对象的每个引用, 并用一个对象表映射对象的引用.
垃圾收集器是自动运行的, 可以通过System.gc()来显式调用垃圾收集器, 但不能保证立即回收指定的对象.

2. 堆和栈的区别  
在java中, 使用new申请的对象都存放在堆内存中, 并将其指针变量存放到栈中, 其他对象则存放在栈中

1.系统默认的浮点数是double型
2.++的优先级比+要高, 后置++在下一次运算后体现
3.写在{} 中的是局部变量
4.基础类型从低到高为 (byte - short -char) - int -long - float -double, 其中byte/short/char是同级的
5.三目计算符中, 会按照较高的精度进行转换, 但是当较高的那个是常量时, 不会进行主动转换
6.在任意多个类的实例中, 一个静态变量的实例只有一个
7.子类构造函数调用时必须先调用父类构造函数

内存管理

1.


classloader

首先jvm启动运行bootstrap classloader(启动类加载器)加载核心的api(ExtClassLoader 和AppClassLoader也在此时被加载), 然后调用ExtClassLoader加载扩展api, 最后AppClassLoader加载ClassPath下的class, 这就是一个程序的加载流程


异常

所有异常都是由Throwable派生而来, Error类对象是由java虚拟机生成并抛出, 属于运行时异常, Exception是java处理或抛出的对象, 编译器要求程序必须捕获或声明所有非运行时异常, 但对运行时异常可以不做处理.
