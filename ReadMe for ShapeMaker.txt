A simple program that takes in several inputs and prints out a shape based on those inputs.


Admittedly, I am a Java novice, especially when handling user input.

I found the best way for me to prevent this program from crashing was by starting from the beginning
if a user enteres something other than what the program expects (example: a word instead of an integer).

With a little more time, here's what I'd focus on cleaning up:
-Rejecting unexpected user input by asking the user to enter a value that would be accepted by the program, 
instead of restarting it.
-When asking if the user would like to print a custom word, anything other than "y" just uses the default value.
Even though the question asks the user to enter "y or n".
-Printing the X's more cleanly around words. There are some quirky scenarios where an X is either added or omitted.
I worked out a few of these kinks, but a few remain still.

One thing I'm proud of:
I know this program isn't perfect, but I put a lot of effort into it and I am happy it actually runs!

If you'll notice, to print a diamond I didn't bother writing a separate method. I simply run triangleShape()
followed by bottomTriangleShape() to construct the "diamond." It probably ins't too impressive to you, 
but I felt clever doing it.

If there are any changes you'd like to see, please let me know.
Thank you so much for taking the time to review this!
-Ace

