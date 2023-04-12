compile-run :
	javac -Xlint -Werror -h . Mean.java
	g++ -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -Wall -Wextra -Werror -shared -o mean.dll Mean.cpp
	java Mean.java data.txt

compile :
	javac -Xlint -Werror -h . Mean.java
	g++ -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -Wall -Wextra -Werror -shared -o mean.dll Mean.cpp

run :
	java Mean.java data.txt