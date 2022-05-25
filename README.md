# Coding Test Program



This program have two part, first is a program to send request, second is a unit test.



## The First Part

This program will read the query data from query.txt (src/main/resources/query.txt), next build qurey to http request, then use multi-thread send request to Baidu,finally generate summarize and print it to console.


![3 配置通道 ](https://user-images.githubusercontent.com/79621538/170102833-299d8679-f8f9-452f-8e4a-51b09a5056c5.jpg)



## The Second Part 

This part is a simple test about the program. 

Firstly you can use method writeQueryToFile() to define how many query you want to send.

Secondly you can use method sendTest() to send query, you can also set how many thread you want to use by change the threadNumber.

