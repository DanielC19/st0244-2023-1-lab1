compile-run :
	javac -Xlint -Werror -h . Lab1.java
	g++ -I"C:\Program Files\Java\jdk-19\include" -I"C:\Program Files\Java\jdk-19\include\win32" -Wall -Wextra -Werror -shared -o mean.dll Mean.cc
	java Lab1.java data.txt

compile :
	javac -Xlint -Werror -h . Lab1.java
	g++ -I"C:\Program Files\Java\jdk-19\include" -I"C:\Program Files\Java\jdk-19\include\win32" -Wall -Wextra -Werror -shared -o mean.dll Mean.cc

run :
	java Lab1.java data.txt