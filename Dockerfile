# Tomcat 9 이미지 사용
FROM tomcat:9.0

# 기존 ROOT 앱 제거
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# 빌드된 war 파일을 Tomcat에 복사
COPY target/my-spring-app.war /usr/local/tomcat/webapps/ROOT.war
