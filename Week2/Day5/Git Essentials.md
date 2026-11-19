
Git is a free, open-source distributed version control system that records file changes so people can review history, undo mistakes, and work together across multiple machines. ***NOTE*** GitHub is just a web interface for Git, they're not the same thing.

- Distributed: every dev has full repository and its history, so most work can happen offline
- Snapshots: Commits take a "snapshot" of the project's state

## What Git Can Do

- Audit trail: records changes, who made them, when, and why
- Risk reduction: roll back a bad release quickly
- Team productivity: multiple devs can work in parallel without overwriting each other
- Faster delivery: branching and CD/CD (automated testing and deployment)
- Quality control: pull requests and code review
- Accountability: every change is tied to a person and a reason
- Business continuity: every clone is a full backup, so there is no single point of failure
- Intellectual property: code stays "protected" in a single place
- Access control: permissions on who can read, change, or approve code can be set
- Release management: tags mark exactly which version is live
- Lower cost of bugs: finding which commit caused a bug cuts debugging time
- Onboarding: new hires/contributors can read the full project history
- Remote and global teams: being distributed, people can collaborate anywhere, anytime


## Git Workflow

|       Area        | Description                                                                        |
| :---------------: | ---------------------------------------------------------------------------------- |
| Working directory | A local folder on a machine containing the project's files                         |
|   Staging area    | Files flagged for next commit using "git add" command                              |
| Local repository  | Commit history on your machine                                                     |
| Remote repository | The shared repository that other machines (with permission) can push and pull from |

## Important Terms

| Term              | Definition                                                                                                                                                                                                                                                                                        |
| ----------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Repository        | Project folder; all files plus the full history of changes                                                                                                                                                                                                                                        |
| Branch            | A version of the repo that diverges from the main line.                                                                                                                                                                                                                                           |
| Checkout          | Refers to switching between different versions of a target entity. Commonly used when switching between branches of a repository.                                                                                                                                                                 |
| Cherry-Picking    | Means to apply a commit from one branch to another. Can be used in cases like accidentally committing to wrong branch and wanting to revert and retarget just that commit instead of merging the whole branch                                                                                     |
| Clone             | The copying of a repository--often remote to local.                                                                                                                                                                                                                                               |
| Fetch             | Used to get the branches and tags from one or more other repos along with the objects necessary to complete their histories. Updates remote-tracking branches                                                                                                                                     |
| HEAD              | Represents the last commit in the current checkout branch.                                                                                                                                                                                                                                        |
| Index             | The staging area between working directory and local repo. Builds the set of changes to be committed together                                                                                                                                                                                     |
| master/main       | Naming conventions for the default branch of a repo                                                                                                                                                                                                                                               |
| Merge             | Brings forked history together, combining the changes made by both                                                                                                                                                                                                                                |
| Origin            | Refers to a remote repo's URL                                                                                                                                                                                                                                                                     |
| Pull/Pull Request | Means to receive data from GitHub. "git pull ..." can be used to copy from a remote repo into a local one.<br><br>A pull request on GitHub is a way for developers to notify each other when one branch is complete and they'd like to merge it into the main branch.                             |
| Push              | Means to upload from local repo to remote.                                                                                                                                                                                                                                                        |
| Rebase            | Means to move or combine a sequence of commits to a new base commit.                                                                                                                                                                                                                              |
| Tags              | A way to mark certain points in a repo's history as important; e.g., release points (v1.0, v2.0)                                                                                                                                                                                                  |
| Upstream          | The direction of the origin; i.e., where a repo was cloned. Refers to where the project's history is coming from.                                                                                                                                                                                 |
| Downstream        | The direction of future modifications to the repo.                                                                                                                                                                                                                                                |
| Revert            | Means to reverse a commit. "git revert" is the command used                                                                                                                                                                                                                                       |
| Reset             | Used to undo certain changes to local repo, index, and/or working directory based on 3 main forms:<br><br>- Soft           working directory and index aren't affected<br>- Mixed        working directory unchanged <br>- Hard          all files and directories; may overwrite untracked files |
| Ignore            | Means to flag an item that git will not stage or index. This is done through a ".gitignore" file                                                                                                                                                                                                  |
