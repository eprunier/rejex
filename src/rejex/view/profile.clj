(ns rejex.view.profile
  (:require [compojure.core :refer [defroutes GET]]
            [stencil.core :as stencil]
            [rejex.view.common :refer [restricted authenticated? wrap-layout]]))

(defn- page-body []
  (stencil/render-file
   "rejex/view/templates/profile"
   {}))

(defn- render-page [request]
  (wrap-layout "Profile"
               (page-body)))

(defroutes profile-routes
  (GET "/profile" request (restricted authenticated? render-page request)))
