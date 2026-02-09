# Hangman - simple word game

## This project is my attempt to implement hangman game using Java core instruments.

Basic info:
1. No third-party libraries used for main code (except for tests and json processing)
2. There are **multiple** ways to initialize the game:
    1. Word supplied from CSV file, that is located in resources folder
    2. Word supplied from API (https://random-word-api.herokuapp.com/word?number used)
    3. Multiple difficulty levels (will change available attempts)
    4. User input and rendering - GUI or CLI (GUI in ***progress*** and not yet implemented)

About architecture - it sucks, i know. I tried to be as SOLID as possible. I also tried to use design patterns (you can see that in factory classes). But, considering that I am a junior, i did my best. Perhaps, I revisit this project.