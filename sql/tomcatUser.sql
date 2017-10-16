CREATE USER 'tomcat'@'localhost' IDENTIFIED BY 'tomcat';

GRANT SELECT ON abovecare.* TO 'tomcat'@'localhost';

insert user and user_roles rows
see loadUserUserRoles