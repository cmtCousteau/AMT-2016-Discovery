FROM jboss/wildfly:10.1.0.Final

ADD LandingPageMVCApp-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

