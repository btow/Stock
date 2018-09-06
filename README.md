# Stock
The application does the following:
- launches "launch screen" which displays the 64x64 icon in the middle of the screen;

![launch screen](https://github.com/btow/Stock/blob/master/app/src/main/res/img1.jpg)

- automatically goes to the main screen, which shows a table - a list of currencies received by the link: http://phisix-api3.appspot.com/stocks.json;

![main screen](https://github.com/btow/Stock/blob/master/app/src/main/res/img2.jpg)

- shows three columns of the table (cell height-50 dp):
  - "Название валюты" - JSON-field "name";
  - "Цена" - JSON-field "volume" (integer);
  - "Количество" - JSON-field "amount" (2 decimal places);

![shows three columns of the table](https://github.com/btow/Stock/blob/master/app/src/main/res/img3.jpg)

- updates every 15 seconds the data in the table ;

- allows you to manually update the data using the button in the navigation menu on the right .
