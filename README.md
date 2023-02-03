# Mangman
![Depfu](https://img.shields.io/depfu/litvinova08/hangman)![GitHub issues](https://img.shields.io/github/issues/litvinova08/hangman)

## Description of project (spec / MVP)
this project aimed to recreate a version of the game Hangman to be played in a Java console application.
The game should randomly select a word from the provided list. When the word is selected, a row of underscores representing letters in the word is printed to the console, for example:
_ _ _ _ _
for "hello"

the user will be asked to enter a letter. if the letter entered by the user is in the word, the letter is being revealed, for example
H _ _ _ _
when the user enters "H"

if the letter is not in the word, a part of the hangman is being printed to the console, for example:
___|___
after the first wrong letter is entered,

   |
   |
   |
   |
   |
   |
   |
___|___
after the second incorrect letter is entered, etc.

The user is able to guess wrong 7 times before they loose. The user can guess either a letter or the whole word.
the user can play alone or verse the computer. The computer should select a letter, if the letter selected is in the word, it should be revealed.

## Future Goals
- The computer should also try to guess the whole word
- Create a history file that keeps track of user wins/losses and how many letters they guessed it in


### Stay in touch
- Email: ma.litvinova08@gmail.com
- Portfolio: https://litvinova08.github.io/portfolio-project/
- Linkedin: https://www.linkedin.com/in/margarita-l-44860b15b/
### Licence
- the MIT open source licence
## AuthorMargarita Litvinova
## Project StatusIn progress
