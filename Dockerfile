FROM centos:7
RUN yum -y install httpd
ADD entry-point.sh /etc/entry-point.sh
RUN chmod 755 /etc/entry-point.sh
WORKDIR /var/www/html
COPY day09/* /var/www/html/
EXPOSE 80
ENTRYPOINT ["sh","/etc/entry-point.sh"]
