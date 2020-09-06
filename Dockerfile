FROM centos:7                                
LABEL "purpose"="practice"                         
RUN yum update                                  
RUN yum install -y httpd                     
WORKDIR /var/www/html                              
RUN ["/bin/bash", "-c", "echo hello >> test2.html"]  
EXPOSE 80                                           
CMD apachectl -DFOREGROUND                         
