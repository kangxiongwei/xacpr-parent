#!/usr/bin/env bash

echo "开始更新代码......"
git pull origin master

echo "开始编译代码......"
gradle clean build -x test --stacktrace -i

echo "开始拷贝jar包....."
gradle deploy

echo "开始杀掉已经启动的进程......"
exit_port=`jps -l | grep xacpr-core | cut -d ' ' -f 1`
kill -9 ${exit_port}

echo "开始启动服务......"
java -jar target/xacpr-core-1.0.0.jar --spring.profiles.active=prod &

echo "发布完成，请登录http://localhost:8080/查看服务是否正常"
