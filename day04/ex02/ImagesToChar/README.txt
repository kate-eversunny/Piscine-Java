HOW TO COMPILE AND LAUNCH IMAGESTOCHAR PROJECT:

1. Open a preferable terminal and get to the project root.
2. Make sure that you are in the project root directory ImagesToChar.

3. Copy&paste the following line to the terminal and press Enter


mkdir lib && curl -o lib/JCommander.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.81/jcommander-1.81.jar \
&& curl -o lib/JColor.jar https://repo1.maven.org/maven2/com/diogonunes/JColor/5.0.1/JColor-5.0.1.jar \
&& mkdir target && cd target && jar xf ../lib/JCommander.jar com && jar xf ../lib/JColor.jar com && cd .. \
&& javac -cp target -d target src/java/edu/school21/printer/logic/BmpHandler.java \
&& javac -cp target/ -d target src/java/edu/school21/printer/app/Program.java \
&& cp -r src/resources target  \
&& jar cfm target/images-to-char-printer.jar src/manifest.txt -C target .

4. To test launching program without argumets copy&paste the following line to the terminal and press Enter

java -jar target/images-to-char-printer.jar

5. To test launching program with argumets copy&paste the following line to the terminal, make sure that filePath is correct and press Enter

java -jar target/images-to-char-printer.jar --white=GREEN --black=BLUE

6. To remove class files and archive copy&paste the following line to the terminal and press Enter

rm -rf lib target
