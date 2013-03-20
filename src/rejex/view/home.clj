(ns rejex.view.home
  (:require [compojure.core :refer [defroutes GET POST]]
            [stencil.core :as stencil]
            [rejex.view.common :as common]))

(defn- page-body
  [content]
  (stencil/render-file
   "rejex/view/templates/home"
   content))

(defn- render-page
  [request]
  (common/wrap-layout "Home"
                      (page-body {})))

(defn- process-regex
  [{{expression :expression input :input :as params} :params :as request}]
  (let [result (re-find (re-pattern expression) input)]
    (common/wrap-layout "Home"
                        (page-body (assoc params :output result)))))

(defroutes home-routes
  (GET "/" request (render-page request))
  (POST "/" request (process-regex request)))
