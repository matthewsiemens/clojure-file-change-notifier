(ns file-system-watcher.core
  (:require [file-system-watcher.directory-watcher :refer [check-for-modified-files]])
  (:gen-class))

(defn -main
  "Send email with list of all modified files in directory"
  [config-filename]
  (check-for-modified-files(config-filename)))