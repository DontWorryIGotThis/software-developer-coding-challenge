# Software Developer Coding Challenge

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)

## General info
This project is an implementation of a simple auction system.
	
## Technologies
Project is created with:
* Spring MVC,Core,TEST 5.1.3
* Jboss Wildfly 14 (Web Application Server)
* MySql Database 8.0.13
	
## Setup
* Install Maven
* Install and setup profiles/users on wildFly to enable application deployment.
* Install MySql database
* Setup the following Schema with three tables
	-	Schema Name: auctionschema
		schema name can be configured in the url property for the data source bean in auctionServiceContext.xml
		like so jdbc:mysql://localhost:3306/<auctionschema>
#### Legend to describe the following tables 
		<TableName>[<ColumnName>(<Datatype>(size)<pk or fk>),...]
		pk- primary key
		fk- foreign key
#### Tables
		- user[userid(varchar(5)pk), email(varchar(45)), name(varchar(45))]  
		- vehicle[vehicleid(varchar(6)pk), make(varchar(45)), model(varchar(45)), milesdriven(int(11)), winningbid(int(30))] 
		- bid[bidid(varchar(7)pk), vehicleid(varchar(6)fk), userid(varchar(5)fk), bidamount(int (11))]

*After having cloned the repository, head to the directory /<git-local-repo-path>/software-developer-coding-challenge/auctionApp/
```
mvn install
```

* The artifact will be generated in the directory .../auctionApp/auctionAppPackage/target
* The artifact will be named auctionAppPackage-0.0.1-SNAPSHOT.ear
* Spin up the JBOSS server and hit http://localhost:8080 to access the admin console
* Deploy the application and hit the url http://localhost:8080/auctionator/app/ to access the auction system.




This is a coding challenge for software developer applicants applying through http://work.traderev.com/

## Goal:

#### You have been tasked with building a simple online car auction system which will allow users to bid on cars for sale and with the following funcitionalies: 

  - [ ] Fork this repo. Keep it public until we have been able to review it.
  - [ ] A simple auction bidding system
  - [ ] Record a user's bid on a car
  - [ ] Get the current winning bid for a car
  - [ ] Get a car's bidding history 

 ### Bonus:

  - [ ] Unit Tests on the above functions
  - [ ] Develop a UI on web or mobile or CLI to showcase the above functionality

## Evaluation:

 - [ ] Solution compiles. Provide a README to run/build the project and explain anything that you leave aside
 - [ ] No crashes, bugs, compiler warnings
 - [ ] App operates as intended
 - [ ] Conforms to SOLID principles
 - [ ] Code is easily understood and communicative
 - [ ] Commit history is consistent, easy to follow and understand
