(defproject file-change-notifier "0.1.0-SNAPSHOT"
  :description "Send email with list of modified files in directory"
  :url "https://github.com/matthewsiemens/clojure-file-change-notifier"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-time "0.11.0"]
                 [com.draines/postal "1.11.4"]]
  :main ^:skip-aot file-change-notifier.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  )
