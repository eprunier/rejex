(ns rejex.view.admin
  (:require [compojure.core :refer [defroutes GET]]
            [stencil.core :as stencil]
            [rejex.view.common :refer [restricted admin? wrap-layout]]))

(defn- page-body []
  (stencil/render-file
   "rejex/view/templates/admin"
   {}))

(defn- render-page [request]
  (wrap-layout "Admin"
               (page-body)))

(defroutes admin-routes
  (GET "/admin" request (restricted admin? render-page request)))
