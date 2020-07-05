# Kata14-Tigram
Create a trigram algorithm to generate text as per:
http://codekata.com/kata/kata14-tom-swift-under-the-milkwood/

Using the first chapter of Tom Swift and His Submarine Boat.  
You'll find this in the `src/main/resources` directory.

To run via an IDE simply run the main class, `src/main/java/miller/dave/TigramGenerator.java`.
To run via command line build the jar with Maven:
`mvn package`
Then run the following command:
`java -cp target/tigram-1.0-SNAPSHOT.jar miller.dave.TigramGenerator`
This will create a file with the following file name format `TigramGenerated_<todays date and time>.txt` in the root directory of where it was ran.

Future enhancements include allowing the input file to be an argument specified at run time or via a properties setting.
Punctuation, speech quotes, commas and preserved text case to be introduced by the use of a word meta-data class.  
