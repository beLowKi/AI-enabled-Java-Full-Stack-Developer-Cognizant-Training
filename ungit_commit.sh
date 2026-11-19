#!/bin/bash
readonly commit_msg="$1"

if [ -z $commit_msg ]; then
	echo "Missing commit message" >&2
	exit 1
fi

# Restores all nested git folders
restore(){
	echo "Re-git-ing folders"
	find . -mindepth 2 -name .git.bak -prune -exec sh -c 'mv "$1" "$(dirname "$1")/.git"' _ {} \;
}
trap restore EXIT

# Renames all .git folders (aside from root one) to an ignore name
# so its directory's files can be added as normal
echo "Un-git-ing folders"
find . -mindepth 2 -name .git -prune -exec sh -c 'mv "$1" "$(dirname "$1")/.git.bak"' _ {} \;

# Performs commit
# .git.bak/ is in .gitignore, but, just in case, 
# an excluding pattern is used
git add . ':!**/.git.bak'
git commit -m "$commit_msg"

# Undoes the name change so git folders can be used as normal
restore
