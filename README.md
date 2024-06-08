# Encoder Application

This is a simple application that encodes a string using a simple algorithm. The algorithm is as follows:

1. An offset character is selected from a list of characters.
2. The offset character is used to shift the characters in the string by the index of the offset character in the list of characters.
3. The encoded string is produced by concatenating the offset character and the shifted string.
4. To decode the string, the offset character is removed and the string is shifted back by the index of the offset character in the list of characters.
5. The list of characters is as follows: `['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/']`
