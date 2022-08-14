# random-digits-service

## Table of content ##
- [Overview](#Overview)
- [Logic](#Logic)
  - [chat method](#chat-method)
  - [chatAuto method](#chatAuto-method)
  - [Web Socket Config](#Web-Socket-Config)
- [Building](#Building)

## Overview ##

- Main purpose of project is create arrays full of unique digits and return 6 numbers from each group to html page by clicking on buttons 
- 2 methods of DigitController helps to achieve that
1. chat()
2. chatAuto()

## Logic ##

### chat method ###

> That method is linked with "GENERATE"

    To get rid of billion possibilities of launch of task I am created it based on ConcurrentHashMap
    
    After connection you will create message based on task() method and return needed digits

### chatAuto method ###

> That method is linked with "AUTO"

    Same as previous method
    It uses ConcurrentHashMap to get rid of billion possibilities of launch of task 
  

    After connection you will create message based on auto() method and return needed digits automatically

### Web Socket Config ###

> Web Socket Broker and endpoints are configured in config package

## Building ##
##### 1. Copy repo to local then move to dir #####

    git clone https://github.com/holydrug/random-digits-service.git
    cd random-digits-service/

##### 2. Compile project and run jar from root path #####

    ./mvnw package
    java -jar ./target/random-digits-service-0.0.1-SNAPSHOT.jar

##### 3. Give a try to link below #####

    http://localhost:8080/