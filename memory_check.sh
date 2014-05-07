#!/bin/bash
usage()
{
cat << EOF
usage: $0 options

-c <string> - comunity
-w <num> - memory usage warning percent
-x <num> - memory usage critical percent
-W <num> - swap usage warning percent
-C <num> - swap usage critical percent
EOF
}
COMMUNITY=
MEMWARNING=
MEMCRITICAL=
SWAPWARNING=
SWAPCRITICAL=
HOST=
while getopts "c:w:x:W:C:hH:" OPTION
do
	case $OPTION in
		w)
			MEMWARNING=$OPTARG
			;;	
		x)
			MEMCRITICAL=$OPTARG
			;;
		W)
			SWAPWARNING=$OPTARG
			;;
		C)
			SWAPCRITICAL=$OPTARG
			;;
		c)
			COMMUNITY=$OPTARG
			;;
		H)
			HOST=$OPTARG
			;;
		h)
			usage
			exit
			;;
	esac
done
if [[ -z $COMMUNITY ]] || [[ -z $MEMWARNING ]] || [[ -z $MEMCRITICAL ]] || [[ -z $SWAPWARNING ]] || [[ -z $SWAPCRITICAL ]] || [[ -z $HOST ]]
then
	usage
	exit 1
fi
OPTS="-v 2c -O vUq -c $COMMUNITY"
TOTALMEM=$(snmpget $OPTS $HOST 1.3.6.1.4.1.2021.4.5.0)
FREEMEM=$(snmpget $OPTS $HOST 1.3.6.1.4.1.2021.4.6.0)
CACHEMEM=$(snmpget $OPTS $HOST 1.3.6.1.4.1.2021.4.15.0)
BUFMEM=$(snmpget $OPTS $HOST 1.3.6.1.4.1.2021.4.14.0)
TOTALSWAP=$(snmpget $OPTS $HOST 1.3.6.1.4.1.2021.4.3.0)
FREESWAP=$(snmpget $OPTS $HOST 1.3.6.1.4.1.2021.4.4.0)
USED2=$(( $TOTALMEM - $FREEMEM - $CACHEMEM - $BUFMEM ))
USED3=$(( $TOTALSWAP - $FREESWAP ))

MEMF=$((100 * $USED2 / $TOTALMEM))
SWAPF=$((100 * $USED3 / $TOTALSWAP))

RESULT=OK
if [[ $MEMF -ge $MEMWARNING ]] || [[ $SWAPF -ge $SWAPWARNING ]]
then
	RESULT=WARNING
fi
if [[ $MEMF -ge $MEMCRITICAL ]] || [[ $SWAPF -ge $SWAPCRITICAL ]]
then
	RESULT=CRITICAL
fi
echo $RESULT "Memory: " $USED2 / $TOTALMEM "kB, Swap: " $USED3 / $TOTALSWAP "kb"
