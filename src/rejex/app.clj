(ns rejex.app
  (:require [clojure.core.cache :as cache]
            [compojure.core :refer [defroutes routes]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [stencil.loader :as stencil]
            [rejex.middleware.session :as session-manager]
            [rejex.middleware.context :as context-manager]))

;; Initialization
; Add required code here (database, etc.)
(stencil/set-cache (cache/ttl-cache-factory {}))
;(stencil/set-cache (cache/lru-cache-factory {}))


;; Load public routes
(require '[rejex.view.home :refer [home-routes]]
         '[rejex.view.about :refer [about-routes]])

;; Load authentication routes
(require '[rejex.view.auth :refer [auth-routes]])

;; Load private routes
(require '[rejex.view.profile :refer [profile-routes]]
         '[rejex.view.admin :refer [admin-routes]])


;; Ring handler definition
(defroutes site-handler
  (-> (routes home-routes
              about-routes
              auth-routes
              profile-routes
              admin-routes
              (route/resources "/")
              (route/not-found "<h1>Page not found.</h1>"))
      (session-manager/wrap-session)
      (context-manager/wrap-context-root)
      (handler/site)))
