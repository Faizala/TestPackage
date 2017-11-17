set path=%path%;.\sikuli-ide\libs

javac -d bin -sourcepath src -cp .\ext\activation.jar;.\ext\apache-commons-lang.jar;.\ext\couchdb4j-0.1.2.jar;.\ext\ezmorph-1.0.jar;.\ext\iSAFE_3.0_Forbes_05102016.jar;.\ext\itextpdf-5.2.1.jar;.\ext\java-client-3.3.0.jar;.\ext\json-lib.jar;.\ext\json-simple-1.1.1.jar;.\ext\jtidy-r872-jdk15.jar;.\ext\jxl.jar;.\ext\log4j-1.2.16.jar;.\ext\mail.jar;.\ext\org.apache.commons.beanutils.jar;.\ext\org.apache.commons.httpclient.jar;.\ext\postgresql-9.4-1201.jdbc4.jar;.\ext\selenium-server-standalone-2.53.0.jar .\src\iSAFE\TestDriver.java

java -cp bin;.\ext\activation.jar;.\ext\apache-commons-lang.jar;.\ext\couchdb4j-0.1.2.jar;.\ext\ezmorph-1.0.jar;.\ext\iSAFE_3.0_Forbes_05102016.jar;.\ext\itextpdf-5.2.1.jar;.\ext\java-client-3.3.0.jar;.\ext\json-lib.jar;.\ext\json-simple-1.1.1.jar;.\ext\jtidy-r872-jdk15.jar;.\ext\jxl.jar;.\ext\log4j-1.2.16.jar;.\ext\mail.jar;.\ext\org.apache.commons.beanutils.jar;.\ext\org.apache.commons.httpclient.jar;.\ext\postgresql-9.4-1201.jdbc4.jar;.\ext\selenium-server-standalone-2.53.0.jar iSAFE.TestDriver

@pause