## Task 1

1. Create a folder shopeasy, initialize a Git repo, and set your name and email for this repo only.
	1. mkdir shopeasy && cd shopeasy
2. Create README.md ("ShopEasy") and cart.txt ("add item"). Stage only README.md and commit it with the message "Add README".
	1. echo "ShopEasy" > README.md && echo "add item" > cart.txt
	2. git add README.md && git commit -m "Add README"
3. Commit cart.txt separately with the message "Add cart module".
	1. git add cart.txt && git commit -m "Add cart module"
4. Show the history as one line per commit.
	1. git log --oneline --graph --all

## Task 2

1. Edit cart.txt, then discard the change without committing.
	1. echo "To be deleted" >> cart.txt
	2. git restore cart.txt
2. Create secrets.env and debug.log. Make Git ignore all *.log files and secrets.env.
	1. touch secrets.env debug.log
	2. echo "secrets.env\n\*.log" > .gitignore (the \\ before \* is show it's displayed in markdown and not included in command)
3. Edit cart.txt again and stage it by accident, then unstage it without losing the edit.
	1. echo "To be unstaged" >> cart.txt && git add cart.txt
	2. git rm --cached cart.txt
4. You committed with a typo in the message ("Ad payment"). Fix the message of the last commit.
	1. git add . && git commit -m "Ad payment"
	2. git commit --amend "Add payment"

## Task 3

1. Create the branch feature/wishlist and add two commits to it.
	1. git checkout -B feature/wishlist
	2. touch commit1.txt commit2.txt
	3. git add commit1.txt && git commit -m "Commit 1"
	4. git add commit2.txt && git commit -m "Commit 2"
2. Switch back to main and merge the feature (this should fast-forward).
	1. git merge feature/wishlist
3. Create feature/reviews and add a commit on it. Then add a different commit on main so the branches diverge.
	1. git checkout -B feature/reviews
	2. echo "Commit 3" > commit3.txt
	3. git add commit3.txt && git commit -m "Commit 3"
	4. git switch main
	5. echo "Commit 4" > commit4.txt
	6. git add commit4.txt && git commit -m "Commit 4"
4. Merge feature/reviews into main and force a merge commit with --no-ff.
	1. git switch main
	2. git merge --no-ff feature/reviews
5. Delete both merged branches.
	1. git branch -d feature/reviews && git branch -d feature/wishlist

## Task 4

1. On main, set price.txt to Price: 100 and commit.
	1. echo "Price: 100" > price.txt
	2. git add price.txt && git commit -m "Added price"
2. Create feature/discount, change the line to Price: 90 and commit.
	1. git checkout -B feature/discount
	2. echo "Price: 90" > price.txt && git commit -a -m "Updated Price"
3. Back on main, change the same line to Price: 110 and commit.
	1. git switch main
	2. echo "Price: 110" > price.txt && git commit -a -m "Updated Price"
4. Merge feature/discount into main. A conflict appears.
	1. git merge feature/discount
5. Practice 1: abort the merge with git merge --abort.
	1. git merge --abort    
6. Practice 2: redo the merge, resolve it with Price: 95, and complete it.
	1. echo "Price: 95" > price.txt && git commit -a

## Task 5

1. Edit cart.txt without committing.
	1. echo "New item" >> cart.txt
2. Stash the edit with the message "WIP cart".
	1. git stash -m "WIP cart"
3. Create a hotfix/login branch from main, make a fix, commit, and merge it into main.
	1. git checkout -B hotfix/login
	2. echo "FIXED" >> cart.txt && git commit -a -m "Fixed cart"
	3. git switch main && git merge hotfix/login
4. Go back to your branch and restore your stashed work.
	1. git switch hotfix/login && git stash list
	2. git stash apply stash@{0} && git commit -a -m "Unstashed cart"
5. List the stashes to confirm none remain.
	1. git stash list

## Task 6

1. Make 4 commits: A, B, C, D.
	1. echo "Commit A" > A.txt
	2. git add A.txt 
	3. git commit -m "Commit B"
	4. echo "Commit B" > B.txt
	5. git add B.txt 
	6. git commit -m "Commit B"
	7. echo "Commit C" > A.txt
	8. git add C.txt 
	9. git commit -m "Commit C"
	10. echo "Commit D" > D.txt
	11. git add D.txt 
	12. git commit -m "Commit D"
2. Undo commit C without rewriting history, using revert. Explain why this is the right choice on shared branches.
	1. git log (to see commit hash)
	2. git revert {hash of Commit C}

Reverting just the one commit without rewriting the entire history prevents undoing others' work.

3. Create a new commit E, then run reset --soft HEAD~1 and observe the staging area.
	1. echo "Commit E" > E.txt && git add E.txt
	2. git commit -m "Commit E"
	3. git reset --soft HEAD~1
	4. git status
4. Run reset --hard HEAD~2 "by accident", then recover the lost commits with reflog.
	1. git reset --hard HEAD~2
	2. git reflog main@{1} (to get hash of Commit E)
	3. git reset --hard {Commit E hash}

## Task 7

1. Create feature/checkout with 4 messy commits.
	1. git checkout -B feature/checkout
	2. echo "Hello" > hello.c
	3. git add hello.c && git commit -m "WIP hello.c"
	4. echo "#include <stdlib.h>" > hello.c
	5. git commit -a -m "WIP hello.java"
	6. echo -e "\nint main(int argc, char** argv);" >> hello.c
	7. git commit -a -m "WIP hello.java"
	8. echo -e "\n\nvoid print_hello();" >> hello.c
	9. git commit -a -m "WIP hello.c"
2. Meanwhile, add a new commit to main.
	1. git switch main
	2. echo "print('Howdy, World')" >> howdy.py
	3. git add howdy.py && git commit -m "Howdy"
3. Rebase feature/checkout onto the updated main.
	1. git switch feature/checkout
	2. git rebase main
4. Use interactive rebase to squash the 4 commits into one named "Add checkout flow".
	1. git rebase --interactive {hash of commit added in step 3 rebase}
5. Merge into main as a fast-forward.
	1. git switch main && git merge feature/checkout


## Task 8

1. On dev, make 3 commits. Only the second one is a bug fix.
	1. git checkout -B dev
	2. echo "Bugged file" > bug.txt
	3. git add bug.txt && git commit -m "Bug release"
	4. echo "Bug fix" > bug.txt
	5. git commit -a -m "Bug fix"
	6. echo "New feature" > new.txt
	7. git add new.txt && git commit -m "New feature"
2. Cherry-pick just that fix onto main.
	1. git switch main
	2. git cherry-pick dev~0 dev~1       (I included dev~0 because the "bug fix" was to a file introduced in that commit)
3. Create an annotated tag v1.0.0 on main.
	1. git tag "v.1.0.0" main
4. Make one more change and show the diff between v1.0.0 and your working tree.
	1. echo "New file" > newfile.txt
	2. git add newfile.txt && git commit -m "New file"
	3. git diff "v.1.0.0" main
5. List all tags.
	1. git tag -l

## Task 9

1. Add it as origin and push main with upstream tracking.
	1. git remote add origin ../server.git
	2. echo "Hello" > hello.c
	3. git add hello.c && git commit -m "Hello"
	4. git push -u origin main
2. Clone it to a second folder (teammate/), commit a change there, and push it.
	1. git clone server.git teammate && cd teammate
	2. cat > hello.c

~~~C
#include <stdlib.h>

int main(int argc, char** argv) {
        printf("Hello World!");
        return 0;
}
~~~

	3.  git commit -a -m "Completed hello.c"
	4.  git push origin main

4. In your original repo, run fetch and compare main with origin/main. Then pull.
	1. git fetch origin
	2. git diff main
	3. git pull
5. Create a branch, push it, then delete it on the remote.
	1. git checkout -B hotfix/todelete
	2. git push origin hotfix/todelete
	3. git push origin --delete hotfix/todelete

## Task 10

(setup)
- echo "bug" > bug.txt
- git add bug.txt && git commit -m "No bugs here"
- git checkout -B feature/payments
- echo "New file" > newfile.txt

1. You are on feature/payments with uncommitted work when a teammate reports a critical bug on main. Stash, fix it on a hotfix branch, merge it, and tag v1.0.1.
	1. git add newfile.txt
	2. git stash && git checkout -B hotfix
	3. rm bug.txt
	4. git add bug.txt && git commit -m "Bug fix"
	5. git switch main && git merge hotfix "v1.0.1"
	6. git branch -d hotfix
2. Return to your feature branch, restore the stash, and rebase onto the updated main.
	1. git switch feature/payments
	2. git stash apply && git commit -m "New file"
	3. git rebase main
3. A conflict appears during the rebase. Resolve it and continue.
4. Squash your commits, merge into main, and push with tags.
	1. git switch main
	2. git merge feature/payments
5. Someone finds that the last merge broke production. Revert the merge commit safely (hint: -m 1).
	1. git revert -m 1 HEAD

## Bonus questions

1. What is the difference between git fetch and git pull?

pull is fetch + merge; e.g., "git pull origin main" = "git fetch origin/main && git merge".

2. When should you use revert instead of reset?

Use revert when you want to undo the changes made by a specific commit without affecting the rest of your history. 

3. Why is rebase dangerous on shared branches?

It rewrites commit history which can make it difficult for other devs to sync their work

4. What does git reset --hard do to your working directory, and how can reflog help?

It resets the index and working tree to the state of local repo. reflog shows history changes like when branch tips update. It can be used to revert branches to before they were reset.

5. How do you find which commit introduced a bug? (Hint: git bisect.)

You tell git one commit that you know introduced a bug and one commit that you know is "good" (according to the manual). It uses binary search to narrow down when the bug was introduced by repeatedly asking you if commits were good or bad.