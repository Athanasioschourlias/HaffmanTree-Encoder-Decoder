# Huffman Tree

This code is part of an exercise for the Data Structures course at Harokopio
University of Athens, Dept. of Informatics and Telematics.

## Team

N.Liapis <b>it21950</b>    
A.Chourlias <b>it219113</b>  
C.Zalaxoris <b>it21922</b>

## Usage

To install maven

```
sudo apt-get install maven
```

Compile and run App(main)
--

Compile using

```
mvn install
```

Run main using

```
java -cp target/Assigment-1.0-SNAPSHOT.jar org.hua.App.App
```


Compile and run Encoder 
--

```
mvn compile exec:java -Dexec.mainClass=org.hua.App.Encoder -Dexec.args="arg1 arg2" 
```

Compile and run Decoder
--

```
mvn compile exec:java -Dexec.mainClass=org.hua.App.Decoder -Dexec.args="arg2 arg1" 
```