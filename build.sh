if [ -d "./bin" ]; then
  rm -r ./bin
fi
mkdir ./bin
find ./src -name "*.java" | sed '/\.\/src\/test.*/d' > sources.txt
javac -classpath ./src -d ./bin @./sources.txt
rm ./sources.txt
cp -r ./resources/. ./bin
if [ -d "./deploy" ]; then
  rm -r ./deploy
fi
mkdir ./deploy
jar cfm deploy/risiko-client.jar ./manifest-client.txt -C ./bin client -C ./bin comune -C ./bin utilita
jar cfm deploy/risiko-server.jar ./manifest-server.txt -C ./bin server -C ./bin comune -C ./bin utilita
