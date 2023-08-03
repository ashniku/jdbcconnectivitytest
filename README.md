# jdbcconnectivitytest
Test the connectivity using CLoudera JDBC driver from Java Code


1. Copy HiveJDBC42.jar to Linux machine

2. Set the PATH as below,if not set:

     export PATH=$PATH:/usr/java/jdk1.8.0_232-cloudera/bin ==> Check the java path properly

3. Set the CLASSPATH


     export CLASSPATH=.:HiveJDBC42.jar  ==> make sure provide the fully qualified path for HiveJDBC42.jar

4. Change the url in the DriverTest.java

     Put the exact string 

     Connection conn = DriverManager.getConnection("jdbc:hive2://xxxxxxxxxx:10000/default;SSL=1;SSLTrustStore=/var/lib/cloudera-scm-agent/agent-cert/cm-auto-global_truststore.jks;SSLTrustStorePwd=Sg9PLFJKSaW2glexFc8ZWMh132vKGBmbHYmQQgDu3qU;LogLevel=6;LogPath=/tmp;KrbRealm=xxxx.xxxxxx;KrbHostFQDN=xxxxxxxxx;KrbServiceName=hive;AuthMech=1");

 5. Excute below:

      javac DriverTest.java

      java  DriverTest

    Sample output:

    Running: SHOW databases
adc_ccr_source
adc_geodirmonthly_analysis
adc_geodirmonthly_source
adc_geodirother_analysis
adc_geodirother_source
adc_geodirqrtly_analysis
adc_geodirqrtly_source
adc_pmod_analysis
adc_pmod_source
adc_pmod_transformed
adc_pppdb_analysis
adc_pppdb_source
adc_tii_source
