# AGENTS.md

AIエージェント／コントリビューター向けのガイドです。

## プロジェクト概要

Udemy講座の課題管理システム（ITS）を題材にした **追加課題集** リポジトリ。`src/` は全課題を適用した **完成形リファレンス実装**、`docs/` は学習者向けの課題ドキュメントです。

- アプリ本体: Java 11 / Spring Boot 2.6.7 / Thymeleaf / MyBatis / H2（インメモリ）/ Lombok / Bean Validation
- 課題ドキュメント: `docs/exercises/` に1課題＝1Markdown（全20課題）＋索引（`docs/exercises/README.md`）

## ディレクトリ

```text
src/main/java/com/example/its/   アプリ本体（web / domain / session / exception / config）
src/main/resources/              schema.sql・data.sql・templates・static・*.properties
docs/                            課題集（README / exercises / setup-eclipse / 原本xlsx）
```

## ビルド・実行・テスト

```bash
./gradlew bootRun     # 起動（http://localhost:8080/issues）
./gradlew test        # テスト
./gradlew build       # ビルド
```

Windows では `gradlew.bat <task>` を使う。

## コーディング規約

- 既存コードのスタイル（命名・構成）に合わせる。レイヤは `web`（Controller/Form）→ `domain`（Service/Repository/Entity）。
- 業務ロジックは `IssueService` に集約する。
- ユーザー向けメッセージは `src/main/resources/messages.properties` に外部化する（コードに直書きしない）。

## ドキュメント（docs/）の重要ルール

- 課題は **1問1ファイル**（`NN_kebab-name.md`）。索引 `docs/exercises/README.md` と前提課題・依存関係を整合させる。
- **「修正対象ファイル」は絶対にクリック可能なリンクにしない。** インラインコード表記（`` `src/main/...` ``）でパスを示すだけにする。`src/` は解答そのものなので、リンクにすると学習効果が損なわれる。
- 解答コードは載せない。ヒントは `<details>` で段階的に開示する。
- 図解は **mermaid**（ER図・シーケンス図・フローチャート）を活用する。GitHubで描画されることを確認すること。
- 完成イメージ画像は `docs/exercises/images/NN/` に置き、相対パスで参照する。
- 課題間のナビゲーション、外部ドキュメントへのリンクはOK。

## 注意

- 原本の `docs/10_課題一覧.xlsx` は削除・改変しない。
- コミット／プッシュはユーザーの指示があるときだけ行う。
