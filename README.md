# Knowledge-Fragment-Index

收口并同步所有碎片化的知识来源到notion等地方-（对标notion助手）

# 食用方式

## notion

+ 在notion中新建一个 page:
  ![img.png](readme/page.png)
+ 新建一个 integration:![img.png](readme/newIntegration.png)
+ copy access token: ![img.png](readme/token.png)
+ 回到page，添加刚刚创建的 integration: ![img.png](readme/addIntegration.png)
+ 为了能够访问到db，需要手动新增一个db: ![img.png](readme/addDatabase.png)
+ share获取到当前页面的link: ![img.png](readme/shareLink.png)
+ link的格式是这样的: ``https://www.notion.so/1593df3a46e249f79749cc08490f6520?v=0cae032112d2456783739099fac0776c``;
  我们只需要当前页面实际的uuid，即： ``1593df3a46e249f79749cc08490f6520``
+ 将这两个key放置到 ``application.yml`` 中的配置里: ![img.png](readme/application.png)

## 前端页面生成

我目前是会将 build 之后的前端页面push到git上，但是为了保险起见 建议在 ``git clone`` 之后，在手动build一下：

```bash
cd xxx/webapp
yarn build
```

## maven 打包

使用maven打包出jar包即可上传到 vps 运行提供服务

# 开发日志

## notion-api

## 查询db接口 get

查询接口格式为: ``https://api.notion.com/v1/databases/1593df3a46e249f79749cc08490f6520/query``
其中 header 中要填入token:

![img.png](readme/query-api.png)

对应的 cURL为:

```curl
curl --location --request POST 'https://api.notion.com/v1/databases/1593df3a46e249f79749cc08490f6520/query' \
--header 'Authorization: Bearer secret_maPyFv5VNIS00RKJf36p4t9qmwo8m8YGZNAxhcC10Y5' \
--header 'Notion-Version: 2022-06-28' \
--header 'User-Agent: Apifox/1.0.0 (https://www.apifox.cn)' \
--header 'Content-Type: application/json'
```

同时可以注意到返回的response中我们关心的就是 ``result.properties`` 中的map数据

## 新增接口 put

该notion-api先暂时放弃，原因：极其不稳定