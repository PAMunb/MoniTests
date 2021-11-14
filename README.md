# MoniTests

This project aims to apply JavaMop, a Java implementation of Monitoring-Oriented Programming, to verify the correct usage of cryptographic llibraries

## Configuration

   * create a directory to hold the projects

```{shell}
$ mkdir projects
$ cd projects
```

   * clone and build the rv-monitor and java-mop projects
   
```{shell}
$ git clone https://github.com/runtimeverification/rv-monitor.git
$ cd rv-monitor
$ mvn clean package install
$ export PATH=$PATH:./target/release/rv-monitor/bin
$ cd ..

$ git clone https://github.com/runtimeverification/javamop.git
$ cd javamop
$ mvn clean package install
$ cd ..
````

   * clone the maven plugin and build it

```{shell}
$ git clone https://github.com/PAMunb/mop-maven-plugin.git
$ cd mop-maven-plugin
$ mvn compile package install
```

   * setup the classpath

```{shell}
 export CLASSPATH=<ASPECTJ_HOME>/lib/aspectjrt.jar:\
                  <ASPECTJ_HOME>/lib/aspectjtools.jar\
		  <ASPECTJ_HOME>/lib/aspectjweaver.jar\
                  <MAVEN_HOME>/repository/com/runtimeverification/rvmonitor/rv-monitor/1.4-SNAPSHOT/rv-monitor-1.4-SNAPSHOT.jar:\
		  <MAVEN_HOME>/repository/com/runtimeverification/rvmonitor/rv-monitor-rt/1.4-SNAPSHOT/rv-monitor-rt-1.4-SNAPSHOT.jar
		  
````

   * clone the repository and execute the test cases

```{shell}
$ mvn test
```