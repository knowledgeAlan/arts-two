# java 中 linkedList使用



##1介绍

*[LinkedList](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html)*   是双项列表，实现*[List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)* 和 *[Deque](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)* 
  接口，实现所有list可选和操作元素方法



## 2 特点

下面是*LinkedList*最重要特性:

+ 操作list元素从开始或结束反序

+ 不是线程安全

+ 它的*[Iterator](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)* 和 *[LIstIterator](https://docs.oracle.com/javase/8/docs/api/java/util/ListIterator.html)* 迭代是[快速失败](https://stackoverflow.com/questions/17377407/what-are-fail-safe-fail-fast-iterators-in-java)(迭代器创建之后，如果List 被修改，会抛出*[ConcurrentModificationException](https://docs.oracle.com/javase/8/docs/api/java/util/ConcurrentModificationException.html)* )

+ 每个元素是个node节点，节点保持之前和之后引用

+ 保持插入有序

  虽然*LinkedLIst* 不是线程安全，我们创建线程安全版本LinkedList，调用*[Collections.synchronizedList](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html#synchronizedList-java.util.List-)*  如下：

  >   List list = Collections.synchronizedList( new LinkedList(...));

  

## 3 比较 ArrayList

两者都实现List接口，他们有不同地方(决定我们使用那个)

### 3.1 结构

`Arraylist` 基于数组保存数据中元素，提供随机访问元素，访问效率(O(1))

第一方面，`LinkedList` 元素发在每个节点中，每个节点保存前面节点和后面节点引用构成，基于这种情况，搜索查询元素执行时间(O(n))



### 3.2 操作

`LinkedList` 插入、增加和移除操作是比较快，因为它不需要扩容或更新元素位置，当元素增加，仅改变周围元素



### 3.3 内存使用情况

*LinkedList* 使用内存比*ArrayList* 多，因为`LinkList` 每个节点都会有两个引用，一个指向之前和一个指向后一个节点，`ArrayList` 仅仅保存数据和索引

## 4 用法

下面一些使用示例

### 4.1 创建

>    LinkedList<Object> linkedList =  new LinkedList<>();



### 4.2 增加



`LinkedList` 实现 `List` 和 `Deque` 接口，除了标准 *add*() 和 *addAll()*  方法，你还可以找到*addFirst()* 和 *addLast()* ,分别是增加一个元素在开始或最后



### 4.3 删除元素

和元素增加相似，实现`List` 接口，提供*removeFirst()* 和 *removeList()* 方法,

同时，也提供方便删除方法*removeFirstOccurence()* 和*removeLastOccurence()*

,返回布尔类型(如果 `LinkedList` 有元素，返回true)



### 4.4 队列操作

*Deque* 接口提供队列方法(*Deque* 继承 *Queue* 接口)



>    linkedList.poll();
>
>    linkedList.pop();



这些方法放回第一个元素和删除从*list*

poll和pop之间不同是pop会抛出异常*NoSuchElementException()* 当*list* 为空，

然而poll返回空，*pollFirst()* 和 *pollLast()*  也是可以，下面push api 示例

>   linkedList.push(Object o);

在集合头部插入元素

*LinkedList* 有许多其他方法，大部分用户已经熟悉使用*lists* ,其他*Deque* 提供方法可以很方便在标准方法中作为可选



## 总结

`ArrayList` 是 *List* 默认实现，然而，一些情况使用`LinkedList` 会更好，例如：

频繁插入和删除

[原文](https://www.baeldung.com/java-linkedlist)

