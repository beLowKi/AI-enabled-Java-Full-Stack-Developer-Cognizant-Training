
- [[Environment, Java Basics & Types]]

## Features of Java

- Object-Oriented Programming
- Portable
	- Java is compiled into bytecode which can be shared an run on any machine with a JVM (which is not portable)
- Platform Independent
	- Any system that can run a JVM (Java virtual machine) can run Java
- Robust (effective memory management)
	- Automatically allocates memory as needed
	- Garbage collection of memory that's no longer in use
- [[Multi-Threading]]
- Distributed
	- Program files/functionality can be split across multiple machines
	- The gaps can be bridged by API use over HTTP(S), for example
- Interpreted + Compiled
	- Code is compiled (javac from JDK) into bytecode
	- java bytecode is interpreted by JIT (Just In-Time) interpreter inside JVM
- Dynamic
	- Gets class details at runtime
- Architectural Neutral
	- Not dependent on machine's architecture (x86, x86_64, etc.)

## Layers of Java

| Name | Purpose                                                                                                                                     |
| ---- | ------------------------------------------------------------------------------------------------------------------------------------------- |
| JDK  | Java Development Kit; tools like javac, java, and javadoc for building apps                                                                 |
| JRE  | Java Runtime Environment that runs apps and contains libraries                                                                              |
| JVM  | Java virtual machine in charge of interpreting java bytecode: loading classes, garbage collection, runtime data areas, and execution engine |
