# System Requirement 

- System with 8 GB
- Hypervisor Support to test with docker
- About 50 GB free space
- Operating System Mac / Windows / Linux
- Open internet access

--- 
# List of Softwares Tobe installed in System 

## Step 1 
- Download and install jdk 11 for your respective OS(Mac/Win/Linux) - https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html

- Download and install Eclipse for your respective OS(Mac/Win/Linux) -  https://www.eclipse.org/downloads/packages/

- Download and install NodeJS(LTS) for your respective OS(Mac/Win/Linux) -  https://nodejs.org/en/download

- download and install Postman - https://www.postman.com/downloads/

- mongodb - https://www.mongodb.com/try/download/community
---

# Introduction 

- ashwini - 7 year exp web ui testing + automation exp, have worked with RestAssure, to understand end to end API Testing 

- Bhawesh - with ibm 12+ year, working test lead, working as Main frame testing, started working with automation UFT, working selenium + API testing and to implement in the project 

- DeviSatyaNarayani - 7 years exp in testing (with ibm 1 year), working with automation testing in project started API testing to know more about API testing 

- Hiranmai - 10 year exp in testing, most exp in automation + selenium, with with SAP, with IBM 2+ year, have worked with performance have got exposure to API testing with postman 

- Ishita - 5.3 year exp with IBM, working as manual testing moving to automation testing, to explore on the tech needs 

- Lingaraj - 15+ years exp worked as test lead, worked with SOAPui + Postman 

- Maya menon - with ibm 8 years, functional testing worked in selenium, API Testing 

- Mohit - 6 years with IBM, exp with selenium + api, to explore more on API testing 

- Pallavi - 

- Prashanth - 15 year exp, in to test management, upgrating to automation testing 

- Roshanth Alishetty - 7 yers in testing, with ibm 1.5 yrs, end to end testing - have done db, etl  testing, have got little exp with api, looking for service virtualization 

- Sanmeet - 8 years exp in IBM, working with automation, need more exposure automation, need more on API Testing in real world exposure + leads the project 

- Swetha - 2 yrs exp, working on manual testing and need to move to automation testing 

- Zakir Hussain - 15 years exp, manual + soap ui proejct, have worked with selenium have got exposure with automation 


--- 

# Day 1 

- Have installed Java & Eclipse 
- The need of API Testing (Concept)
    - API 
    - Web Testing 
    - Mock Testing / Mocking 

```
// mistakes 
<!-- 
    1. user object is not there 
    2. are you handling excpetion's 
    3. test amount of time taken 
    4. positive / negative cases 
    5. the program is self is wrong since its main it has single entry what if i want to have multiple tests parallalley 
    6. 100's of users - not only functional test + non functional test 
 -->
    class MyFirstTest{
        public static void main(String args[]) {
            UserService us = new UserServie(); 
            boolean flag = us.checkForValidUser(user); 

            if(flag) {
                // go ahead and get profile information 
            }else {
                // sorry invalid crednetials 
            }

        }
    }
```
- to work on jUnit (Practicles)
    - jUnit 
        - 4 - sequential / there was no ordering / did not support parallel execution (mostly till java 7) / did not support lambdas / lot of boiler plate code 
        - 5 - they are are parallel execution / you can go with ordering / they support lambadas / less code more do 
    - TestNG

    - afternoon session 
        - write clear cases 
        - handle exception 
        - grouping test cases 
        - given display name 
        - order execution of test cases 

```
    interface MyInterface {
        void doMyJob(); 
    }

    // way 1 
    class DoBusiness implements MyInterface {
       void doMyJob() {} 
    }

    // way 2 
    class ItsPrashanthBusiness {
        void myOwnMethod() {
            MyInterface m =  () ->   // do your stuffs  ; 
        }
    }

```

- Mockito (Practicles)
    - BDD (Behaviour Driven Development)
        - Given - Pre Condition 
        - When - The actual 
        - Then - Post Condition 

        - And - Multiple condition 
        - But - against condition 

```
    Employee e = new Employee(); 


    Employee e = mock(Employee.class);
```




# Day 2 

```
package junit5work;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;

import com.ibm.business.Hello;

public class EmployeeListTest {
    Hello h = new Hello(); 
}

```

