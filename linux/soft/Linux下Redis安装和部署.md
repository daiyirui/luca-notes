# Linux 下 Redis 安装和部署  

## 1. 基础知识

Redis 是用 C 语言开发的一个开源的高性能键值对（key-value）数据库。它通过提供多种键值数据类型来适应不同场景下的存储需求
目前为止 Redis 支持的键值数据类型如下

* 字符串(String)
* 列表（lists）
* 集合（sets）
* 有序集合（sorts sets）
* 哈希表（hashs）

## 2. Redis 的应用场景

缓存（数据查询、短连接、新闻内容、商品内容等

* 分布式集群架构中的 session 分离。
* 聊天室的在线好友列表。
* 任务队列。（秒杀、抢购、12306 等等）
* 应用排行榜。
* 网站访问统计。
* 数据过期处理（可以精确到毫秒）

## 3. 安装 Redis

下面介绍在 Linux 环境下，Redis 的安装与部署 使用 Redis-3.0 稳定版, 因为 Redis 从 3.0 开始增加了集群功能。
可以通过官网下载 [http://download.Redis.io/releases/Redis-4.0.11.tar.gz](http://download.Redis.io/releases/Redis-4.0.11.tar.gz)
或者使用 linux wget 命令

```
[root@ceilan-linux ~]# wget http://download.Redis.io/releases/Redis-4.0.10.tar.gz
```

将 Redis-4.0.11.tar.gz 移动到/usr/local 下

```
[root@ceilan-linux ~]# mv Redis-4.0.10.tar.gz /usr/local
```

解压二进制包

```
[root@ceilan-linux local]# tar -zxvf Redis-4.0.10.tar.gz
```

进入解压后的目录进行编译

```
[root@ceilan-linux local]# cd Redis-4.0.10
[root@ceilan-linux local]# make PREFIX=/usr/local/Redis install
```

注意：需要指定的文件夹应该是空的
如果此时出现 gcc …Not found
需要安装 gcc

```
Ubuntu
      sudo apt-get install gcc
Centos
      yum install update
      yum install gcc
```

Redis.conf 是 Redis 的配置文件，Redis.conf 在 Redis 源码目录。
拷贝配置文件到安装目录下
进入源码目录，里面有一份配置文件 Redis.conf，然后将其拷贝到安装路径下

```
cd usr/local/Redis
mkdir conf
cp /usr/local/Redis-4.0.10/Redis.conf  /usr/local/Redis/conf
```

进入安装目录 bin 下

```
cd /usr/local/Redis/bin
```

目录结构是这样的

![](https://cdn.nlark.com/yuque/0/2020/jpeg/631242/1590513937376-555f9c71-ca3d-4905-9643-4ff56403d89d.jpeg#align=left&display=inline&height=181&margin=%5Bobject%20Object%5D&originHeight=181&originWidth=780&size=0&status=done&style=none&width=780)

| redis-benchmark | redis 性能测试工具 |
| --- | --- |
| redis-check-aof | AOF 文件修复工具 |
| redis-check-rdb | RDB 文件修复工具 |
| redis.conf | redis 配置文件 |
| redis-sentinal | redis 集群管理工具 |
| redis-server | redis 服务进程 |

## 4. 启动 Redis

#### 4.1 前端模式启动

直接运行 bin/redis-server 将以前端模式启动，前端模式启动的缺点是 ssh 命令窗口关闭则 redis-server 程序结束，不推荐使用此方法

#### 4.2 后端模式启动

修改 Redis.conf 配置文件， daemonize yes 以后端模式启动
vim /usr/local/Redis/bin/Redis.conf

执行如下命令启动 Redis：
cd /usr/local/Redis
./bin/redis-server ./conf/Redis.conf

#### 4.3 连接 Redis

[root[@ceilan-linux ](https://www.yuque.com/ceilan-linux) bin]# ./redis-cli

#### 4.4 Mac 启动 Redis

```
redis-server /etc/Redis.conf
```

## 4.5 Redis 设置密码

编辑 Redis.conf 文件

```
# requirepass foobared
requirepass yourpassword  //此处注意，行前不能有空格
```

## 5. 关闭 Redis

#### 5.1 正确停止 Redis

```
cd /usr/local/Redis
./bin/Redis-cli shutdown
```

#### 5.2 强行终止 Redis

> 强行终止 Redis 进程可能会导致 Redis 持久化数据丢失

```
pkill redis-server
```

#### 5.3 让 Redis 开机自启

```
vim /etc/rc.local
#Redis
/usr/local/Redis/bin/redis-server /usr/local/Redis
```

## 6. 出现的异常

#### 6.1 redis-cli shutdown 出现 (error) NOAUTH Authentication required

Redis 设置密码登录后，想关闭 Redis 服务器，需要

```
Redis-cli -a 密码 shutdown
```

#### 6.2 Redis 编译报致命错误：jemalloc/jemalloc.h：没有那个文件或目录

分配器 allocator， 如果有 MALLOC 这个 环境变量， 会有用这个环境变量的 去建立 Redis。
而且 libc 并不是默认的 分配器， 默认的是 jemalloc, 因为 jemalloc 被证明 有更少的 fragmentation problems 比 libc。
但是如果你又没有 jemalloc 而只有 libc 当然 make 出错。 所以加这么一个参数, 运行如下命令：

```
make MALLOC=libc
```

## 7. Mac 上的 Redis 的开启关闭命令

#### 7.1 启动 Redis

后台启动

```
redis-server /etc/Redis.conf &
```

#### 7.2 关闭 Redis

```
redis-cli  -a 密码 shutdown
```

## 8. Redis 开启 Redis

修改 Redis.conf，找到 bind 那行配置, 注释掉

```
bind 127.0.0.1
```
