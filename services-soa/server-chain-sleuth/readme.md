# 关于zipkin的链路追踪zipkin-server ,spring cloud 官方建议直接启动zipkin-sever.jar,不建议自己搭建zipkin-server

相关参数配置见https://github.com/openzipkin/zipkin/tree/master/zipkin-server
基本启动命令(当前版本2.12.9)：java -jar zipkin.jar
rabbitmmq 配置启动
java -jar zipkin.jar --zipkin.collector.rabbitmq.addresses=192.168.3.2:5672 --zipkin.collector.rabbitmq.username=dev --zipkin.collector.rabbitmq.password=dev --zipkin.collector.rabbitmq.virtual-host=dev
 启动后访问地址：http://127.0.0.1:9411/zipkin
 