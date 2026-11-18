
## Users

- Every person who logs in and has an account
- Identified by username and UID (user ID)
- Has a folder in /home and a shell

### Types of User

- Root (UID: 0) full access, the superuser
- Normal users; limited to their own files
- System users; run services (daemon, mysql, etc.)

## Groups

- A collection of users, identified by GID (group ID)
- Lets you manage the permissions of multiple users at once

## Important Files

- /etc/passwd: user account information
- /etc/shadow: encrypted passwords
- /etc/group: group details

## Relevant Commands


| Command  | Description                                                                    |
| -------- | ------------------------------------------------------------------------------ |
| adduser  | Creates a new user                                                             |
| addgroup | Creates a new group                                                            |
| passwd   | Changes a user's password                                                      |
| useradd  | Low-level utility for adding users                                             |
| usermod  | Modify an existing user account: groups, shell, home directory, username, etc. |
| groupadd | Low-level utility for creating group                                           |
| deluser  | Deletes a user (described as "friendlier" version of userdel)                  |
| delgroup | Deletes a group (described as "friendlier" version of groupdel)                |
| userdel  | Low-level utility for removing user                                            |
| groupdel | Low-level utility for removing group                                           |
| groups   | Show all groups a user belongs to                                              |
