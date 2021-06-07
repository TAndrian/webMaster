#!/bin/bash

# Téléchargement du runner jetty (https://www.eclipse.org/jetty/documentation/9.4.x/runner.html)
wget -O jetty-runner.jar -c https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-runner/9.4.27.v20200227/jetty-runner-9.4.27.v20200227.jar

# Compilation du war dans target
mvn package

# Lancement du projet (à adapter si le jar change)
java -jar jetty-runner.jar target/pr.tp.web-0.0.1-SNAPSHOT.war