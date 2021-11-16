#!/bin/bash

export CLASSPATH="$AspectJ_HOME/lib/aspectjrt.jar":"$AspectJ_HOME/lib/aspectjtools.jar":"$AspectJ_HOME/lib/aspectjweaver.jar":"$MAVEN_HOME/repository/com/runtimeverification/rvmonitor/rv-monitor/1.4-SNAPSHOT/rv-monitor-1.4-SNAPSHOT.jar":"$MAVEN_HOME/repository/com/runtimeverification/rvmonitor/rv-monitor-rt/1.4-SNAPSHOT/rv-monitor-rt-1.4-SNAPSHOT.jar":./target/classes:$CLASSPATH
rm ~/programs/MoniTests/src/main/java/mop/*
mvn test
