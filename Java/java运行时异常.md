java运行时异常是可能在java虚拟机正常工作时抛出的异常。

java提供了两种异常机制。一种是运行时异常(RuntimeExepction)，一种是检查式异常(checked execption)。

检查式异常：我们经常遇到的IO异常及sql异常就属于检查式异常。对于这种异常，java编译器要求我们必须对出现的这些异常进行catch 所以 面对这种异常不管我们是否愿意，只能自己去写一堆catch来捕捉这些异常。

运行时异常：我们可以不处理。当出现这样的异常时，总是由虚拟机接管。比如：我们从来没有人去处理过NullPointerException异常，它就是运行时异常，并且这种异常还是最常见的异常之一。

RuntimeExecption在java.lang包下，

下面是由java虚拟机提供的运行时异常

AnnotationTypeMismatchException, 
ArithmeticException, 
ArrayStoreException, 
BufferOverflowException, 
BufferUnderflowException, 
CannotRedoException, 
CannotUndoException, 
ClassCastException, 
CMMException, 
ConcurrentModificationException, 
DOMException, 
EmptyStackException, 
EnumConstantNotPresentException, 
EventException, 
IllegalArgumentException, 
IllegalMonitorStateException, 
IllegalPathStateException, 
IllegalStateException, 
ImagingOpException, 
IncompleteAnnotationException, 
IndexOutOfBoundsException, 
JMRuntimeException, 
LSException, 
MalformedParameterizedTypeException, 
MirroredTypeException, 
MirroredTypesException, 
MissingResourceException, 
NegativeArraySizeException, 
NoSuchElementException, 
NoSuchMechanismException, 
NullPointerException, 
ProfileDataException, 
ProviderException, 
RasterFormatException, 
RejectedExecutionException, 
SecurityException, 
SystemException, 
TypeConstraintException, 
TypeNotPresentException, 
UndeclaredThrowableException, 
UnknownAnnotationValueException, 
UnknownElementException, 
UnknownTypeException, 
UnmodifiableSetException, 
UnsupportedOperationException, 
WebServiceException 

看到这么多异常，想要找出我们常见的5中运行时异常是非常容易的。  

例如：ClassCastException(类转换异常)

IndexOutOfBoundsException(数组越界)
NullPointerException(空指针)
ArrayStoreException(数据存储异常，操作数组时类型不一致)
还有IO操作的BufferOverflowException异常
