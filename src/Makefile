compile-run :
	javac -Xlint -Werror -h . Lab1.java
	g++ -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -Wall -Wextra -Werror -shared -o mean.dll Mean.cc
	java Lab1.java data.txt

compile :
	javac -Xlint -Werror -h . Lab1.java
	g++ -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -Wall -Wextra -Werror -shared -o mean.dll Mean.cc

run :
	java Lab1.java data.txt