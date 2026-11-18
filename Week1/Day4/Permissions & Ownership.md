
- Every file has an owner (user)
- Owner: usually the creator
- Group: users who share access

## Permission Types

- Read (r): view a file / list a directory
- Write (w): modify a file / add or remove files
- Execute (x): run a file / enter a directory

## Permission Levels

- User (u): owner of file
- Group (g): Users in the file's group
- Other (o): Everyone else

Often shown as rwx where, when missing a permission, it's replaced with '-'; e.g., having read and execute permissions but not write would be shown as r-x.

example ls -l output shows User -> Group -> Other permissions. For example:

-rw-r--rw- 

('-' suffix means that it is a file) means User (owner of file) has read (r) and write (w) permissions but not execute, Group have read permissions, and everyone else can read and write the file.
## Relevant Commands


| Command | Description                                    |
| ------- | ---------------------------------------------- |
| chmod   | Change permissions of file or directory        |
| chown   | Change owner of a file or directory            |
| chgrp   | Change the group that owns a file or directory |
