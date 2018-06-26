(ns issue.core
  (:require [clojure.java.io :as io]))

(def before-edit (slurp (io/resource "issue/core.clj")))
;;; edit the file
(def after-edit (slurp (io/resource "issue/core.clj")))

(not= before-edit after-edit) ;; should be true, but is false in 2.8.0
