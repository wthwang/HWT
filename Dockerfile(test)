FROM centos:7                                
LABEL "day09"="day09"                         
RUN yum update                                  
RUN yum -y install httpd; yum clean all; systemctl enable httpd.service                    
WORKDIR /var/www/html
COPY day09/* /var/www/html/
RUN ["/bin/bash", "-c", "echo hello >> test2.html"] 
EXPOSE 80                                                            
