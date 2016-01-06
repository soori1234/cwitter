# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Cwitter - Mini Twitter Application
* 1.0


Frameworks Used
1) Spring 3.x
2) Hibernate 4.x


### How do I get set up? ###

* Summary of set up
 1) Install JDK 1.7
 2) Install MYSQL 5.1.13
 3) Create Database called 'cwitter' in mysql
 4) Add Apache Tomcat v7.x to eclipse
 5) Checkout the cwitter code to eclipse workspace
 6) Edit hibernate.cfg.xml file which is under /src folder. Provide mysql database login details
 7) Run the cwitter code on tomcat server
 
 
 Note:
  1.Add vmargs eclipse.ini file which is in eclipse home directory
 
 -vmargs
-Dosgi.requiredJavaVersion=1.5
-Xms256m
-Xmx512m
-XX:MaxPermSize=512m


2.Edit tomcat permgenspace property