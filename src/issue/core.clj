;;; start with boot dev
;;; cider-connect on port 13337

;;; evaluate this form
(ns issue.core
  (:require [clojure.java.io :as io]))

;;; evaluate this form
(def before-edit (slurp (io/resource "issue/core.clj")))

;;; edit this file
  
;;; evaluate this form
(def after-edit (slurp (io/resource "issue/core.clj")))

;;; evaluate this form, should be true and was true in boot 2.7.2, but is false in boot 2.8.0
(not= before-edit after-edit) 
