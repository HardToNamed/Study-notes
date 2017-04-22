在Go语言中，每一个并发的执行单元叫作一个goroutine。

新的goroutine会用go语句来创建。在语法上，go语句是一个普通的函数或方法调用前加上关键字go。go语句会使其语句中的函数在一个新创建的goroutine中运行。

主函数返回时，所有的goroutine都会被直接打断（输出也被清除），程序退出。

互斥锁
mu      sync.Mutex
mu.Lock()
defer mu.Unlock()

读写锁
var mu sync.RWMutex 允许多个只读操作并行执行，但写操作会完全互斥
调用RLock和RUnlock方法来获取和释放一个读取或者共享锁，调用mu.Lock和mu.Unlock方法来获取和释放一个写或互斥锁

所有并发的问题都可以用一致的、简单的既定的模式来规避。所以可能的话，将变量限定在goroutine内部；如果是多个goroutine都需要访问的变量，使用互斥条件来访问。

var loadIconsOnce sync.Once 一次性初始化变量
loadIconsOnce.Do(loadIcons) do方法接收初始化函数作为参数
