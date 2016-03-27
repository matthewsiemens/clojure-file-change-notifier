(ns file-system-watcher.files
  (:require [clojure.java.io :as io]
            [clj-time.core :as t]
            [clj-time.coerce :as c]
            ))

(defn only-files
  "Filter out anything that isn't a file"
  [file-list]
  (filter #(.isFile %) file-list))

(defn modified-in-interval
  "Check if the last-modified date passed in is within the passed in interval"
  [interval-start last-modified]
  (t/after? last-modified interval-start)
  )

(defn get-last-modified-from-file
  [file]
  (c/from-long (.lastModified file)))

(defn get-files-modified-in-interval
  "Filter out anything that wasn't modified in the specified interval"
  [interval-start file-list]
  (filter #(modified-in-interval interval-start (get-last-modified-from-file %)) file-list))

(defn get-files-in-directory
  "Get all files in the directory"
  [directory]
  (only-files (file-seq (io/file directory)))
  )

(defn get-modified-files
  "Get a seq of all files within the directory that have been modified in the interval"
  [interval-start watch-directory]
  (let [files (get-files-in-directory watch-directory)]
    (get-files-modified-in-interval interval-start files)
    ))