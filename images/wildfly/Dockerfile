# Modified by Monzione Marco and Baehler Simon.

FROM jboss/wildfly:10.1.0.Final

ADD packages/AMT-Projet-web.war /opt/jboss/wildfly/standalone/deployments/

COPY data/standalone.xml /opt/jboss/wildfly/standalone/configuration/
COPY data/mysql-connector-java-5.1.40-bin.jar /opt/jboss/wildfly/standalone/deployments/


MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch>
MAINTAINER Olivier Liechti <olivier.liechti@heig-vd.ch

RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

