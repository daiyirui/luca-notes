# Go 的学习

## 基本类型
*   布尔型
    
    `bool` 布尔型的值只可以是常量 `true` 或者 `false`，默认值为 `false`。
    
*   字符串类型
    
    `string` 编码统一为 `UTF-8` 编码标识 `Unicode` 文本，默认值为空字符串。
    
*   整型（默认值为 0）
    
    *   `uint8`： 无符号 8 位整型（0 ~ 255）；
    *   `uint16`：无符号 16 位整型（0 ~ 65535）；
    *   `uint32`：无符号 32 位整型（0 ~ 4294967295）；
    *   `uint64`：无符号 64 位整型（0 ~ 18446744073709551615）；
    *   `int8`：有符号 8 位整型（-128 ~ 127）；
    *   `int16`：有符号 16 位整型（-32768 ~ 32767）；
    *   `int32`：有符号 32 位整型（-2147483648 ~ 2147483647）；
    *   `int64`：有符号 64 位整型（-9223372036854775808 ~ 9223372036854775807）
*   浮点型（默认值为 0）
    
    *   `float32`：`IEEE-754` 32 位浮点数；
    *   `float64`：`IEEE-754` 64 位浮点数；
    *   `complex64`：32 位实数和虚数；
    *   `complex128`：64 位实数和虚数；
*   其他数值类型
    
    *   `byte`：类似 `uint8`；
    *   `rune`：类似 `int32`；
    *   `uint`：32 或 64 位；
    *   `int`：与 `uint` 一样大小；
    *   `uintptr`：无符号整型，用于存放一个指针；

派生类型

*   指针类型（Pointer）
*   数组类型
*   结构化类型（struct）
*   Channel 类型（chan）
*   函数类型（func）
*   切片类型（slice）
*   接口类型（interface）
*   Map 类型（map）



## defer 

Go 语言的 `defer` 会在当前函数返回前执行传入的函数，它会经常被用于关闭文件描述符、关闭数据库连接以及解锁资源