#!/usr/bin/env bash

echo "开始更新代码......"
git pull origin master

echo "开始删除静态文件......"
rm -rf ./xacpr-core/src/main/resources/static
rm -rf ./xacpr-web/dist/
rm -rf ./target/

echo "开始编译代码......"
cd xacpr-web/ & gradle clean build -x test --stacktrace -i
cd xacpr-core/ & gradle clean build -x test --stacktrace -i

echo "开始拷贝jar包....."
gradle deploy

echo "开始杀掉已经启动的进程......"
exit_port=`jps -l | grep xacpr-core | cut -d ' ' -f 1`

if [[ ${exit_port} -gt 0 ]]; then
    echo "进程号为${exit_port}"
    kill -9 ${exit_port}
fi

echo "开始启动服务......"
java -jar target/xacpr-core-1.0.0-boot.jar --spring.profiles.active=prod &

sleep 10
echo "请登录http://localhost:8080/查看服务是否正常"
