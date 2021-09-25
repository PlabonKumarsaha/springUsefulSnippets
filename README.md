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
