SELECT 0-15 从0到15这16个数据仓库中选择一个插入

### 数字类
* INCR  key增加指定数字, INCRBY key number 指定一个数字作为这次递增的数值, 一次有效
* DECR key减少指定整数, DECRBY key number 指定一个数值作为此次减少的数值
* INCRBYFLOAT key number 增加一个浮点数

### String类
* SET key value 设置键值对
* GET key 获取值
* APPEND key value, 向键值的末尾追加value, 当键值不存在时跟set一样处理
* STRLEN key 获取字符串长度

* MSET key1 value1 key2 value2 同时设置多个键值对
* MGET key1 key2 同时获取多个键值对


### 位操作
* GETBIT key offset 获取指定位置2进制的值
* SETBIT key offset value 设置指定位置2进制的值
* BITCOUNT key [start] [end] 获取值为1 的二进制位个数
* BITOP operation destkey key1 [key2] 进行为运算, 并将结果存放在destkey中, 支持AND,OR,XOR,NOT


### 散列
* HSET key field value 其中key表示map的名字, field 和value表示键值对 
* HGET key field
* HDEL key field [field] 删除
* HEXISTS key field 判断存在
* HSETNX key field 当不存在时赋值
* HINCRBY key field number 增加数值
* HMSET key field value [field, value] 
* HMGET key field 
* HGETALL key 
* HKEYS key 只获取字段名
* HVALS key 只获取value值
* HLEN key 获取字段数量


### 列表
* LPUSH key value [value] 向列表左侧增加元素
* RPUSH key value 向列表右侧增加元素
* LPOP key 弹出左侧元素
* RPOP key 弹出右侧元素
* LLEN key 获取长度
* LRANGE key start stop 获取列表片段(这是闭区间), 支持负索引, -1表示右边第一个元素
* LREM key count value删除列表中前|count|个值为value的元素, 当count>0时, 从左边开始删除, 当count<0时, 从右边开始删除, 当count=0时,删除所有
* LINDEX key index 获取指定索引的元素
* LSET key index value 设置指定索引的元素
* LTRIM key start end 删除指定索引之外的片段
* LINSERT key BEFORE|AFTER pivot value 从左到右查找值为pivot的元素, 然后按照BEFORE/AFTER 插入位置
* RPOPLPUSH source destination 从source的右边弹出一个元素并插入到destination的左边


### 集合
* SADD key member 增加元素
* SREM key member删除元素
* SMEMBERS key 获取所有元素 
* SISMEMBER key member 判断元素是否在集合中
* SCARD key 获取集合中元素个数
* SRANDMEMBER key [count] 随机从集合中获取count个元素
* SPOP key 弹出一个元素

### 集合运算
* SDIFF key [key ] 对多个集合执行差值运算
* SINTER key [key] 对集合执行交集运算
* SUNION key [key] 对集合执行并集运算


### 有序集合 
 >  <font color=#FF0000>-- 与列表区别: <br>1. 列表通过链表实现, 当元素增多后获取中间元素的速度较慢, 有序集合通过散列表和跳跃表实现, 所以读取中间部分的数据速度较快(O(log(N))) <br>2. 列表中不能简单调整某个元素的位置, 有序集合可以(通过修改score) <br>3. 有序集合比列表更耗费内存(只支持数字)</font>
* ZADD key score member 增加一个元素和分苏, 如果该元素已存在则用新的分数替换
* ZSCORE key member 获取元素的分数
* ZRANGE key start stop [WITHSCORES] 按从小到大的顺序返回索引从start到stop的所有元素, 如果要包含score的话就带上withscores参数
* ZREVRANGE key start stop [WITHSCORES] 从大到小排序
* ZRANGEBYSCORE key min max [WITHSCORES] [limit offset count] 获得指定分数范围的元素
* ZINCRBY key number member 增加一个元素的分数
* ZCARD key 获取元素的数量
* ZCOUNT key min max 获得指定范围内的元素个数
* ZREM key member 删除元素
* ZREMRANGEBYRANK key start stop 按排名范围删除元素
* ZREMRANGEBYSCORE key min max 按分数范围删除元素
* ZRANK key member 获得元素的排名
* ZREVRANK key member 获取反向元素的范围


### 事务
* MULTI 事务开始, EXEC 事务执行, 在MULTI和EXEC中间的命令要么全部执行, 要么不执行
当事务的语法错误时. 不会执行, 当事务执行错误时, 正确的语句还是会继续执行
* WATCH key 监控一个或多个键, 当其中一个键被修改时, 之后的事务就不会执行, 监控一直持续到exec命令

* EXPIRE key seconds 设置过期时间, PEXPIRE key millseconds 设置过期时间, 单位毫秒
* TTL key 获取剩余过期时间, 当key不存在时返回-2
* PERSIST key清除过期时间, 设置为永久

### 排序
* SORT 命令

### 发布/订阅模式
* publish channel message 发布信息
* subscribe channel 订阅信息
* psubcribe pattern 按照规则订阅 
* punsubscribe [pattern] 按照规则退订



