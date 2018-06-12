#!/bin/sh

echo "Make bin directory\n";
mkdir -p bin;
cd bin;
bin_path=`echo $PWD`;
cd ../source;
source_path=`echo $PWD`;

echo "Finding javac\n";
javac_find=`find / -name javac 2> /dev/null`;
javac_paths=(${javac_find// / });

echo "PLEASE, IGNORE WARNINGS!";
echo "Trying to call javac";

for i in "${!javac_paths[@]}"
do
	${javac_paths[i]} -d $bin_path $source_path/*.java;
done