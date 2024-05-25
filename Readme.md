1.創建table的語句在resource內 database base in mysql 8.0
創建table之後 將專案run起來 jdbc會連線到cathaybk庫 如果原環境已經有了記得將改名database 如果有改名記得也要改yml
2.使用127.0.0.1:8650/spider 爬取兩張基礎表的數據
3.API 查詢某日價格 get
127.0.0.1:8650/selectOneDayPrice?productId=10480016&statisticsDate=2023-03-10
4.API,修改某日價格
127.0.0.1:8650/updateProductPrice

post content-type: application/x-www-form-urlencoded
bulk edit參數 可直接帶入postman
productId:10480016
price:15.12
statisticsDate:2023-03-10

5.API,新增價格至 DB
127.0.0.1:8650/addProductPrice

post content-type: application/x-www-form-urlencoded
bulk edit參數 可直接帶入postman
productId:10480016
price:1000
statisticsDateTime:1678406400000

6.寫一個 API,可刪除某日價格。
127.0.0.1:8650/deleteProductPrice

post content-type: application/x-www-form-urlencoded
bulk edit參數 可直接帶入postman
productId:10480016
statisticsDate:2023-03-10

7.API查詢 帶入開始結束時間,計算漲跌[後收-前收]和漲跌幅[(後收-前收)/前收]
127.0.0.1:8650/selectFundMomentum?startDate=2024-04-12&endDate=2024-05-24