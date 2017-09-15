API Local: http://localhost:8080/FmaTransaccional2
API Prod: http://167.114.152.77:8090/FmaTransaccional

When start check on http://localhost:8080/FmaTransaccional2   
When start prod check on http://167.114.152.77:8090/FmaTransaccional/ordenes

Mapping ordenes
http://localhost:8080/FmaTransaccional2/ordenes
http://localhost:8080/FmaTransaccional2/reporteordenes

http://localhost:8080/manager

Ordenes
-Inserting ok



Deploy on server

0. Change api_service on angular service to prod
1. Change parameters on dbutility for db connection
2. Build a maven and make sure is build succesful 
3. Export war to C:\Servers\apacheTomcat8\webapps\FmaTransaccional.war (Can also check the war on Building war: C:\Users\Usuario\workspace-smvc\FmaTransaccional\target\FmaTransaccional.war) 
4. Load war from previous site to /usr/local/apache-tomcat-8.0.36/webapps on server replacing previous war
5. shutdown and startup tomcat 

