if [ -d "./bin" ]; then
  rm -r ./bin
fi
mkdir ./bin
find ./src -name "*.java" | sed '/\.\/src\/test.*/d' > sources.txt
javac -classpath ./src -d ./bin @./sources.txt
cp -r ./resources/. ./bin
