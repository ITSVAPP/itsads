# 課題09：メッセージの共通化 🎓

| 項目 | 内容 |
|------|------|
| 難易度 | ★★☆☆☆☆（2/6） |
| 重要度 | ★★★★★★（6/6） |
| 前提課題 | [08 課題がない場合の業務エラー](08_not-found-error.md) |
| 学習項目 | メッセージの外部ファイル化・MessageSource |
| 修正対象 | `messages.properties` / `AppConfig.java` / `IssueService.java` |

> 🎓 重要度は最高（6/6）。保守性を高める実務必須のリファクタリングです。

---

## 🎯 背景・現在の仕様の問題

課題08で、業務エラーのメッセージを **コード内に直接（文字列リテラルで）** 書きました。
このままだと次のような問題があります。

- ❌ メッセージを変えたいだけで **プログラムの修正**が発生する
- ❌ どこで使われているか **影響範囲の調査に工数**がかかる
- ❌ 同じメッセージが複数箇所にあると、**修正漏れ**が起きやすい
- ❌ 修正のたびに **再テスト**（単体・結合）が必要になる

そのため、システムで共通して使うメッセージや、変更されそうなメッセージは、**外部ファイルに切り出して**おくのが定石です。

---

## 📋 やること（仕様）

エラーメッセージを **外部ファイル（`messages.properties`）に定義**し、コードからはキーで参照するようにします。

```mermaid
flowchart LR
    P[messages.properties<br/>メッセージ定義] -->|起動時に読み込み| A[AppConfig<br/>MessageSource]
    A -->|キーで取得| S[IssueService<br/>エラーメッセージを設定]
```

---

## 📁 修正対象ファイル

| ファイル | 修正内容 |
|----------|----------|
| `src/main/resources/messages.properties`（新規） | メッセージをキー＝値で定義 |
| `src/main/java/com/example/its/config/AppConfig.java` | 起動時に `messages.properties` を読み込む設定 |
| `src/main/java/com/example/its/domain/issue/IssueService.java` | 直書きしていたメッセージを、外部ファイルの値に置き換える |

### 実装方針（有識者に聞くとよい）

1. `messages.properties` を作成し、`src/main/resources` 直下に配置する
2. `AppConfig.java` で起動時にファイルを読み込む
3. `IssueService.java` でエラーメッセージを（外部ファイルから）設定する

---

## ✅ 動作確認

- [ ] 詳細画面が表示できる
- [ ] 存在しない課題（<http://localhost:8080/issues/342>）でエラーメッセージが表示される（課題08と同じ挙動）
- [ ] メッセージ文言を `messages.properties` だけで変更できる

---

## 💡 ヒント

<details>
<summary>外部ファイルの値をコードで使うには？</summary>

`@Value("${キー名}")` を使うと、プロパティファイルの値をフィールドに注入できます。

```java
@Value("${error.noissuemesage}")
private String noIssueMessage;
```

`messages.properties` 側には `error.noissuemesage=課題がありません。` のように書きます。

</details>

---

## 🔗 参考リンク

- [Spring のプロパティ管理（外部設定）](https://b1san-blog.com/post/spring/spring-properties/)

---

⬅️ [08 課題がない場合の業務エラー](08_not-found-error.md) ／ 🏠 [課題一覧](README.md) ／ ➡️ [10 作成完了メッセージの表示](10_create-success-message.md)
