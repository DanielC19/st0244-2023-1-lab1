compile-run :
	g++ -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -Wall -Wextra -Werror -shared -o mean.dll Mean.cpp
	javac -Xlint -Werror -h . Lab1.java
	java Lab1.java data.txt

compile :
	g++ -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -Wall -Wextra -Werror -shared -o mean.dll Mean.cpp
	javac -Xlint -Werror -h . Lab1.java

run :
	java Lab1.java data.txt