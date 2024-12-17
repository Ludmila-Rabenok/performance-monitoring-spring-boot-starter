1. Клонировать проект.
2. Task- **publishToMavenLocal**
3. В Spring-Boot-Web проекте подтянуть зависимость:  

   **implementation 'ru.clevertec:performance-monitoring-spring-boot-starter:0.0.1'**
4. не забыть добавить *mavenLocal()* 
5. Добавить в *application.properties*:  

   **performance-monitoring.enabled=true**  

   **performance-monitoring.time=100**
6. Над нужными методами поставить *@MonitorPerformance*
