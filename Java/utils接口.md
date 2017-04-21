collection 容器接口
  Set  无顺序不可重复
    HashSet 类 
  List 有顺序可重复
    LinkedList 类
    ArrayList 类
  Map
    HashMap
调用remove/contains方法时比较对象相等,调用对象中的equals方法/hashCode方法

Iterator接口  hasnext, next, remove

List 
  sort(List) 排序
  shuffle(List) 随机排列
  reverse(List) 逆序排列
  fill(List, Object) 用一个特定对象重写List容器
  copy(List dest, List src) 将src中的内容拷到dest中
  binarySearch(List, Object) 对顺序的list, 用折半查找的方法查找对象

compareable 接口
