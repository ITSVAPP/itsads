# 課題11：完了メッセージの共通化

| 項目 | 内容 |
|------|------|
| 難易度 | ★☆☆☆☆☆（1/6） |
| 重要度 | ★★★☆☆☆（3/6） |
| 前提課題 | [09 メッセージの共通化](09_externalize-messages.md)・[10 作成完了メッセージの表示](10_create-success-message.md) |
| 学習項目 | HTML（Thymeleaf）からのメッセージ参照 |
| 修正対象 | `messages.properties` / `list.html` |

---

## 🎯 背景・現在の仕様の問題

課題10で表示した「新規課題を作成しました。」は、**HTMLに直接書かれた**メッセージです。
課題09で学んだとおり、これも次の問題を抱えています。

- ❌ 変更のたびにプログラム（HTML）の修正が必要
- ❌ 影響範囲の調査に工数がかかる
- ❌ 同一メッセージの修正漏れ／再テストが必要

そこで、画面に表示するメッセージも **外部ファイル（`messages.properties`）に共通化**します。

---

## 📋 やること（仕様）

「新規課題を作成しました。」を `messages.properties` に定義し、HTML側ではキーで参照します。

---

## 📁 修正対象ファイル

| ファイル | 修正内容 |
|----------|----------|
| `src/main/resources/messages.properties` | 作成完了メッセージをキー＝値で定義 |
| `src/main/resources/templates/issues/list.html` | 直書きを、メッセージキーの参照に置き換える |

---

## ✅ 動作確認

- [ ] 登録時に、一覧画面で作成完了メッセージが表示される（課題10と同じ見た目）
- [ ] メッセージ文言を `messages.properties` だけで変更できる

---

## 💡 ヒント

<details>
<summary>HTMLから messages.properties を参照するには？</summary>

Thymeleaf の **メッセージ式 `#{...}`** を使います。

```html
<div th:if="${param.created}" class="alert alert-info" th:text="#{info.createdmessage}">(メッセージ)</div>
```

`messages.properties` 側には `info.createdmessage=新規課題を作成しました。` のように書きます。

</details>

---

## 🔗 参考リンク

- [Thymeleaf メッセージ式の使い方](https://qiita.com/NagaokaKenichi/items/c6d1b76090ef5ef39482)

---

⬅️ [10 作成完了メッセージの表示](10_create-success-message.md) ／ 🏠 [課題一覧](README.md) ／ ➡️ [12 変更完了メッセージの表示](12_edit-success-message.md)
