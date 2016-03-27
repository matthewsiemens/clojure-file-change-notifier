(ns file-change-notifier.config-test
  (:require [clojure.test :refer :all]
            [file-change-notifier.config :refer :all]))

(deftest test-load-config
  (testing "Test that we are able to read in the example config file"
  (is (not (empty? (load-config "config.edn"))))
  (is (= "smtp.gmail.com" (:host {:host "smtp.gmail.com"})  ))
  ))