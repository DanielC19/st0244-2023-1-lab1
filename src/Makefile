.RECIPEPREFIX = >

JAVAFLAGS := -Xlint -Werror -h
CXXFLAGS := -I"C:\Program Files\Java\jdk-19\include" -I"C:\Program Files\Java\jdk-19\include\win32" -Wall -Wextra -Werror -shared -o

compile-run :
> javac $(JAVAFLAGS) . Lab1.java
> g++ $(CXXFLAGS) mean.dll Mean.cc
> java Lab1.java data.txt

compile :
> javac $(JAVAFLAGS) . Lab1.java
> g++ $(CXXFLAGS) mean.dll Mean.cc

run :
> java Lab1.java data.txt