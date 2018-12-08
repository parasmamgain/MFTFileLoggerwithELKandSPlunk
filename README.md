# IBM MQ Managed File Transfer Standalone Logger with Elastic Search and Kibana

This Repository contains the code for an Java application which reads the files generated by the IBM MQ Managed File transfer Stand Alone File Logger.These Logger files are then parsed and its content is processed after which the information of transfers is stored in the Elastic Search Index. This Data can be accessed using Elastic search Queries or can be visualized using the Kibana Dashboard(ELK).

## Pre-Requisites

Following are the softwares/tools that must be installed/configured with the machine where this application will be executed.

1. Java 1.8 or above.<br>
- Download and Install Java 1.8 or above <br>
2. Elastic Search 5.0.1.<br>
- Download ,Install and Start Elastic Search (https://www.elastic.co/downloads/past-releases/elasticsearch-5-0-1)<br>
3. Kibana 5.0.1:<br>
- Dowmload ,Install and Start Kibana (https://www.elastic.co/downloads/past-releases/kibana-5-0-1) <br>

## General Instructions
following are the steps that could be followed to run this application.<br>

1. Download the files/folders mentioned below in a same folder(/lib,/mft-ELK-toolkit 0.0.1.jar ,/configuration.properties).
2. MQ-MFT-with-ELK/target/lib - contains all the necessary jars required to run the mft-ELK-toolkit-0.0.1.jar file.
3. MQ-MFT-with-ELK/mft-ELK-toolkit-0.0.1.jar - is the jar file which performs operation of reading standalone file logger and pushing its data to the Elastic Search Index.
4. MQ-MFT-with-ELK/configuration.properties - contains various properties having default values but these can be modified as per the use.
5. MQ-MFT-with-ELK/out.txt - this file gets generated whenever the jar file is executed. This stored the logging information like errors/information etc about the application.

#### Command : java -jar `<application Name>` `property filename`
e.g. - `java -jar mft-ELK-toolkit-0.0.1.jar configuration.properties`

##### configuration.properties: <br>
This files consists of 6 properties .The property name should not be changed however the property values can be reassigned as per the requirement.
```
HOSTNAME=localhost
PORTNUMBER=9300
INDEXNAME=mftindex
SOURCEPATH=D:\\elasticDocs
CLUSTERNAME=elasticsearch
DAYSINTERVAL=0
```
Above are the default values of the keys in configuration.properties file.
1. HOSTNAME: Hostname where the elastic serch server is running.
2. PORTNUMBER: Port to bind to for incoming HTTP requests. Accepts a single value.
3. INDEXNAME: the name of the Elastic Search index where this records will be stored.
4. SOURCEPATH: the source location where the MFT stand alone file logger stores the files or the location where the MFT stand alone file logger files are present.
5. CLUSTERNAME: A node can only join a cluster when it shares its cluster.name with all the other nodes in the cluster. The default name is `elasticsearch `.
6. DAYSINTERVAL: This parameter accepts an integer value only which enables the application to make sure that older files are not processed again.
<br>e.g.- if `DAYSINTERVAL=2` then files which were modified in the last 2 days will ony be processed and rest files will be ignored.
## Development Specific Instructions

1. Download and configure eclipse.
2.  Install the maven plugin from Eclipse Marketplace
3.   Download the zip file of the project from the repository `MQ-MFT-with-ELK`.
4.    Import the zip file as a project in your workspace.

## Additional Information <br>
This Java application can be used as Windows service or as a Cron Job which can be scheduled for a particular time every day.
1) Using Operating System Scheduler

- for Linux, you can use Cron Jobs to schedule your program

- for Windows, check the windows scheduler

2) using java.

- you can use java.util.Timer class to schedule a TimerTask object.
- make a separte thread for timertask and schedule it with Timer.schedule(TimerTask timertask, Datetime) 
