#!/bin/sh 
UAVPATH=/opt
cd $UAVPATH/uav/uavagent/bin/ 
nohup  /bin/sh $UAVPATH/uav/uavagent/bin/run4k8s.sh ma_pro MonitorAgent 0 $JAVA_HOME &