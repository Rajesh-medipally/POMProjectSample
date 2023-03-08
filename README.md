# POMProjectSample
# Fashionette.de application automation sample project
This Repository is a sample work for the company fashionatte.de 
it includes the automation of fashionette.de website. 
where it includes automation procedures like adding item into cart and loggin into the application.

NOTE : This repository is only for the presentation purpose.

The Project includes
## Technologies
- JAVA
- SELENIUM
- TESTNG
- MAVEN
- EXTENT REPORT
- LOG4J 

## IDE & Plug-ins used
- ECLIPSE
- TESTNG
- MAVEN

## Model
the framework follows PAGE OBJECT MODEL (POM).

## Folder Structure
```
org.fashionatte.de
├── src
|    |──test
|    |     |──java
|    |           |──org.fashionatte.de.PageObjects
|    |           |──org.fashionatte.de.testCases
|    |           |──org.fashionatte.de.utilities
|    |           |──org.fashionatte.de.testData
|    |──resources
|            
|─── Configurations            
|─── ScreenShots            
|─── test-reports            
|─── application.log            
|─── pom.xml            
|─── testng.xml                     
                       
```

## Folders Details

-> src/test/java/org/fashionatte/de/PageObjects contains all the pages elements and its corresponding methods, which let us to use the elements efficieantly like get, set etc...

-> src/test/java/org/fashionatte/de/testCases this folder contains the test classes, where we perform the automation testing of the application.

-> src/test/java/org/fashionatte/de/utilities this folder contains all the supporting classes for automation, like, to read from excel, to read from configuration file, to set a listener etc...

-> src/test/java/org/fashionatte/de/testData this folder contains all the test data excel files used for testing. in our case we have only one excel sheet to test  different logins.

-> Configurations this folder contains meta data about application and most used details inside the project.

-> Screenshots this folder as it suggests contains the failed and succeeded screenshots of the execution.

-> test-reports this folder contains generated reports of the application, with the time frame and date as folder name, also it generate each one separately for every different test class.

-> application.log this folder contains the log files of the execution.

-> pom.xml this is a common file, where we can handle the packages needed for project.

-> testng.xml this folder contains the test suite details. 




## Run Configurations.


-> Need to install java [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

->Needed to [install Eclipse](https://www.eclipse.org/downloads/)

->Download [this Repository](https://github.com/Rajesh-medipally/POMProjectSample)

->open the project in eclipse and complete the sync procedure

->in eclipse goto Help->Eclipse MarketPlace and search for testng for eclipse it looks like below and complete the download.
![eclipse](https://user-images.githubusercontent.com/52613470/223594455-d0153b47-004a-4d00-bb05-2fa28863270e.png)

-> in the project goto testng.xml file (it can be found mostly in the bottom) and open it.

-> in testng.xml -> right click-> Run As -> TestNG Suite. (if you didnt seeing the TestNG Suite option, which means testng plugin not installed properly).

-> click TestNG Suite option, then the project will start executing.. 

-> after execution to see the reports. goto-> test-reports folder (it can be found easily from bottom).

-> in test-report folder, you will find files with the name of current time and date. open the file with recent time on it. (ther will be 2 files alomost equal in time stamp, those 2 files represents each of the test classes. one is add to cart results, another one is login test results).

-> an html page will get open in eclipse, then right click -> open with-> browser. then you can see the results. 

the report looks like below picture
![resultpage](https://user-images.githubusercontent.com/52613470/223596968-535033f6-d740-4bda-b6a4-842d91ddebb7.png)


-> To see the screenshots separatly goto screenshots folder, where you can find successfull and failure test folder accordingly.
-> For the log files open application.log file, there you can read the recent log files of execution.
-> to see selenium report test-output-> index.html


## NOTE : 
project, test and code explanations are written in classes more precisely to make it comfortable to understand.


# THANK YOU VERY MUCH
# RAJESH MEDIPALLY

