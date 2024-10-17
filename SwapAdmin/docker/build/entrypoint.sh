#!/bin/sh
# Running setup for SwapMonitor
echo "***Running setup for SwapMonitor ***"  


# Start Spring boot using the profile DEV
if [ -z "$SPRING_PROFILES_ACTIVE" ]; then
	echo "Setting SPRING_PROFILES_ACTIVE=dev, you can overwrite this by setting it in ENV"
	export SPRING_PROFILES_ACTIVE=dev
fi
	

echo "*** Running the app ***"

java -jar app.jar
unset
