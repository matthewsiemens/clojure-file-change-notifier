(ns file-change-notifier.core
  (:require [file-change-notifier.files :refer :all]
            [file-change-notifier.config :refer [load-config]]
            [file-change-notifier.emailer :refer [send-email]]
            [file-change-notifier.formatter :refer [format-content]]))

(defn check-for-modified-files
  "Send email with list of all modified files in directory"
  [config-filename]
  (let [config (load-config config-filename)]
    (let [interval-start (get-interval-start (:interval-in-minutes config))
          watch-directory (:watch-directory config)]
      (send-email config (format-content watch-directory interval-start (get-modified-files interval-start watch-directory)))
      )
    ))
