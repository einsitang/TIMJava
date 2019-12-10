# TIM-java-sdk [![LICENSE](https://img.shields.io/badge/License-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE) [![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

本项目是 云通讯(腾讯) 服务 Java 版本 开发工具包

## 进展

- 账号管理 ✅💯
- 单聊消息管理 
- 在线状态管理 ✅💯
- 关系链管理  ✅💯
- 资料管理 ✅💯
- 群组管理
- 脏字管理
- 全局禁言管理
- 运营相关管理

## 准备工作

- IDE 上配置lombok支持插件
- JDK >= 1.8
- Maven 环境

## 配置
*TIMConfig*
```
appId           : 腾讯云腾讯SDKID
adminIdentifier : 管理员账号
privateKeyPath  : 管理员私钥文件地址
accountType     : 管理员accountType
reqMaxRetry     : 请求最大重试数
```

## 使用
```
TIMConfig config = new TIMConfig(...);
TIMService timService = new TIMServiceImpl(config);

// 导入好友
try{
    timService.getRelationService().importFriends(...)
}catch(TIMException e){
    if(e.getError().getErrorCode() == 30010){
        // 好友已达系统上限
    }
}


// 更多接口请参照文档或者com.sevlow.sdk.tim.api接口
```

## 开发
`com.sevlow.sdk.tim.api`下定义接口
`com.sevlow.sdk.tim.api.impl`下实现接口方法
`com.sevlow.sdk.tim.bean`下存放接口所需的Req和Resp结构化参数

### 编译
```
mvn clean install
```

### 测试

#### 配置参数
复制 /src/test/resources 下的 `config.test.example.yml` 并重命名为 `config.test.yml`

在 `config.test.yml` 下输入 腾讯 云通讯对应的配置，`privateKeyPath`项可以写文件的绝对路径，亦可以将该文件放到 /src/test/resources 下并重命名为`private_key.example.txt`

在 `.gitignore` 文件下对 `private_key.example.txt` 和 `config.test.yml` 文件做了忽略处理，这样不用担心提交到开源仓库

#### 测试用例

编写完代码后，在 /src/test/java 下有对应的测试用例，可以按照里面的方式进行编写

测试套件使用`TestNG`

测试套件的注入工具使用`com.google.inject:guice`

## 贡献代码

fork 本项目

clone自己fork的仓库

添加本仓库地址为远程仓库
```shell
git remote add upstream https://github.com/forfuns/TIMJava.git
```

定期保持自己仓库和此项目的内容

```shell
git fetch upstream
git checkout develop
git rebase upstream/develop
git push origin develop

```

切换到`develop`分支

在自己的仓库和develop的分支上开发代码，并且编写测试用例

最后在此项目中提交`PR`(Pull request)
