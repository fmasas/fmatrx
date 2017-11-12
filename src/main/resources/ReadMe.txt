API Local: http://localhost:8080/FmaTransaccional2
API Prod: http://167.114.152.77:8090/FmaTransaccional

When start check on http://localhost:8080/FmaTransaccional2
or    
http://localhost:8085/FmaTransaccional2
When start prod check on http://167.114.152.77:8090/FmaTransaccional/ordenes

Mapping ordenes
http://localhost:8080/FmaTransaccional2/ordenes
or
http://localhost:8085/FmaTransaccional2/ordenes
http://localhost:8080/FmaTransaccional2/reporteordenes

http://localhost:8080/manager

Ordenes
-Inserting ok



Deploy on server

0. Change api_service on angular service to prod
1. Change parameters on dbutility for db connection
2. Build a maven and make sure is build succesful (clean install)
3. Export war to C:\Servers\apacheTomcat8\webapps\FmaTransaccional.war (Can also check the war on Building war: C:\Users\Usuario\workspace-smvc\FmaTransaccional\target\FmaTransaccional.war)  
4. Load war from previous site to /usr/local/apache-tomcat-8.0.36/webapps on server replacing previous war
5. shutdown and startup tomcat 

To run http://localhost:8080/people/ service 

1. Open on cmd C:\Users\Usuario\Documents\workspace-sts\gs-accessing-mongodb-data-rest-initial\target 
2. Execute C:\Program Files\MongoDB\Server\3.0\bin>mongod.exe --dbpath e:\MongoDB\mongodb\data
3. run java -jar gs-accessing-mongodb-data-rest-0.1.0.jar
4. Check http://localhost:8080/people/



--Run mongo on vps 
service mongod start
sudo service mongod stop
sudo service mongod restart

--Run mongo local 

cd C:\Program Files\MongoDB\Server\3.0\bin
mongod --dbpath E:\MongoDB\mongodb\data

--Rename the war to apiclient.war 
--Copy the war to /usr/local/apache-tomcat-8.0.36/webapps 



Resources 

https://stormpath.com/blog/tutorial-spring-boot-war-files

