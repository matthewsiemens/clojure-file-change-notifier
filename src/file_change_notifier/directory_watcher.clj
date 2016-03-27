(ns file-change-notifier.directory-watcher
  (:require [file-change-notifier.files :refer :all]
            [file-change-notifier.config :refer [load-config]]
            [file-change-notifier.emailer :refer [send-email]]
            [file-change-notifier.formatter :refer [format-content]]
            [clj-time.core :as t]))

(defn check-for-modified-files
  [config-filename]
  (let [config (load-config config-filename)]
    (let [interval-start (t/minus (t/now) (t/minutes (:interval-in-minutes config)))
          watch-directory (:watch-directory config)]
      (send-email config (format-content watch-directory interval-start (get-modified-files interval-start watch-directory)))
      )
    ))