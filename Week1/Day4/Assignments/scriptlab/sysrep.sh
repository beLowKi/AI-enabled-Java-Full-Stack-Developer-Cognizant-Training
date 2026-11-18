#!/bin/bash
clear

echo "=============== System Report ==============="
echo "User		: $(whoami)"
echo "Host		: $(hostname)"
echo "Date		: $(date '+%F %T')"
echo "Uptime		: $(uptime -p)"
echo "Disk used	: $(df -h / | awk 'NR==2{print $5}')"
echo "Logged in	: $(who | wc -l) users(s)"
