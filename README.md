# Coding Test Program



This program have two part, first is a program to send request, second is a unit test.



## The First Part

This program will read the query data from query.txt (src/main/resources/query.txt) and build it to http request than use multi-thread send request to Baidu then generate summarize and print it to console.

![timeDIagram](/Users/dengkai/workspace/coding/src/main/resources/timeDIagram.jpg)


![3 配置通道](https://user-images.githubusercontent.com/79621538/170102313-a007cb8f-8c81-48a6-b18e-092ffc24ef19.jpg)



## The Second Part 

This part is a simple test about the program. 

Firstly you can use method writeQueryToFile() to define how many query you want to send.

Secondly you can use method sendTest() to send query, you can also set how many thread you want to use by change the threadNumber.

