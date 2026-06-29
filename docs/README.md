# ITS 追加課題集（課題管理アプリケーション）

Udemy講座 **[【IntelliJ＆Spring Boot】Javaの基礎からはじめる、ゼロからのWebアプリケーション開発](https://iftc-svcjp.udemy.com/course/intellij-spring-boot/)** の**追加課題**をまとめたリポジトリです。

講座で作成した課題管理システム（ITS: Issue Tracking System）に対して、機能追加・リファクタリング・UI改善などを段階的に実装していくことで、Spring Boot / Thymeleaf / MyBatis の実践力を身につけます。

> 📘 IntelliJ ではなく **Eclipse（Pleiades）** で進めたい方は [環境構築の補足（Eclipse版）](setup-eclipse.md) を参照してください。

---

## 🎯 この課題集で学べること

| カテゴリ | 内容 |
|----------|------|
| DB / MyBatis | テーブル定義の追加、SELECT/INSERT/UPDATE/DELETE、`@Param` |
| 画面表示 | Thymeleaf による一覧・詳細・作成・変更画面の項目追加、日付フォーマット |
| 入力チェック | バリデーション、相関チェック、エラーメッセージのカスタマイズ |
| 設計・保守性 | メッセージの外部ファイル化、業務エラー処理、セッション活用 |
| フロントエンド | CSS・favicon・確認ダイアログ（JS / Bootstrap モーダル） |

---

## 📚 課題一覧

👉 **[課題一覧（難易度・重要度・依存関係つき）はこちら](exercises/README.md)**

全20課題。1課題＝1ファイルで、それぞれ「背景 → やること → 完成イメージ → ヒント → 動作確認」の順に構成されています。

---

## 🚀 進め方

1. Udemy講座を完了し、課題管理アプリが動く状態にする
2. [課題一覧](exercises/README.md) から、依存関係に沿って課題を選ぶ（基本は **課題01から順番** がおすすめ）
3. 各課題の Markdown を読み、自分で実装する
4. 「✅ 動作確認」のチェックリストをすべて満たせたらクリア 🎉

> 💡 **解答コードは載せていません。** まずは自力で実装してみましょう。
> このリポジトリの `src/` は **完成形のリファレンス実装**（全課題を適用した状態）です。どうしても詰まったときの答え合わせに使ってください。

---

## 🗂 ディレクトリ構成

```text
docs/
├── README.md                 ← このファイル
├── setup-eclipse.md          ← Eclipse版の環境構築補足
├── exercises/
│   ├── README.md             ← 課題一覧（索引・依存関係図）
│   ├── 01_table-definition.md
│   ├── 02_list-add-columns.md
│   ├── … （全20課題）
│   └── images/               ← 各課題の完成イメージ画像
└── images/setup/             ← 環境構築補足の画像
```

---

## 🛠 アプリの起動方法

```bash
# Windows
gradlew.bat bootRun

# macOS / Linux
./gradlew bootRun
```

起動後、ブラウザで <http://localhost:8080/issues> にアクセスすると課題一覧画面が表示されます。

| 項目 | 値 |
|------|----|
| 言語 / FW | Java 11 / Spring Boot 2.6.7 |
| テンプレート | Thymeleaf |
| DB アクセス | MyBatis |
| DB | H2（インメモリ） |
| その他 | Lombok / Bean Validation / Bootstrap |
