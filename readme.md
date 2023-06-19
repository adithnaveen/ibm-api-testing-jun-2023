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

- download and install Postman 

- download and install mysql 
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

- Mockito (Practicles)

