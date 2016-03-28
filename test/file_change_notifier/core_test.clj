(ns file-change-notifier.core-test
  (:require [clojure.test :refer :all]
            [file-change-notifier.core :refer :all]
            [clj-time.core :as t]))

(deftest test-load-config
  (testing "Test that we get the correct start interval"
  (is (= (t/minus (t/now) (t/minutes 60))) (get-interval-start 60))
  ))