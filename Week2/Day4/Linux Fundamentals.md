
Unix operating systems are structed as follows: Application Programs -> Shell -> Kernel -> Hardware

## Application Programs

Outermost Layer: editors, file managers, scripts and tools

## Shell

Interprets commands and passes them to the kernel

## Kernel

Core of the OS; in charge of communicating with hardware: CPU, memory, I/O, and networking

## Hardware

Physical parts: CPU, RAM, disks, keyboard, monitor, etc.


## File System Hierarchy

| Directory Name | Purpose                                    |
| -------------- | ------------------------------------------ |
| /bin           | Binaries; commonly used executable comands |
| /dev           | Device specific files                      |
| /etc           | System configuration files                 |
| /home          | User directories and files                 |
| /lib           | All library files                          |
| /mnt           | Device files of mounted devices            |
| /proc          | Files related to system processes          |
| /root          | Home of the root user                      |
| /sbin          | System binaries (administration commands)  |
| /tmp           | Temporary files; periodically removed      |
| /usr           | Also contains executable commands          |
| /var           | Variable data such as logs (/var/log)      |

Everything is a File in Unix: printers, disks, terminals--all data is treated as a stream of bytes.