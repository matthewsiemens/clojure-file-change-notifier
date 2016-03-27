(ns file-system-watcher.formatter
  (:require [clj-time.format :as f]
            [clj-time.coerce :as c]))


(def datetime-format (f/formatter "MM-dd-yyyy hh:mm:ss"))

(defn format-file
  [file]
  (let [name ( #(.getName %) file)
        last-modified (f/unparse datetime-format (c/from-long ( #(.lastModified %) file)))]
    (format "File: %s\nLast Modified On: %s\n\n" name last-modified)
    )
  )

(defn
  get-intro-message
  [watch-directory interval-start]
  (str (format "Watching directory %s\n" watch-directory)
       (format "For files modified since %s\n\n" (f/unparse datetime-format interval-start)))
  )

(defn get-formatted-files
  [file-list]
  (if (empty? file-list)
             "No files modified during interval"
             (apply str (map format-file file-list)))
  )

(defn format-content
  [watch-directory interval-start file-list]
  (str (get-intro-message watch-directory interval-start)
       (get-formatted-files file-list)
       )
  )