# [1.1.0](https://github.com/johnnymillergh/exrx-net-crawler-server/compare/v1.0.0...v) (2020-02-11)


### chore

* **$SQL:** modify MySQL table structures ([d8133ed](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/d8133ed5f167987f78c4edf228cafc2c6e2396af))


### Features

* **$Common:** provide API for retrieving application info ([24e8b36](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/24e8b364ca38f26feba691159af96c98afafcd90))


### Performance Improvements

* **$Muscle:** refine method that querying muscle by name ([f768300](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/f768300ac22c35c1b5ec7b9f12212703609c2e6a))
* **$WebFlux:** refine WebFlux configuration ([b021896](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/b02189618f03c61aeac8f6f24734253db3dccdd5))


### BREAKING CHANGES

* **$SQL:** update MySQL table structure (10:04 AM, Feb.11, 2020)



# 1.0.0 (2020-01-30)


### Bug Fixes

* **$Exercise:** correct constraint for `relatedMuscleType` ([27a67cd](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/27a67cdb01df5ab8b36505ba9e87260d8fce5107))


### Features

* **$404:** add customized 404 page ([e76f2e6](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/e76f2e62e2b7226c847deb34b0061c76c5637e88))
* **$Banner:** beautiful banner ([6a8f790](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/6a8f790468f5a9fa0d8a3d7c856eda4da48018c0))
* **$Exercise:** add API for saving exercise's GIF ([74b5680](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/74b5680bc8f37d0353ee8e44b6ea24027a386794))
* **$Exercise:** complete API for saving exercise ([921b91b](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/921b91b198996c75e055afde9e58daa0a32fd244))
* **$Exercise:** complete API for saving exercise's GIF ([491dcfc](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/491dcfc0dccb87aee0755738fed6bf2748336f84))
* **$ExerciseClassification:** add API for saving exercise classification ([8a014ed](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/8a014ed833a3f0d937c71210733bc2f6b54af1d7))
* **$exrx-net-crawler-server:** add more emoji in startup log ([f8a049e](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/f8a049e7c3af9a61ed3e7c08fa2dbea8625ea47e))
* **$exrx-net-crawler-server:** beautify startup log, use Vue.js-like log ([2649822](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/26498226e2848ac39027759af9f5056fead91dd1))
* **$exrx-net-crawler-server:** integrate Spring Content ([9cf076a](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/9cf076aa5e2616a0b24b3f61eab417252f6cc0f3))
* **$Favicon:** unify customized favicon ([5d6552b](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/5d6552b71f676699690936b9d73fd8573ea8dade))
* **$FileUpload:** add a demo for uploading file ([4c8296a](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/4c8296a6243907075bdcffa0a6c0c977c42784d8))
* **$Home, StaticResource:** add home page ([af83353](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/af83353b1729a1d10d25eb871ac82ae5de86b59a))
* **$Muscle:** add API for saving muscle info ([3295b65](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/3295b6553d90f2c5b073da3ed89951de732a1a33))
* **$Muscle:** add muscle module framework ([486b70c](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/486b70cee65a64e7ca0cc2dfd96800126826d72e))
* **$Muscle:** provide API - update muscle details ([5515f77](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/5515f77887a0af1951ce8415103235c72b4b9baa))
* **$Swagger:** display more info on Swagger API page ([1ea6319](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/1ea6319c0b6028d6f3390dcaada0af3ba06f35c4))
* **$Swagger:** enrich Swagger description ([e418424](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/e41842406dba66f3469e31699d35a68a200a8d26))
* **$Swagger:** redirect Swagger API documentation ([e6f113b](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/e6f113b46df6905da76ac6c51538e77c47865944))
* **$Swagger:** redirect to Swagger page if access base URL ([17783c2](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/17783c2fdc363f025b07477e02f3c7eeb755646f))
* **$Video:** add an entrance button for demo video ([5b42f96](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/5b42f9656f3808b622aa78865c9f5e24f9300579))
* **$Video:** add video page ([6316709](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/631670964128178d0c10643aaacbee69d70a7dbe))
* **$VideoStreaming:** add a demo for video streaming ([0e41995](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/0e41995fcd7dea99a2b0743b9916bec73ff163b3))
* **$WebFlux:** support video streaming ([d010b07](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/d010b077133c3afde0cd4393ffb3cf81d3be30ff))


### Performance Improvements

* **$BodyPart:** remove @Builder annotation ([3dc4386](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/3dc4386b4011444621b054f88f4a68ecb6f4fa2c))
* **$POM:** update Spring Boot 2.2.4.RELEASE ([92cb2f0](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/92cb2f045259cc780cf1dceb72e99d83c74fe44a))
* **$SQL:** remove unnecessary field ([592d6c9](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/592d6c907ac1748484b050af948d8898f436577b))


### Reverts

* **$HTML:** revert code ([0f2327e](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/0f2327e5987b2b079fd21e7bb0679909d5ab72b8))
* **$HTML:** revert code ([7321a58](https://github.com/johnnymillergh/exrx-net-crawler-server/commit/7321a58d82261502369f02a96110aef0caf2ec38))


### BREAKING CHANGES

* **$WebFlux:** support video streaming
* **$Swagger:** redirect to Swagger page if access base URL
* **$exrx-net-crawler-server:** add more emoji in startup log
* **$exrx-net-crawler-server:** beautify startup log, use Vue.js-like log.
* **$Favicon:** unify customized favicon
* **$exrx-net-crawler-server:** integrate Spring Content
* **$404:** customized 404 page
* **$Home, StaticResource:** Support static resource
* **$Swagger:** enrich Swagger description
* **$Swagger:** display more info on Swagger API page
* **$Swagger:** redirect Swagger API documentation



