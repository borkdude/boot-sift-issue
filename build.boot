(set-env!
 :resource-paths #{"src" "resources"}
 :dependencies '[[org.clojure/clojure "1.9.0"]
                 [org.clojure/tools.nrepl "0.2.12"]

                 [org.clojure/clojurescript "1.10.238"]
                 [com.cognitect/transit-cljs "0.8.256"]

                 [cljsjs/c3 "0.4.18-0"]

                 [deraen/boot-less "0.6.2" :scope "test"]
                 [adzerk/boot-cljs "2.1.4" :scope "test"]
                 [adzerk/boot-cljs-repl "0.3.3" :scope "test"]
                 [adzerk/boot-reload "0.5.2" :scope "test"]
                 [com.cemerick/piggieback "0.2.2" :scope "test"]
                 [weasel "0.7.0" :scope "test"]])

(require '[clojure.tools.nrepl.server :as nrepl])

(require '[adzerk.boot-cljs :refer :all])
(require '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])
(require '[adzerk.boot-reload :refer [reload]])

(deftask nrepl []
  (with-pass-thru [_]
    (nrepl/start-server :port 13337)
    (println "started nREPL on port 13337")))

(deftask dev []
  (comp
   (nrepl)
   (sift :add-jar {'cljsjs/c3 #"cljsjs/c3/common/c3.min.css"})
   (sift :move {#"cljsjs/c3/common/c3.min.css"
                "public/css/vendor/c3/c3.min.css"})
   (watch)
   (reload :asset-path "/public")
   (cljs-repl)
   (cljs)))
