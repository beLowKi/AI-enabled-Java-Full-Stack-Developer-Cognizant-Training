
Full name Apache Maven--It's a build tool for Java. It helps simplify the build process for projects with multiple files and dependencies. A larger project could have 1000+ jars that need to be loaded, bundled, and checked to ensure their versions were compatible.

Gradle and ANT are 2 other popular build tools.

## pom.xml

This is the configuration file for Maven projects. POM stands for Project Object model, and it defines project info, java version, dependencies, plugins, build configurations, and packaging types. These are all defined using tags since it's an XML files; e.g., \<version\>3.2.12\</version\>. 

## Build Lifecylce

1. Validate: Checks that project has correct directory structure
2. Compile: Compile Java source code
3. Test: Execute unit tests
4. Package: Create JAR/WAR file
5. Verify: 
6. Install
7. Deploy