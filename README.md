# TestingApp
The console application was created to parse JSON and CSV files  and print the results out

# Description task
Input data <br />

CSV file.  <br /> 
Column assignment: * <br />
Order ID, amount, currency, comment <br />
<br />
Example of recording: * <br />
1,100, USD, order payment <br />
2,123, EUR, order payment <br />
<br />
JSON file. <br />
Example of recording: * <br />
{“OrderId”: 2, ”amount”: 1.23, ”currency”: ”USD”, ”comment”: ”order payment”} <br />
{“OrderId”: 3, ”amount”: 1.24, ”currency”: ”EUR”, ”comment”: ”order payment”} <br />

# Quick start
git clone https://github.com/RuslanKhaliullin/TestingApp.git <br />
cd demo2 <br />
mvn clean install  <br />
java -jar target/demo-0.0.1-SNAPSHOT.jar "path to csv file" "path to json file"  <br />
  
# Hint
In the package "demo2", You will find two files showing instances of csv and json files
