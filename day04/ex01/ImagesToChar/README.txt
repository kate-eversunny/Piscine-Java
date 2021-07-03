HOW TO COMPILE AND LAUNCH IMAGESTOCHAR PROJECT:

1. Open a preferable terminal and get to the project root.
2. Make sure that you are in the project root directory ImagesToChar.

3. Copy&paste the following line to the terminal and press Enter

javac -d target src/java/edu/school21/printer/logic/BmpHandler.java \
&& javac -cp target/ -d target src/java/edu/school21/printer/app/Program.java \
&& cp -r src/resources target  \
&& jar cfm target/images-to-char-printer.jar src/manifest.txt -C target .

4. To test launching program without argumets copy&paste the following line to the terminal and press Enter

java -jar target/images-to-char-printer.jar

5. To test launching program with argumets copy&paste the following line to the terminal, make sure that filePath is correct and press Enter

java -jar target/images-to-char-printer.jar --white=. --black=0

6. To remove class files and archive copy&paste the following line to the terminal and press Enter

rm -rf target