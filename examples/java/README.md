How to run Mythruna java mods
============
If you don't know how to install mods overall, please check out <a href="http://mythruna.com/forum/index.php?topic=1093.0">This Tutorial</a>
<br><br>
1. Make a file that will run the jar in your "scripts" folder (on clients its in "mods/scripts", it will act as a "runnable",
so you can call it something like "runnable.init.groovy".
<br><br>
2. In that file, type the following:<br>
<code>import <your package>
<your file name>.<method name>()</code>
<br>
This will run the method, and if you have an event in it, it will register the event. If you don't have that as an event,
either put an event within it or add the event within the runnable file, and put your method within it.
<br><br>
3. You're good to go! It will run when the method starts!
