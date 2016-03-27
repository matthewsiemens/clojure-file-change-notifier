(ns file-change-notifier.core
  (:require [file-change-notifier.directory-watcher :refer [check-for-modified-files]])
  (:gen-class))

(defn -main
  "Send email with list of all modified files in directory"
  [& args]
  (let [config-filename (first args)]
    (check-for-modified-files(config-filename))
    ))