HOW TO COMPILE AND LAUNCH IMAGESTOCHAR PROJECT:

1. Open a preferable terminal and get to the project root.
2. Make sure that you are in the project root directory ImagesToChar.

3. Download a file "it.bmp" from project page and save it in project root directory or any other place

4. Copy&paste the following line to the terminal and press Enter

javac -d target src/java/edu/school21/printer/logic/BmpHandler.java \
&& javac -cp target/ -d target src/java/edu/school21/printer/app/Program.java

5. To test launching program without argumets copy&paste the following line to the terminal and press Enter

java -cp target edu.school21.printer.app.Program

6. To test launching program with argumets copy&paste the following line to the terminal, make sure that filePath is correct and press Enter

java -cp target edu.school21.printer.app.Program --white=. --black=0 --filePath=./it.bmp

7. To remove class files copy&paste the following line to the terminal and press Enter

rm -rf target
