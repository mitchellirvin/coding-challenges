# Morse Code Interpreter
This challenge was an online technical challenge for an Atlanta based startup.

The challenge is based on [this](https://en.wikipedia.org/wiki/Dichotomic_search#/media/File:Morse_code_tree3.png) dichotomic search tree. Given a string representing morse code, return the possible characters that the string represents. The `?` character indicates that you could go either left or right on the tree (the signal could have been a dot or a dash).

For example, given the string "?-?", our program should return a list: ["R", "W", "G", "O"].
