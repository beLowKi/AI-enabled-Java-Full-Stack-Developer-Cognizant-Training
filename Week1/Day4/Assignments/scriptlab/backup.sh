#!/bin/bash
src="$HOME/lab1"
dest="/tmp/backup_$(date +%Y%m%d)"

if [ ! -d "$src" ]; then
	echo "Source folder not found!"
	exit 1
fi

mkdir -p "$dest"
cp -r "$src"/. "$dest"
echo "Backup done: $dest"
