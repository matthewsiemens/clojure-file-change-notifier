(ns file-system-watcher.directory-watcher
  (:require [file-system-watcher.files :refer :all]
            [file-system-watcher.config :refer [load-config]]
            [file-system-watcher.emailer :refer [send-email]]
            [file-system-watcher.formatter :refer [format-content]]
            [clj-time.core :as t]))

(defn check-for-modified-files
  [config-filename]
  (let [config (load-config config-filename)]
    (let [interval-start (t/minus (t/now) (t/minutes (:interval-in-minutes config)))
          watch-directory (:watch-directory config)]
      (send-email config (format-content watch-directory interval-start (get-modified-files interval-start watch-directory)))
      )
    ))