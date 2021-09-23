# ClassPractice

## 導入方法

```
git clone git@github.com:harmatmeaco/ClassPractice.git
cd ClassPractice
mvn verify
```

Eclipseからimport > Existing Maven Project

import後、Project > clean

## 実行すること
まずは、PesonTest.javaを右クリック > Run As > JUnit Test を実行します。

JUnitタブで8テスト中6テストが失敗します。

Person.javaを確認し、TODOに従ってメソッドを実装してください。

実装できたら、再度PesonTest.javaを右クリック > Run As > JUnit Test を実行してください。

## クラスの解説
Personクラスは人の情報を保持します。

保持する情報は、以下の通りです。

- 個人番号(personId)
- ファーストネーム
- ラストネーム
- 誕生日
