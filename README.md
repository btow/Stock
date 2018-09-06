# Stock
The application does the following:
- launches "launch screen" which displays the 64x64 icon in the middle of the screen;

- automatically goes to the main screen, which shows a table - a list of currencies received by the link: http://phisix-api3.appspot.com/stocks.json;

- - shows three columns of the table (cell height-50 dp):
  - "Currency name" - field "name";
  - "Price" - field "volume" (integer);
  - "Quantity" - field "amount" (2 decimal places);

- updates every 15 seconds the data in the table ;

- allows you to manually update the data using the button in the navigation menu on the right .