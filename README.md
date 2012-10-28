activemq-test
=============

Test bed for playing with activemq and making dev env broker setup / sharing as seamless as possible in a team environment. 



* A activemq 5.6 version of the maven broker plugin example provided in the amq doco -> http://activemq.apache.org/maven2-activemq-broker-plugin.html.

    > mvn activemq:run
    
This will start a broker on port '61616' using the configuration file in ./src/test/resources and an admin web console at http://localhost:8161/admin 
