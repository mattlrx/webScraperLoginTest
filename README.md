# webScraperLoginTest
automated test for the login page on http://testing-ground.scraping.pro/login


These are my notes to setup an eclipse project that aims at testing a login page at:
http://testing-ground.scraping.pro/login

This is written as a kind of framework that takes a csv file as test input (test cases variables are defined in there)
it is all written in java (requires java 8)


install eclipse from 
http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/oxygen/3a/eclipse-java-oxygen-3a-linux-gtk-x86_64.tar.gz

make sure the jdk in use is 1.8
sudo update-alternatives --config java


=========create the project==============
create a new project from the git repository (root of the project is the /testing folder)
add the git repository to your eclipse client:
Window > Show views > Other > Git > Git Repositories
click "clone a git repository"
use https://github.com/mattlrx/webScraperLoginTest.git as the repository url
specify a local folder on your machine to copy the files to

create a new java project, uncheck the option to use the default location and instead point to the location you set in the previous step 
and browse to the testing directory.


==========set the build path ==============
to test the login page, I used Selenium java client (3.11.0), to set it up, 
download selenium from the following page: https://www.seleniumhq.org/download/ 
or directly from https://goo.gl/Us5DnZ
extract the zip locally
add the jars to the build path 

NOTE: the chrome driver has been included in the project.
so no need to download it

to test the redirect page, 
for the http client , download httpcomponents-client-4.5.5
from https://hc.apache.org/downloads.cgi
add httpclient-4.5.5.jar and httpcore-4.4.9.jar to the build path


also need commons-io-2.6.jar from https://commons.apache.org/proper/commons-io/download_io.cgi


=============optional - write test cases:==========
edit data.csv 
the format is as follow:
test case name,script,start point url, expected result, data 1, data 2, data 3
for example:
"Welcome Page",S,http://testing-ground.scraping.pro/login,h3 class='success'>WELCOME,admin,12345,true

there are 2 scripts: S to login via Selenium
H to login using an HTTP client (this is to test the redirect page)

if you only want to run the first N lines, enter a line that starts with STOP and only the test data before this line will be loaded.

============execute the test:===========
to execute the test run the Main method in the TestDriver class.
after each test is executed the result of the test is appended in the test file defined as the report file.
once the test is completed, open loginTest.txt to see the test results
