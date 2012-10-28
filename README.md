Activemq Testbed
================

Test bed for playing with activemq and making dev env broker setup / sharing as seamless as possible in a team environment. 

***
The broker module
-----------------

An activemq 5.6 version of the maven broker plugin example provided in the amq doco -> http://activemq.apache.org/maven2-activemq-broker-plugin.html.

To spin up the broker:

1. Edit the following properties in the broker/pom.xml file to match your environment.
```
<!-- These are only really needed if you want the admin web console in addition to the broker -->
<activemq.home.dir>C:\dev\java\servers\apache-activemq-5.6.0</activemq.home.dir>
<java.version>1.7.0_07</java.version>
```

2. Run the following maven command to start the broker. This will start a broker on port '61616' using the configuration file ./src/test/resources/activemq.xml and an admin web console at http://localhost:8161/admin 
```
mvn activemq:run

```    

