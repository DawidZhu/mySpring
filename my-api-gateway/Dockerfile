# Step0: Create Docke file Object
#Dockerfile其实可以看做一个命令集。每行均为一条命令。每行的第一个单词，就是命令command。
#Docker 镜像由只读层组成，每个层代表一个 Dockerfile 指令。这些层是堆叠的，每一层都是前一层变化的增量。
#  在命令行运行  docker build -t publisher-dockerfile .
FROM openjdk:11

EXPOSE 9090

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]