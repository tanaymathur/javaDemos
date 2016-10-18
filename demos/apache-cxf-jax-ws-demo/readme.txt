#######################################
# JAX-WS Web Services with Apache CXF #
#######################################

# 1 - Overview #
In the fourth module, we will be focusing on a typical scenario for CXF. The decision has been made to build a new web service for your customer integration. Given the complexity of the service and requirements of the customer, JAX-WS was selected as the front-end and CXF was chosen to be the web service framework. As the developer, you are responsible for construction, but have not used CXF before. How do you go about ensuring a successful delivery? The goal of this module is to show you a common path for delivering web services in this scenario. CXF is a highly flexible web services framework that fully supports the contract-first approach to web service development. As the name implies, contract-first means you design and develop the web service contract, or WSDL, and XML Schema, or XSD, before coding the business logic. Through the demonstration, you will see the steps in constructing a contract-first provider web service, progressing from development of the WSDL and schema to the development of the service logic. It is recommended to have Eclipse open for this module and to have setup the project from module 2.
 

# 2 - Operating System #
While this course strives to be OS-agnostic, I chose Windows due to personal restrictions. 
If you require help with getting demonstrations to work in Linux, please feel free to post 
comments on the Pluralsight course page and I will do my best to respond to them.  

# 3 - Java #
For this course, I used JDK 1.7.0_45 as my Java runtime because it is the version recommended 
by the Apache CXF team. While CXF can run with JDK 1.6.x, you will need to follow the 
instructions provided for incorporating the JAXB reference implementation:

http://cxf.apache.org/faq.html#FAQ-CanCXFrunwithJDK1.6?

Please note, JDK 1.5 is no longer supported by Apache CXF as of CXF version 2.7.x. 

As this course assumes intermediate Java knowledge, I have not provided installation 
instructions for the JDK. If you require installation steps, please follow the instructions 
provided by Oracle. 

# 4 - Apache Maven #
In this course, I use Apache Maven version 3.1.1 to manage my CXF projects. While it is not 
required to use Maven for implementing Apache CXF projects, it is the recommended approach. To 
install Apache Maven, please follow these steps:

1.) Open a browser and navigate to the URL: http://maven.apache.org/download.cgi
2.) Click the Binary Zip File link to download the latest stable version (3.1.1 for this course). 
3.) Unzip the file to your preferred directory. In my demonstration, I will unzip it to the path 
dev on my root C drive folder. 
4.) Add the directory C:\dev\apache-maven-3.1.1\bin to your PATH environment variable. 
5.) Add a new environment variable M2_HOME and set the value to C:\dev\apache-maven-3.1.1.
5.) Close any command prompt windows you have open. Open a new command prompt window. 
6.) Run the command: mvn --version
7.) Verify the version information, which should be similar to the following:
	Apache Maven 3.1.1 (0728685237757ffbf44136acec0402957f723d9a; 2013-09-17 10:22:22-0500)
	Maven home: C:\dev\apache-maven-3.1.1
	Java version: 1.7.0_45, vendor: Oracle Corporation
	Java home: C:\java\jdk1.7.0_45\jre
	Default locale: en_US, platform encoding: Cp1252

If you are unfamiliar with Maven, I recommend to view the existing Maven course on Pluralsight. 

# 5 - Apache Tomcat #
In this course, I use Apache Tomcat version 7.0.12. Here are the steps to follow for installation:

1.) Open a browser and navigate to the URL: http://tomcat.apache.org/download-70.cgi
2.) Click the zip file link to download the core binary distribution.
3.) Unzip the file to your preferred directory. Currently, I unzip Tomcat to a folder named dev in 
my root C drive folder.

# 6 - IDE #
I have used Eclipse for the demonstrations in this course due to my familiarity and comfort with the 
product. I am not aware of any restrictions or issues with developing Apache CXF projects on 
specific IDEs. The version used in this course is Eclipse IDE for Java EE Developers 4.3.1 (Kepler). 
Here are some steps to help you match the IDE environment for the demonstrations:

1.) Open a browser and navigate to the URL: http://www.eclipse.org/downloads/
2.) Click the zip file for Eclipse IDE for Java EE Developers to download. 
3.) Unzip the file to your preferred directory. Currently, I unzip Eclipse to my root C drive folder.
4.) Open Eclipse and click Windows -> Preferences.
	- In General -> Appearance, I use the Classic theme.
	- In General -> Appearance -> Label Decorations, I check Java Type Indicator
	- In General -> Web Browser, I check the Use external web browser option and check Firefox
	- In Java -> Compiler, I select 1.7 for the Compiler compliance level.
	- In Java -> Installed JREs, I set-up and selected the default as JDK 1.7.
	- In Java -> Installed JREs -> Execution Environment, I check the JDK 1.7 option for JavaSE-1.7 
		execution.
	- Under Maven -> Installations, I added the 3.1.1 Maven external directory and checked it as the 
		default version.
	- Under Server -> Runtime Environments, add the Apache Tomcat 7 server you installed as part of this 
		readme.

# 8 - Apache CXF #
At the time of creating this course, Apache CXF version 2.7.8 was the latest release available. It should 
be noted that version 3.0 is currently in development and will contain a significant number of changes, 
but few which may impact material in this course. Please check the Pluralsight course page for updates. 

# 9 - Links and Commands #
During the demonstrations, several links and commands will be referenced. I have noted them here.

1.) Generating a Maven Archetype CXF project: 
mvn archetype:generate -Dfilter=org.apache.cxf.archetype:
2.) The HelloWorld WSDL link:
http://localhost:8080/apache-cxf-jax-ws-demo/HelloWorld?wsdl