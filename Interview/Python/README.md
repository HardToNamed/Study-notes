## 记录面试中python相关问题

1. 为什么Python不需要函数重载?
  函数重载的作用在于不同变量类型, 不同变量个数的情况下实现同样的功能, python的函数变量可以接受任何类型的变量, 而且python对于不同变量个数的情况也有处理的方法, 所以不需要函数重载.
  
2. Python创建socket的流程是什么?
```
import socket 
web = socket.socket()
web.bind(('127.0.0.1',8080))
web.listen(5)
while True:
  conn,addr = web.accept()
  data = conn.recv(1024)
  conn.send(bytes('<h1>welcome nginx</h1>','utf8'))
  conn.close()
```

3. Python的三种拷贝模式.
  * 直接赋值,传递对象的引用而已,原始列表改变，被赋值的b也会做相同的改变
  * copy浅拷贝，没有拷贝子对象，所以原始数据改变，子对象会改变
  * 深拷贝，包含对象里面的子对象的拷贝，所以原始对象的改变不会造成深拷贝里任何子元素的改变
