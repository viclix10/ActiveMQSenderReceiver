# ActiveMQSenderReceiver
Basic ActiveMQ Sender Receiver Examples

Overview - 
Tag 1.0 - This version show case the simple example of how to use ActiveMQ via sender and receiver over locahost tcp connection.
Tag 1.1 - This version supports ssl based clients. Remember to add 
Add following to activemq config
<transportConnector name="ssl" uri="ssl://0.0.0.0:61617?needClientAuth=true>

To create ssl certificates required do the following
a) Using keytool, create a certificate for the broker:
	keytool -genkey -alias broker -keyalg RSA -keystore broker.ks
b) Export the broker's certificate so it can be shared with clients:
	keytool -export -alias broker -keystore broker.ks -file broker_cert
c) Create a certificate/keystore for the client:
	keytool -genkey -alias client -keyalg RSA -keystore client.ks
d) Create a truststore for the client, and import the broker's certificate. This establishes that the client "trusts" the broker:
	keytool -import -alias broker -keystore client.ts -file broker_cert
e) Export the client's certificate so it can be shared with broker:
	keytool -export -alias client -keystore client.ks -file client_cert
f) Create a truststore for the broker, and import the client's certificate. This establishes that the broker "trusts" the client:
	keytool -import -alias client -keystore broker.ts -file client_cert

