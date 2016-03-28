(ns file-change-notifier.core
  (:require [file-change-notifier.files :refer :all]
            [file-change-notifier.config :refer [load-config]]
            [file-change-notifier.emailer :refer [send-email]]
            [file-change-notifier.formatter :refer [format-content]]
            [clj-time.core :as t])
  (:gen-class))

(defn get-interval-start
  "Get interval start, we will check for any files modified after this time"
  [interval-in-minutes]
  (t/minus (t/now) (t/minutes interval-in-minutes))
  )

(defn check-for-modified-files
  "Send email with list of all modified files in directory"
  [config-filename]
  (let [config (load-config config-filename)]
    (let [interval-start (get-interval-start (:interval-in-minutes config))
          watch-directory (:watch-directory config)]
      (send-email config (format-content watch-directory interval-start (get-modified-files interval-start watch-directory)))
      )
    ))

(defn -main
  [& args]
  (let [config-filename (first args)]
    (check-for-modified-files config-filename)
    ))