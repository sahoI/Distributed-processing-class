# レポート (駐車場の実装)

1. コンパイル&実行方法

コンパイル方法は

`$ javac Carpark.java`

で全ての.javaファイルをコンパイルした後に.jarファイルにまとめるため

`$ jar -cvfm g744050_carpark.jar  manifest.mf *.class`

のコマンドを入力する。

jar -cvfm [作成する.jarファイル名].jar [マニフェストファイル] [先ほどコンパイルしたclassファイル名].class

*ここではクラス名を省略するために'*'を使用している

実行方法: `$ java -jar g744050_carpark.jar [任意の数字]`

[任意の数字] : 駐車できる数のこと

2. 実装したプログラムの説明

g744050_carpark.tgzを展開すると以下のようなファイル構成になっている。
<ファイル構成>
── g744050_carpark
   ├── Arrivals.class
   ├── Arrivals.java
   ├── CARPARK.lts
   ├── Carpark.class
   ├── Carpark.java
   ├── CarparkControl.class
   ├── CarparkControl.java
   ├── Departures.class
   ├── Departures.java
   ├── README.md
   ├── g744050_carpark.jar
   └── manifest.mf

<g744050_carpark.jarに含まれるファイル>
・Carpark.class
・CarparkControl.class
・Arrivals.class
・Departures.class
・manifest.mf
がまとまっている。

<実行結果>
最初の駐車スペースは10です。
`車が到着。spaces = 9台
車が発車。spaces = 10台
車が到着。spaces = 9台
車が発車。spaces = 10台
車が到着。spaces = 9台
車が発車。spaces = 10台
車が到着。spaces = 9台
車が到着。spaces = 8台
車が発車。spaces = 9台
車が到着。spaces = 8台
車が発車。spaces = 9台
車が到着。spaces = 8台
車が到着。spaces = 7台
車が発車。spaces = 8台
車が到着。spaces = 7台
車が発車。spaces = 8台
車が到着。spaces = 7台
車が到着。spaces = 6台
車が発車。spaces = 7台
車が到着。spaces = 6台
車が発車。spaces = 7台
車が到着。spaces = 6台
車が到着。spaces = 5台
車が発車。spaces = 6台
車が到着。spaces = 5台
車が到着。spaces = 4台
車が発車。spaces = 5台
車が到着。spaces = 4台
車が発車。spaces = 5台
車が到着。spaces = 4台
車が発車。spaces = 5台
車が到着。spaces = 4台
車が到着。spaces = 3台
車が発車。spaces = 4台
車が到着。spaces = 3台
車が発車。spaces = 4台
車が到着。spaces = 3台
車が到着。spaces = 2台
車が発車。spaces = 3台
車が到着。spaces = 2台
車が発車。spaces = 3台
車が到着。spaces = 2台
車が到着。spaces = 1台
車が発車。spaces = 2台
車が到着。spaces = 1台
車が発車。spaces = 2台
車が到着。spaces = 1台
車が到着。spaces = 0台
車が発車。spaces = 1台
車が到着。spaces = 0台
車が発車。spaces = 1台
車が到着。spaces = 0台
車が発車。spaces = 1台
車が到着。spaces = 0台
...`

<コードについて>

・Carpark.java

CarparkControlのクラスであるcontrolを作成し、それにコマンドラインから入力した数字を与える。
ArraivalsクラスとDeparturesクラスのインスタンスを作成し、それぞれスレッドを開始する。
前回のGardenと行なっていることは変わっていない。

・CarparkControl.java

CarparkControlメソッドとarriveメソッドdepartメソッドの3つのメソッドから構成されている。ここでarriveとdepartメソッドで`notify()`というものを使っていることがポイントである。
この`notify()`とは待機している、あるスレッドが1つ再開する。複数のスレッドが待機している場合はランダムで再開する。だが、今回は使用しているスレッドが2つであるので、仮に`arrive()`の方のスレッドが`Thread.sleep()`で待機している間は`depart()`のスレッドが再開し、逆も然りである。
調べている中で`notifyAll()`というメソッドも見つけた。これは待機しているスレッドが全て再開するというもので、しようしているスレッドが3つ以上の場合に使うと良いと考えたため今回は使用しなかった。

・Arraivals.java, Departures.javac

今回、sleepしている時間を`arrive:depart=2:5`にしたため実行結果は車が発車する`depart()`が実行される回数が多いため実行していくと最後は車の停車している数が0と1を交互に出力している。
