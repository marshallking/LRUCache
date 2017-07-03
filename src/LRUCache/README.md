# LRUCache
 
NOTES:

1. Per your time requirements of two hours. Due to Java as not my current language I spent time re-familiarizing myself with the Java language and getting setup to develop in that environment. This did cause me to take more time to complete this exercise. Before this exercise I did write a LRUCache using the go language.. which basically I ported to the java language for this exercise. In my estimate I spent 2-3 hours on this project.

2. I developed this LRUCache using eclipse.
3. The version of Java used - 1.8.0_131.
4. My process was:
    a. Reviewed the requirements. Normally, I would have a lot of questions about these requirements. But due to time and the fact of writing this program on the weekend.. I skipped the requirements question and answer portion of this exercise.
    
    b. From the "write from scratch" requirement.. I did not use Java classes that I would have normally. Not only would it have made the program better.. also would have been a lot less code.
    c. Came up with my design for the LRUCache and chose to use a Hsahmap (O(1)) and LinkedList (O(n)).
    d. I created the unit tests first. Basically stubbed out a few tests specifically right from the requirements.
    d. Designed my data structures and classes needed for this project.
    e. Implemented them.
    f. Ran my unit tests as I completed methods.
    g. When completed I ran a full functional test based on the initial requirements.
    


Initial Requirements:

We would like you to spend no more than 2 hours writing your solution.  This is to limit time required by candidates across the board and provide a level playing field.  If you feel you need a bit more time, please let us know, as we’ve just changed the exercise a bit. Feel free to do it at a time that is convenient for you, but the sooner you get it back to us the sooner we can move forward.  

Please use Python, Java, or C#, whichever you are most comfortable with. If using Java or C#, please ensure your solution is cross platform. On my machine I've got Python 2.7.13, Java 1.8.0, and Mono 5.  If you have a strong reason to use a different language, a different language version, or want to install additional libraries or packages, please email back with details so we can discuss. We’d love to be able to run your program without tweaking our environment.

Please include the following in a zip or tar:

* A short README (or similar) that evaluates the runtime complexity of your algorithm, how to build the program (if needed), how to run the program, any known issues, limitations, assumptions, and any other details needed.

* The source code you have written.

Solutions to the problem below exist on the internet, but we are going to ask you to pretend that they don't. While we don't mind if you use the internet as you normally would to solve a previously unsolved problem (refreshing yourself general knowledge on syntax, libraries, etc), you should not look at cache algorithms and implementations and things of that sort. We trust that you will follow the spirit of this. 

We are interested in your approach and style, not someone else's. It's more important that it be your own than it be optimal or perfect. Finally, all of the code you supply for this exercise must be your own written from scratch for obvious reasons.  Feel free to use standard language libraries.

With all of that out of the way, the question: 

Design and implement an LRU (Least Recently Used) cache. This is a cache with fixed size in terms of the number of items it holds (supplied at instantiation).  For this exercise, we won’t worry about the number of bytes. Your program can treat the keys and values as strings.  You don’t need to support keys or values that contain spaces.  The cache must allow client code to get items from the cache and set items to the cache. Once the cache is full, when the client wants to store a new item in the cache, an old item must be overwritten or
removed to make room. The item we will remove is the Least Recently Used (LRU) item.  Note that your cache does not need persistence across sessions.

Please read input from stdin and print output to stdout and support the following format (please DO NOT print any kind of a prompt or extra line breaks).

All inputs and outputs exist on their own line:

The first input line should set the max number of items for the cache using the keyword SIZE.  The program should respond with ‘SIZE OK’. This must only occur as the first operation.

Set items with a line giving the key and value, separated by a space, 

your program should respond with 'SET OK'.

Get items with a line giving the key requested, your program should respond with the previously stored value, for example “GOT foo”. If the the key is not in the cache, it should reply with “NOTFOUND”.

‘EXIT’ should cause your program to exit.

If the input is invalid, your program should respond with ‘ERROR’


Sample Input

SIZE 3
GET foo
SET foo 1
GET foo
SET foo 1.1
GET foo
SET spam 2
GET spam
SET ham third
SET parrot four
GET foo
GET spam
GET ham
GET ham parrot
GET parrot
EXIT

 

Expected Output

SIZE OK
NOTFOUND
SET OK
GOT 1
SET OK
GOT 1.1
SET OK
GOT 2
SET OK
SET OK
NOTFOUND
GOT 2
GOT third
ERROR
GOT four

 
 

TO BUILD THIS PROJECT:

1. download the code.  https://github.com/marshallking/LRUCache.git
2. javac LRUJavaCache.java LRUCache.java LRUQueue.java 
3. my classpath was -- :/Users/marshallking/workspace/LRUCache/bin
4. copy .class files to directory that your CLASSPATH points to.
  

TO/RUN:

    1. Java LRUCache.LRUJavaCache

 

Example:

Size 10
  -- SIZE OK
Set foo 22
get foo
  -- Got 22

   



INCLUDED FILES IN THIS PROJECT

LRUJavaCache.java                - MAIN program
LRUCache.java
LRUQueue.java
LRUCacheTest.java
LRUQueueTest.java
package-info.java

 
TO RUN TESTS

1.  The unit tests run from within the eclipse IDE. 







