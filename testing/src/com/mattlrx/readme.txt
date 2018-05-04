install eclipse from 
http://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/oxygen/3a/eclipse-java-oxygen-3a-linux-gtk-x86_64.tar.gz

make sure the jdk in use is 1.8
sudo update-alternatives --config java

selenium setup
download selenium from https://www.seleniumhq.org/download/ 
https://goo.gl/Us5DnZ
extract the zip locally
add the jars to the build path 

download the Chrome web driver:
https://sites.google.com/a/chromium.org/chromedriver/
unzip and reference the path to the file in the java class:
System.setProperty("webdriver.chrome.driver", "/home/matthieulrx/_work/chromedriver/chromedriver");