## 设计模式（Design pattern） - 责任链模式（Chain of Responsibility Pattern）

### 1. 责任链模式
责任链，顾名思义，就是用来处理相关事务责任的一条执行链，执行链上有多个节点，每个节点都有机会（条件匹配）处理请求事务，如果某个节点处理完了就可以根据实际业务需求传递给下一个节点继续处理或者返回处理完毕。

### 2. 模式优缺点
#### 2.1. 优点
看下使用责任链模式后，有什么好处！

1. 新增拦截逻辑，只需要再实现一个AbstractFilter类即可
2. 修改拦截顺序，只需要修改Order注解的大小，越小，优先级越高
3. 代码清晰，所有处理逻辑下沉到实现类中

#### 2.2. 缺点
做到了低耦合，高扩展。但也带来了一些不好的地方

1. 逻辑更复杂，用了链式等数据结构，要注意单例的问题，不能重复使用
2. 类数量激增，一个拦截器就一个类

### 参考地址
* [if-else嵌套太深？教你一个新手都能掌握的设计模式搞定！](https://mp.weixin.qq.com/s?__biz=MzI3NzE0NjcwMg==&mid=2650126998&idx=1&sn=2d5f0d447daa49d3f925d084f5275c04&chksm=f36ba7b7c41c2ea1994c9b5b99c47431e1f13d8a2ba3fd778ef74699d30b81f00e002b6a5b02&scene=126&sessionid=1585970243&key=ef447128290e130533c31462f663f4ae504bd9de83286a4f4916addaeb31184c180ddb9d7d911e412f540608268b8360937345e2334b8c4d2ee5b6e218f17b4f6f4daf736ac3e551dfe33b9c360b8dfd&ascene=1&uin=MTU2NDAxNDYyMA%3D%3D&devicetype=Windows+10&version=62080079&lang=zh_CN&exportkey=AdjxzidTpR76uBYGCjkCboE%3D&pass_ticket=QN3pnYZN4WSawZdAIspT5sFA0aTRArv%2BSbwTJpsTX1osVuXipPB9k5NMs%2BDfyU09)
    
