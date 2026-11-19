#!/bin/bash
read -p "Choice (start|stop|status): " ch

case $ch in
	start)	echo "Starting service..." ;;
	stop)	echo "Stopping service..." ;;
	status)	echo "Service is running" ;;
	*)	echo "Invalid option" ;;
esac
