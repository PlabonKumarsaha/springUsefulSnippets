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
