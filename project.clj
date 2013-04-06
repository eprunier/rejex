(defproject rejex "1.0.0-SNAPSHOT"
  :description "Web app for testing Java regular expressions"
  :url "http://github.com/eprunier/rejex"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring "1.1.6"]
                 [compojure "1.1.3"]
                 [stencil "0.3.2"]]
  :plugins [[lein-ring "0.7.5"]]
  :ring {:handler rejex.app/site-handler}
  :war-resources-path "resources/public"
  :main rejex.server)
