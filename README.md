# Anagram101
Anagram101 is a command line interface (CLI) program that accepts a word and prints all possible anagrams.

As defined by Wikipedia, an anagram is a word or name formed by rearranging the letters of a given word, such as cinema formed from iceman.  

For more details about Anagram check out Wikipedia's formal definition here: https://en.wikipedia.org/wiki/Anagram


## Installation

*git clone this repository on your local computer

*Make sure you have installed Java Development Kit 11+ and it's linked with your IDE.

*This program contain JUnit 5 tests hereby I recommend checking out JUnit 5's user guide: https://junit.org/junit5/docs/snapshot/user-guide/index.html
to be able to run tests included in this program depending on your IDE.

## Usage

Hence this is a command line interface (CLI) program , arguments are automatically passed to the main function so you will have to configure the args 
in configurations of your IDE.

This program contain a launch.json file which have args set to "-a DOG -nf", hereby if you use VS Code as your IDE you can change args configurations in this file.

![image](https://user-images.githubusercontent.com/64053136/122486831-d67df880-cfa7-11eb-80e6-d5201cfb767b.png)

 Below are the anagram results for the word "DOG":
 
 ![image](https://user-images.githubusercontent.com/64053136/122487365-1db8b900-cfa9-11eb-9fa1-104c414d0550.png)
 
 You're welcome to change the arguments accordingly to the table below as well change the words to see different anagrams. 
 Also this program contain a text file with 373295 English words that act as a dictionary to filter anagram words. 
 
 ![image](https://user-images.githubusercontent.com/64053136/122488983-a84ee780-cfac-11eb-828e-1c8553c02c38.png)



PS: If you don't specify a filter in the arguments the anagram words will be automatically filtered to known English words.



## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
