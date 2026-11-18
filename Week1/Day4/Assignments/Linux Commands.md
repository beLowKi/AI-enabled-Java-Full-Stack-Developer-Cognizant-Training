
## Part A: Navigation and Identity

### A1 pwd: Where am I?

#### Q1. What is your current working directory?

"/mnt/e/Coding/Revature/CognizantTraining/Week1/Day4/Assignments/linuxlab"

I'm on Windows using WSL, but I'm outside of the home folder.

#### Q2. Does the path start with / ? What does that mean?

Yes, it means this is an absolute path that's followable from anywhere on my computer.

### A2 cd: Moving between directories

#### Q1. Which directory are you in after cd .. from /etc?

"/"

#### Q2. What does cd - do?

It changes to the last directory you were in.

### A3 ls: Listing files

#### Q1. Which option shows hidden files?

"-a"

#### Q2. In ls -l /etc, pick one file and write its owner, group, and permissions.

-rw-r--r-- 1 root root  sensors3.conf

#### Q3. What does -h do together with -l?

Converts filesizes from bits to "4.4K", "3.5G", and so on

### A4 whoami and id

#### Q1. What is your UID and GID?

My UID and GID are both "malcolm"

#### Q2. What is the UID of root?

0

## Part B: Users and Groups

### B1 Create a user and set a password

#### Q1. Which file stores the account and which stores the encrypted password?

Although every user has a folder under /home, the details of their account are kept in /etc/passwd. Encrypted passwords are kept in /etc/shadow.

#### Q2. What are the home directory and shell of labuser?

Home: /home/labuser
Shell: /home/labuser/.bashrc

### B2 Create a group and add the user

#### Q1. Why is -a important in usermod -aG?

It appends a new group rather than setting it as the user's only group

Q2. Which file lists group details?

/etc/group

### B3 Lock, unlock, and delete

#### Q1. What does the L in the status output mean?

That the user's password is locked

#### Q2. What does -r do in userdel -r?

Also removes home directory and mail spool

## Part C: Permissions and Ownership

### C1 Create a file and read its permissions

#### Q1. What are the default permissions of the file?

rw-r--r--

#### Q2. Who is the owner and which group owns it

"malcolm" and "malcolm" (my username)

### C2 chmod: symbolic mode

#### Q1. How did the permission string change after each command?

After "chmod g-r demo.txt"         -> rw----r--
After "chmod u+x demo.txt"        -> rwx---r--
After "chmode o+rw demo.txt"    -> rwx---rw-

### C3 chmod: numeric mode

#### Q1. What does 644 mean for user, group, and others?

It sets user permissions to read-write, group to read, and other to read

#### Q2. What does 755 mean?

User: read, write, and execute
Group: read and execute
Other: read and execute

#### Q3. Which mode suits a private SSH key?

600

### C4 chown and chgrp

#### Q1. What is the new group ownership?

developers

#### Q4. Who is the new owner of the file?

root

#### Why is sudo needed for chown?

You are potentially taking permissions away from the user that created the file. root is the only user with such control over other users.

### C5 A shared project directory

#### Q1. Who can access this directory now?

The owner, ashu, and members of the developers group

## Part D: File and Directory Management

### D1 mkdir and ls -la

#### Q1. What does -p do?

Ensures an existing directory doesn't cause an error and creates any necessary parent directories

#### Q2. What do "." and ".." represent in ls -la

The directory calling "ls" and its parent

### D2 cp and mv

#### Q1. Does the renamed file have the same contents as file1.txt?

Yes because "cp" copies file contents

#### Q2. What is the difference between cp and mv?

"cp" copies the file, meaning the existing one is unaffected, besides a "last accessed" update, and a new file is made. "mv"  will move the existing file and potentially change its name.

### D3 rmdir and rm

#### Q1. Why did rmdir ~/lab1 fail?

It wasn't empty

#### Q2. Why must you be careful with rm -r?

It will delete a directory and all its contents without any further confirmation

### D4 find and locate

#### Q1. Why does 2/dev/null help?

It excludes "/var/log/private" which non-root users don't have access to.

#### Q2. Why is locate faster than find?

locate uses a database of pre-indexed files rather than searching the machine's filesystem. This reduces I/O and other system calls that slow find down.

## Part E: Viewing Files

### E1 cat, head, and tail

#### Q1. How many lines does head print by default?

10

Q2. Which option of tail follows a growing log file?

-f

### E2 less and more

#### Q1. Which key quits less?

q

#### Q2. Name one advantage of less over more

less opens a separate view while more simply prints. The former prevents confusing the file you're reading from past and future output.

## Part F: Text Processing

### F1 grep

#### Q1. How many lines contain error?

3

#### Q2. What does -v do?

Inverts it so that the lines that DON'T match are returned instead.

### F2 cut and awk

#### Q1. Which people earn more than 4600?

Ravi and Meera

#### Q2. When would you choose awk instead of cut?

When more sophisticated filter logic is required

### F3 sed

#### Q1. Why did the first cat still show foo?

The -i option wasn't being used, so the edit wasn't put into effect.

### F4 sort, uniq, and wc

#### Q1. Why did uniq alone not remove the duplicate Asha?

It only filters adjacent matching lines

#### Q2. How many words are in file1.txt?

50

### F5 Pipes and redirection

#### Q1. What is the difference between > and >>?

\> overwrites while \>\> appends

## Part G: Process Management

### G1 ps and top

#### Q1. What is a PID?

It stands for process ID, and it's a unique number to identify the processes running on a machine.

#### Q2. Which key in top sorts by memory?

Shift+M

### G2 background jobs: jobs, fg, and bg

#### Q1. Difference between a job number and a PID?

A job number refers to a job while a PID refers to a process.

### G3 kill a process

#### Q1. When should you use kill -9?

When you want to stop a process as soon as possible

## Part H: Networking

### H1 ping, netstat, and curl

#### Q1. What does 0% packet loss tell you?

All reply packets were received

#### Q2. What do the letters in -tuln stand for?

t: TCP connections and sockets only
u: Only UDP sockets
l: listening sockets only
n: show numerical addresses instead of symbolic host, port, or user names