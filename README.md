# Knowledge-Fragment-Index

收口并同步所有碎片化的知识来源到notion等地方-（对标notion助手）

# 食用方式

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