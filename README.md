# ClassPractice

## 導入方法

```
git clone git@github.com:harmatmeaco/ClassPractice.git
cd ClassPractice
mvn verify
```

Eclipseからimport > Existing Maven Project

import後、Project > clean

## テストの実行方法
PesonTest.javaを右クリック > Run As > JUnit Test を実行します。  
初期状態では、JUnitタブで8テスト中6テストが失敗します。  
Person.javaを確認し、TODOに従ってメソッドを実装してください。  
実装できたら、再度PesonTest.javaを右クリック > Run As > JUnit Test を実行してください。  

## 問題
Personクラスが保持する情報を『設定』するgetterメソッドと、『取得』するsetterメソッドを実装してください。

## クラスの解説
Personクラスは人の情報を保持します。

保持する情報は、以下の通りです。

- 個人番号(personId)
- ファーストネーム
- ラストネーム
- 誕生日
