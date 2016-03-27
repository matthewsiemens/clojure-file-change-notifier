(ns file-change-notifier.emailer
  (:require [postal.core :refer [send-message]]))

(defn send-email
  [config content]
  (send-message {:host (:host config)
                 :user (:user config)
                 :pass (:pass config)
                 :ssl (:ssl config)}
                {:from (:from config)
                 :to (:to config)
                 :subject (:subject config)
                 :body content}
                )
  )