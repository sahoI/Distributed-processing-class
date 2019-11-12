# レポート(植物園の実装)

1. コンパイル&実行方法
コンパイル：` $ javac Garden.java`
実行方法：`$ java Garden`

2. どのような実行結果になるか？
以下に実行結果を貼り付ける。全部で100行あるが一部省略する。
Threadはwestとeastの2つを使用した。
`Thread-east: 1
 Thread-east: 2
 Thread-east: 3
 Thread-east: 4
 Thread-east: 5
 Thread-east: 6
 Thread-east: 7
 Thread-east: 8
 Thread-east: 9
 Thread-east: 10
 ...
 Thread-west: 91
 Thread-west: 92
 Thread-west: 93
 Thread-west: 94
 Thread-west: 95
 Thread-west: 96
 Thread-west: 97
 Thread-west: 98
 Thread-west: 99
 Thread-west: 100
`
一方で以下のようになる時もあった。これらは3で考察する。
`Thread-west: 1
 Thread-west: 2
 Thread-west: 3
 Thread-west: 4
 *Thread-east: Thread-west: 5
 6
 Thread-west: 7
 Thread-east: Thread-west: 8
 9
 Thread-east: Thread-west: 10
 ...
 Thread-west: 91
 Thread-west: 92
 Thread-west: 93
 Thread-west: 94
 Thread-west: 95
 Thread-west: 96
 Thread-west: 97
 Thread-west: 98
 Thread-west: 99
 Thread-west: 100
 `

3. どのような問題を内包しているか？
westとeastの2つのスレッドが同時に実行するマルチスレッドであるので、west側で数のカウントをしている途中でeast側からカウントをするなどして正常にカウントすることができないという問題が起きる。
2.の実行結果の部分で考察すると述べた部分はまさに上記のことが発生しており、例えば、* 印をつけた行ではeastのスレッドが動いているにも関わらずwestのスレッドが事項されたため処理が割り込みされたと考える。なので具体的には「Thread-east:」の部分がprintされた後にCounterのwriteValueメソッドが実行されるがその2つの処理の間にwestの処理が割り込みされた。「Thread-west:」がprintされてCounterのwriteValueメソッドが呼び出されて数字がカウントされてから先ほどのeastの処理が実行された。これを解決するためには例えばeastの「Thread-east:」の部分がprintされた後にCounterのwriteValueメソッドが実行されるという処理が終わるまでは他のスレッドの処理に割り込みがされないようにすることだと考える。
