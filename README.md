# Levenshteins Distance Finder program written in Java
Author: Collin Ennis, Michael Wood

Information about a Levenshtein distance can be found here: https://en.wikipedia.org/wiki/Levenshtein_distance

This program finds the number of legal one character changes needed to change the first supplied string into the second supplied string.
It is important to note that all one character changes must change the word into a valid word contained in the dictionary.txt file.

Here is some sample output of the program:
![image](https://user-images.githubusercontent.com/115193664/214452822-af6c5e68-1ab6-404b-b90e-ed1bfe87074b.png)
![image](https://user-images.githubusercontent.com/115193664/214452852-cb37e593-1b92-49c8-bf30-19f6ccc3e423.png)

This output shows interesting parts of the program:
![image](https://user-images.githubusercontent.com/115193664/214452978-9eb41c8e-5245-447e-9764-ce88aae39fc9.png)

Note that no path could be found. This is because there was no path of valid words that were generated based on one character changes from the first word.
