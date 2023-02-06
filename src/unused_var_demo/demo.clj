(ns unused-var-demo.demo
  (:require [unused-var-demo.macro :refer [defsection] :as m]))


;; excluded manually
#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defsection Foo
  {::m/title "Title" ::m/description "Description"}
  [:div "hiccup"])

;; excluded by name in :exclude
(defsection Bar
  {::m/title "Title" ::m/description "Description"}
  [:div "hiccup"])

;; should be excluded by :exclude-when-defined-by
(defsection Baz
  {::m/title "Title" ::m/description "Description"}
  [:div "hiccup"])