# st0244-2023-1-lab1

## By:
- Juan Diego Robles de la Ossa
- Daniel Correa Botero

## Used OS for develop:
- Windows 10

## C++ version:
- 12.2.0

## Java version:
- 19.0.1

## Project Overview

In order to solve the given problem we thought it should be divided into some minor tasks. First of all, a Java class that reads a text file with integers separated with white spaces and then generates an integer array based on it. Next, we searched for some ways to interoperate Java and C++, then, we chose to use JNI (Java Native Interface). For JNI we based our code in this [tutorial](https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaNativeInterface.html) and supported ourselves with the official [documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/spec/jniTOC.html) when something went wrong, unexpected or confusing. When we had already made the interoperation, sending an integer array from Java, receiving it from C++, calculating its mean and returning the double value back to Java; it was time to compile the code correctly and write the Makefile according to it. The entire process can be seen through our git commits in this repository, which follows the feature-based git flow (new functionalities), refactors (aesthetic changes) and fixes (repair of bugs and errors). Also, all code is commented thoroughly in both general behavior of the function as well as inline comments to explain what is happening.

## Java Class : Lab1.java

This file has two uses, firstly, it’s compiled as a C++ header file, which will be linked with C++ in order for it to expect what will receive and return to Java. The other use is when it’s executed, since this Java class has the “main” function, it has to load the generated library (.dll for Windows, .so for Linux) that was compiled with C++ that overrides the native function to calculate the mean of the integer array. Then, it reads the text file passed as a command-line argument and splits it to make an integer array out of it. **Note:** It doesn’t allow integers beyond  999.999.999, but it’s all handled. While making the array handles other exceptions for some unexpected behaviors of the program, to finally send it through the overridden function of C++ which calculates the mean of the integers, and returns it back to Java to print it with an accuracy of 3 decimals.

## C++ Function : Mean.cc

In this function, through JNI (Java Native Interface) we implement the native Java function called mean and previously defined in the Java class. This function (mean) calculates the arithmetic mean of an array of integers. It receives three parameters:

- A pointer (JNIEnv) pointing to a matrix of pointers containing the interface functions.
- A Java class object calling the native function (jobject).
- An integer array (jintArray).

First, we use the function GetIntArrayElements to get the elements of the integer array and store them in a pointer (cArray). Then, we verify that the pointer is not null, if so, it will return as a result the double 0.0. Next, we use the function GetArrayLength to obtain the length of the array and we add all the elements inside it. Then, we divide the result by the length of the array and store it in a double (mean). Finally, we use the function ReleaseIntArrayElements to free the memory allocated to the previously created pointer (cArray) and return the previously stored double (mean).

## Make file

The make file it’s pretty straightforward, contains two variables with both C++ and  Java flags to compile with. Also, in order to not use tabs (default separator in make), we change the recipe prefix to “>” which will not be executed and it’s merely a clean separator. That aside, our makefile has three rules:

- **compile-run:** Compiles both Java and C++ and then executes Java. It’s also the default rule.
- **compile:** Only compiles both Java and C++.
- **run:** Only runs Java main, needs other files to be compiled firsthand.
