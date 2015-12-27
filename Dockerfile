FROM registry.example.com:5000/daniel/jboss-eap-6.4
USER root
MAINTAINER zhanwang@redhat.com

ADD ./target/shopping.war /opt/jboss-eap-6.4/standalone/deployments/shopping.war

EXPOSE 8080

ENTRYPOINT [ "/opt/jboss-eap-6.4/bin/start.sh" ]

