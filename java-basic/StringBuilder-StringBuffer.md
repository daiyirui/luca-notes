# Java 中 String 与 StringBuffer 和 StringBuilder 的区别
## 介绍

String 是 Java 中很常用的类之一，同时，字符串是 Java 面试中最重要的话题之一。  

StringBuffer 和 StringBuilder 类提供了操作字符串的方法。  

我们将研究 StringBuffer 和 StringBuilder 之间的区别。  

StringBuffer 与 StringBuilder 的区别是 Java 中很常见的面试题。

在控制台上打印程序的内容，可以使用 String。此博客介绍 String 类的主要功能，然后我们将比较 StringBuffer 和 StringBuilder 类。  

## String

注意一个常见的错误，不要记错了。因为 String 是 final 修饰的，无法被继承。所以 String 不是 Java 的基本数据类型。  
字符串在 Java 中是不可变的，因此适合在多线程环境下使用。  
当我们使用双引号创建一个字符串时，如下，JVM 首先在字符串池中寻找具有相同值的字符串。

```java
String str1 = "ABC";
```
如果找到了，它将返回字符串池中的字符串对象的引用。否则，它会在字符串池中创建字符串对象并返回引用。JVM 通过在不同的线程中使用相同的字符串，节省了大量的内存。  

如果使用 new 运算符创建字符串，则会在堆中创建它。

运算符 `+` 是为 String 重载的，我们可以用它来串联两个字符串。尽管在内部它使用 StringBuilder 来执行这个动作。  

两个字符串只有在它们具有相同字符串的时候才相等，equals() 方法区分大小写。如果您正在寻找不区分大小写的检查，您应该使用 equalsIgnoreCase()  方法。  

## 拼接字符串  

由于 String 在 Java 中是不可变的，因此每当我们执行字符串拼接操作时，它都会生成一个新的 String 并丢弃旧的 String 以进行垃圾收集。  
这些重复的操作会在堆中产生大量垃圾冗余。所以 Java 提供了 StringBuffer 和 StringBuilder 类，应该用于字符串操作。  
StringBuffer 和 StringBuilder 是 Java 中的可变对象。  

它们为字符串操作提供了 `append`、`insert`、`delete` 和 `substring` 方法。  

| StringBuffer  | StringBuilder |
| ------------- | ------------- |
| 线程安全      | 非线程安全    |
| 同步          | 非同步        |
| 始于 Java 1.0 | 始于 Java 1.5 |
| 慢            | 快            |

在 Java 1.4 之前，StringBuffer 是字符串操作的唯一选择。但是，它的一个缺点是所有公共方法都是同步的。 StringBuffer 提供线程安全性，但以性能为代价。  

在大多数情况下，我们不会在多线程环境中使用 String。所以 Java 1.5 引入了一个新类 StringBuilder，除了线程安全和同步之外，它与 StringBuffer 类似。

StringBuffer 有一些额外的方法，例如 substring, length, capacity, trimToSize 等。但是，这些不是必需的，因为 String 中也有所有这些。这就是为什么这些方法从未在 StringBuilder 类中实现的原因。

StringBuffer 是在 Java 1.0 中引入的，而 StringBuilder 类是在查看 StringBuffer 的缺点后在 Java 1.5 中引入的。

假设在单线程环境中或无关线程安全，要使用 StringBuilder。反之，使用 StringBuffer 进行线程安全的操作。



## 总结

- String 是不可变的，而 StringBuffer 和 StringBuilder 是可变类。

- StringBuffer 是线程安全和同步的，而 StringBuilder 不是。这就是 StringBuilder 比 StringBuffer 快的原因。

- 字符串连接运算符 (+) 在内部使用 StringBuilder 类。

- 对于非多线程环境中的字符串操作，我们应该使用 StringBuilder 否则使用 StringBuffer 类。
