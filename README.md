# TIM-java-sdk [![LICENSE](https://img.shields.io/badge/License-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

本项目是 云通讯(腾讯) 服务 Java 版本 开发工具包

## 准备工作

- IDE 上配置lombok支持插件
- JDK >= 1.8
- Maven 环境

## 配置

## 使用

## 开发

### 编译

### 测试

#### 配置参数
复制 /src/test/resources 下的 `config.test.example.yml` 并重命名为 `config.test.yml`

在 `config.test.yml` 下输入 腾讯 云通讯对应的配置，`privateKeyPath`项可以写文件的绝对路径，亦可以将该文件放到 /src/test/resources 下并重命名为`private_key.example.txt`

在 `.gitignore` 文件下对 `private_key.example.txt` 和 `config.test.yml` 文件做了忽略处理，这样不用担心提交到开源仓库

#### 测试用例

编写完代码后，在 /src/test/java 下有对应的测试用例，可以按照里面的方式进行编写

测试套件使用`TestNG`

测试套件的注入工具使用`com.google.inject:guice`

### 贡献代码

fork 本项目

clone自己fork的仓库

添加本仓库地址为远程仓库
```shell
git remote add root https://github.com/forfuns/TIMJava.git
```

定期保持自己仓库和此项目的内容

```shell
git fetch root
git checkout develop
git rebase root/develop
git push origin develop

```

切换到`develop`分支

在自己的仓库和develop的分支上开发代码，并且编写测试用例

最后在此项目中提交`PR`(Pull request)

## coffe

:-)