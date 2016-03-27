(ns file-change-notifier.directory-watcher-test
  (:require [clojure.test :refer :all]
            [file-change-notifier.directory-watcher :refer :all]
            [clj-time.core :as t]))

(deftest test-load-config
  (testing "Test that we are able to read in the example config file"
  (is (= (t/minus (t/now) (t/minutes 60))) (get-interval-start 60))
  ))