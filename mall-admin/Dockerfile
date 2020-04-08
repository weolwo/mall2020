FROM java:8
EXPOSE 8888

VOLUME /tmp
ADD mall-admin.jar  /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