- in java what can be imported 
    1.  you can import all the classes of the package with import com.ibm.* ; 
    2. you can import a specific class from the package with import com.ibm.Hello; 
    3. you can an option to do static import import static com.ibm.Hello.seeYou; 
```
package com.ibm.business; 

    class Hello {
        static void seeYou() {}
    }

    class Hi {

    }
```

- when you have an interface,  when there are new methods bought in then the stub has to invariably changed 
- and currently we are deveping and testing instead we should mock the data, such that when the interface changes no change to code / no breakage 


```
    @Mock
	IMessageService messageService;  

	@InjectMocks
	MessageServiceImpl messageServiceImpl; 


    - behind the screen is 

    
	IMessageService messageService = mock(ImessageSercie.class); 
	MessageServiceImpl messageServiceImpl = new MessageServiceImpl(messageService); 
```

- What is 
    - web serivce 
        - accessed over internet 
        - SOAP / JAXB 
        - Its an arch (x)
        - use HTTP 
    - REST
        - its an API 
        - 
    - RESTful 
        - it is an application accessed via API's 

    - XML 
    - JSON 


- Earyly 90's 
    - any standards 
        - Java  - 93 
        - CGI - 80 
        - CPP - 70 
        - COBOL - 60 
        - Python 

    - Even WWW was not there (it started around 1991)
    - EDI - Electronic Data Interchange (x25 standara / sita link / Com / DCom/ RMI, CORBA)
    - transmit the data in Text -> 7-8 to figure out 
    - in 1999 - WWW standardarize - XML - is the way how you describe the data
    - SOAP / WSDL / SOA (For Contract) - WebService is the way to provide interface for communication / interact 
    - 1999 - 2008 - web services were used heavily 
    - w3c proposed - Xpath / XSD / XSLT / XSL / XML 
    - in 2004  - Representational State  - ReST - API 
    - for Rest you can use any kind of HTTP Server 
    - the Rest take JSON / XML / RPC 
    - HTTP 1.0 / HTTP 1.1 / HTTP2.0 
    - HATEOS - Rest v/s RESTful
```
    <employees>
        <employee>
            <firstName salutation="Mr">Bhawesh</firstName>
            <lastName>Hariom</lastName>
            <address>
                <hno>123</hno>
                <street>Greewn View Blvd</street>
                <city>Restcon</city>
                <state>Virginia</state>
                <country>USA</country>
            </address>
            <insurnace>
                <dependencies>
                    ... 
                </dependencies>
            </insurance>
        </employee>

          <employee>
            <firstName salutation="Mr">Pranshan</firstName>
            <lastName>Kumar</lastName>
            <address>
                <hno>223</hno>
                <street>Greewn View Blvd</street>
                <city>Restcon</city>
                <state>Virginia</state>
                <country onsite="yes">USA</country>
            </address>
            <insurnace>
                <dependencies>
                    ... 
                </dependencies>
            </insurance>
        </employee>
    </employees>

     -- json 

     {
        "employees":[
            "employee": {
                "firstName":"Bhawesh", 
                "lastName":"Hariom", 
                "address": {
                    "hno":123, 
                    "street":"Green View Blvd", 
                    "city":"Reston", 
                    "state":"Virginia", 
                    "country":"USA"
                }
            }, 
            employee: {}

        ]
     }
```


- http://localhost:9090/ - spring boot application 



# Day 3 

- look for 
    - CDN
    - http 1.1 

- http verbs 
    - GET 
    - POST 
        - will take the body / payload 
    - DELETE
    - PUT 
    - PATCH 

### to test the controller various tools are available (API - Json/XML)
- Postman
- Rest Assured 
- Cypress
- HttpClient 
- SoapUI 
- Karate 
- Cucumber 

### install json-server  and working 
    - npm i -g json-server 
    - Create a db.json file with some data

        ```{
        "posts": [
            { "id": 1, "title": "json-server", "author": "typicode" }
        ],
        "comments": [
            { "id": 1, "body": "some comment", "postId": 1 }
        ],
        "profile": { "name": "typicode" }
        }```

- json-server --watch db.json

- https://jsonplaceholder.typicode.com/posts
- https://localhost:3000/posts


- rest assured followd 
    - Given 
    - When 
    - Then 
