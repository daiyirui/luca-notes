# Linux 安装 Maven  

## 1. Maven 压缩包下载与解压  

华为云下载源，自行选择版本  
下面的示例使用的是 3.8.1 版本

```bash
wget https://repo.huaweicloud.com/apache/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.tar.gz
```  

解压 `apache-maven-3.8.1-bin.tar.gz`

```bash
tar -zxvf apache-maven-3.8.1-bin.tar.gz
```  

移动到 `/usr/local` 目录  

```bash
mv apache-maven-3.8.1 /usr/local/
```

## 2. 配置环境变量  

```bash
vi /etc/profile
```  

在最后面追加  

```bash
export MAVEN_HOME=/usr/local/apache-maven-3.8.1/
export PATH=${PATH}:${MAVEN_HOME}/bin
```

使环境变量生效  

```bash
source /etc/profile
```
