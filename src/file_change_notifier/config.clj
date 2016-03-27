(ns file-change-notifier.config
  (:require [clojure.edn :as edn]))

(defn load-config
  "Given a filename, load & return a config file"
  [filename]
  (edn/read-string (slurp filename)))