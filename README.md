# Huffman Encoding
Java implementation of string compression using Huffman Encoding

Provided functionality:
-----------------------
- HuffmanEncoder() : construct a new Huffman Encoder
- encode(String string) : returns a binary version of the compressed String
- getCode(Character c) : returns the encoded version of the character from the encoded String*
- getCodes() : returns a HashMap<Character,String> containing each Character and their encoded value*

\* Only for the last encoded String. Resets every time encode(String string) is called
