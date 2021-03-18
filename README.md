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
<br />
Output:
{“Id”: 1, ”amount”: 100, ”comment”: ”order payment”, ”filename”: ”orders.csv”, ”line”: 1, ”result”: ”OK”}<br />
{“Id”: 2, ”amount”: 123, ”comment”: ”order payment”, ”filename”: ”orders.csv”, ”line”: 2, ”result”: ”OK”}<br />
{“Id”: 3, ”amount”: 1.23, ”comment”: ”order payment”, ”filename”: ”orders.json”, ”line”: 1, ”result”: ”OK”}<br />
{“Id”: 4, ”amount”: 1.24, ”comment”: ”order payment”, ”filename”: ”orders.json”, ”line”: 2, ”result”: ”OK”}<br />

- id - order identifier
- amount - order amount
- currency - the currency of the order amount
- comment - comment on the order
- filename **** the name of the source file
- line - line number of the source file
- result - the result of parsing the source file record.
- OK - if the record has been converted correctly,
- or a description of the error if the record could not be converted.

# Quick start
git clone https://github.com/RuslanKhaliullin/TestingApp.git <br />
cd demo2 <br />
mvn clean install  <br />
java -jar target/demo-0.0.1-SNAPSHOT.jar "path to csv file" "path to json file"  <br />
  
# Hint
In the package "demo2", You will find two files showing instances of csv and json files
