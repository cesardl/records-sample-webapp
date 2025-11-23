FROM tomcat:11.0.14-jre21

COPY ./target/*.war /usr/local/tomcat/webapps/records.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
