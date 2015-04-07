#This is the README file for executing the scripts

file1 and file2 are the 2 scripts that can be executed at the commandline.
To view their contents, they can be opened with a text editor.

file1 contains code for going through all the directories of vim recursively and
finding the total number of files, the total number of directories, 
total number of .c files and total number of .h files.
I used the unix "find" comand to find files or directories and then
passed the output of this step to a "wc" command that counts the number of lines thus
effectively giving the desired number.

file2 contains code for calculating the sizes of the libraries and displaying 
them in a human readable format. I again used the "find" command to find the number of 
.h (header) files. The output of which was passed to the "du" command which is used to 
calculate file sizes in unix. By choosing the appropriate options, I was able to
print the output in the desired format.