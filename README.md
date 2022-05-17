# Internet-shop

### It needs to be installed:

* Java 8 (make sure Java class path is set)
* Maven (make sure Java class path is set)
* Browser driver (make sure you have your desired browser driver and class path is set)

### To go to the online store, follow the link:

* Open "https://demo.prestashop.com/" page

### Testing with the following parameters:

* suite
* threadCount
* browser
* browserWidth
* browserHeight

### Commands to be executed:

### -Dsuite=testng

You can use it to run all tests

### -DthreadCount=2

In how many streams we run tests - 2

### -Dbrowser

Which browser will use

It is possible to run with the help of browsers:

* chrome
* firefox

The default browser is chrome

### -DbrowserWidth

Set the screen width

### -DbrowserHeight

Set the screen height

###For example (run tests in two streams on the browser chrome with a width of 1366 and a height of 768):
* mvn clean test -Dsuite=testng -DthreadCount=2 - Dbrowser=chrome -DbrowserWidth=1366 -DbrowserHeight=768

###To receive a report, which will indicate which tests passed successfully and which failed:
* mvn allure::serve





