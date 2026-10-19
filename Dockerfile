FROM tomcat:11.0.14-jre21

# webapps.dist ships Tomcat's default manager/docs/examples apps; the image's
# own webapps/ dir already excludes them, this just drops the unused copy.
RUN rm -rf /usr/local/tomcat/webapps.dist

COPY ./target/*.war /usr/local/tomcat/webapps/records.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
