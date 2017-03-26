Java Spring Boot oriented application.  
This application is meant to perform simple access to dynamically created database, with webservice and client front end functionality.  
There are 2 applications that works together with this one: https://github.com/sephriot/PasswordCrackerClient  
Base functionality - server as data center for silly brute force password cracking apps.  
To perform true password cracking like SHA1, RSA or other algorithms there has to be implemented methods for cracker and for data center as well.  
As for now it serves as test application and uses to crack MD5 hashes.  

Compilation:
  1. Install Apache Maven
  2. Install JDK 1.8 or higher
  3. Use Apache Maven to compile project

Deployment:
  1. Install Apache Tomcat 8 or higher
  2. Install MySQL server
  3. Provide credentials to MySQL server to application.properties
  4. Compile application
  5. Run compiled project with "java -jar <path to compiled jar e.g. target/WebApp-1.0>"
