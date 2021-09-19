1. The main class will extend SpringBootServletInitializer

2. Ovveride the method 

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(EmpApplication.class);
	}

3. add tomcat dependency
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>

4. add the packaing type form jar to war	

<packaging>war</packaging>

5. Change war filr name in build from POM (optional)

		<finalName>emp-web app</finalName>

6. Then maven build the project (used STS)

7. Now copy the generted WAR file from target folder to tomcat's webapps

8. now in the bin folder of tomcat .. click on the startup to deploy the war file

9. Now first check if the tomcat is running by checking the port

10. Now use the link like the following

http://localhost:8088/emp-web%20app/api/v1/emp

Here, after 8088/ it is the application name then to the URL

Alterantely PC ip can also be used http://172.**.***.1:8088/emp-web%20app/api/v1/emp 

