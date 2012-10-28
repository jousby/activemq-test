activemq-testbed
================

Test bed for playing with activemq and making dev env broker setup / sharing as seamless as possible in a team environment. 

***
The broker module
=================

A activemq 5.6 version of the maven broker plugin example provided in the amq doco -> http://activemq.apache.org/maven2-activemq-broker-plugin.html.

To spin up the broker:

1. Edit the following properties in the broker/pom.xml file to match your environment.

    <!-- 
      These need to match your own env, can be overridden on the cmd line. 
      You only need these two if you want to run the admin webapp.
    -->
    <activemq.home.dir>C:\dev\java\servers\apache-activemq-5.6.0</activemq.home.dir>
    <java.version>1.7.0_07</java.version>

2. Run the following maven command to stat the broker

    > mvn activemq:run
    
This will start a broker on port '61616' using the configuration file ./src/test/resources/activemq.xml and an admin web console at http://localhost:8161/admin 
