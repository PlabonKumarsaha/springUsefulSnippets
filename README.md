# springUsefulSnippets

* ParsingURLJSOnToPOJO -> Parsing a URL's GET request to a POJO
* spring-security-learn -> Basic Spring Securities
* Consume a 3rd party API : https://spring.io/guides/gs/consuming-rest/
* emp-deploy - deploying an app in tomcat
* Request Param
```
//http://localhost:8088/api/v1/empbyId/?id=1&name=plabon (link- Pass the values as params)
    @GetMapping("empbyId")
    Employee getDataByNameId(@RequestParam Integer id,@RequestParam String name){
        Employee returnData = empRepository.findByNameANDId(id,name);
        return returnData;
    }
```

* Like parameter in JPQL
```
 @Query(value = "SELECT * FROM employee WHERE employee.id = :id AND employee.name LIKE %:name%",nativeQuery = true)
    Employee findByNameANDId(int id, String name);
```

* procedure call

```
private final static String INCREMENT_BALANCE_PROCEDURE = "PLABON.PRACTICE_PK.dpr_increase_balance";

    //for database connection
    @Autowired
    private EntityManager entityManager;
    
 StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(INCREMENT_BALANCE_PROCEDURE);
         //in parameters
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        // OUT params. 2nd param is the type of out variable
        query.registerStoredProcedureParameter(3, Integer.class, ParameterMode.OUT);
        query.setParameter(1, actnum);
        query.setParameter(2, acttit);
        int outputCode = (int) query.getOutputParameterValue(3);
        System.out.println("out code "+outputCode);
        return outputCode;
```
* Procedure call with alternate param names
```
   System.out.println("actnum "+ actnum);
        System.out.println("acttit "+ acttit);
        StoredProcedureQuery query = this.entityManager.createStoredProcedureQuery(INCREMENT_BALANCE_PROCEDURE);
        //in parameters
        query.registerStoredProcedureParameter("in_actnum", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("in_acttit", String.class, ParameterMode.IN);
        // OUT params. 2nd param is the type of out variable
        query.registerStoredProcedureParameter("out_code", Integer.class, ParameterMode.OUT);
        query.setParameter("in_actnum", actnum);
        query.setParameter("in_acttit", acttit);
        int outputCode = (int) query.getOutputParameterValue("out_code");
        System.out.println("out code "+outputCode);
        return outputCode;
```
### The procedure which was called
```
CREATE OR REPLACE PACKAGE BODY PLABON.PRACTICE_PK
IS
   out_message   VARCHAR2 (1024);
   out_cuscod    VARCHAR2 (1024);
   
PROCEDURE dpr_increase_balance (
      in_actnum      IN       VARCHAR2,
      in_acttit      IN       VARCHAR2,
      out_code       OUT      INTEGER
) IS
--CURSOR cur_cust IS SELECT ACT_NUM, ACT_TITLE,BALANCE FROM PLABON.CUSTOMER WHERE ACT_NUM = in_actnum AND ACT_TITLE = in_acttit;

 BEGIN
      BEGIN
     UPDATE PLABON.CUSTOMER SET BALANCE = BALANCE +100 WHERE ACT_NUM = in_actnum AND ACT_TITLE = in_acttit;
     IF SQL%FOUND THEN
     out_code := 0;
     ELSE out_code := 1;
     END IF;
     EXCEPTION WHEN OTHERS THEN
     out_code :=2;
     END;
  END;
END;
```
-- Added to convert nested json data

```
** TODO **
AI Reception Robot
AI Reception is a reception robot that can interact with users to satisfy their queries by delivering answers recognizing users' history. This robot has two parts- hardware and software. In the software section, web developer needs to care about building robust modules that can synchronize the total system and save the data into the webserver for further use.
The total system has several modules: Person identification, Speaker Identification, Face Recognition, Speaker Recognition, Automatic Speech Recognition, Natural Language Processing, Text to Speech Synthesis, Datasets.
All the modules are custom built and dependent on different environments, versions. Individual modules are built with python and more than 50+ libraries are used to make it robust. The web developer must take care of this issue to make the asynchronous system so that users can go through all the modules sequencing and save & fetch data from the webserver for future use.
In a short rescription, initial the system will start by pressing the button on the tabs visual interference and simultaneously face recognition with activate. Then for further authorization speaker recognition with activated by recording 20s voice. If the person is not recognized his personal information will be saved.

Furthermore, the system will take loopwise voice recording to process his query and give the exact answer by text to speech synthesis model. Users' data will be saved in the backend to use in the future.
List of python models already prepared for the system:
● Person identification,
● Speaker Identification,
● Face Recognition,
● Speaker Recognition,
● Automatic Speech Recognition,
● Natural Language Processing,
● Text to Speech Synthesis,
● Datasets.
Expected Work to be Done:
▪ Synchronize all the models into one frame.
▪ Flask/Django is preferred.
▪ Multiple machine learning application hosting in server in sqlite/pysqlite.

▪ Data should be saved in the webserver.
View Khondaker A.’s profile
```
* Add the Jenkins config
Data paritioning : https://www.javacodegeeks.com/2020/08/adding-partition-to-existing-table-in-oracle.html
