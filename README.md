# tamboot-cloud

tamboot-cloud在[tamboot](https://github.com/chensheng/tamboot)框架的基础上，集成了[spring cloud](https://spring.io/projects/spring-cloud)的服务注册、发现等功能，开发者可基于此快速搭建微服务系统。

* [模块介绍](#模块介绍)
* [详细教程](https://github.com/chensheng/tamboot-cloud/wiki)
* [应用实例](https://github.com/chensheng/tamboot-cloud-admin)

## 模块介绍

### tamboot-cloud-microservice

该模块用于微服务的注册，引入该模块，进行简单的配置，系统会自动将服务注册到服务注册中心。


### tamboot-cloud-client

该模块用于微服务的消费，引入该模块，定义好要调用的微服务，就能像调用本地服务一样来调用微服务。