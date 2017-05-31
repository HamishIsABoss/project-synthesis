(ns project-synthesis.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
  (:use [hiccup.core]))

(defn scene [title [location position scale]]
	(html
		[:head
			[:title title]
			[:script {:src "js/aframe.min.js"}]] ;; Alternatively, file is located at https://aframe.io/releases/0.5.0/aframe.min.js
		[:body
			[:a-scene
				[:a-collada-model {:src location :position position :scale scale}]
				[:a-sky {:src "img/background.jpg"}]]]))

(def scenes
  {:grand-mosque (scene "Grand Mosque" ["models/grand-mosque.dae" "0 -100 0" "1 1 1"])
   :burj-khalifa (scene "Burj Khalifa" ["models/burj-khalifa.dae" "-5 1 0" "1 1 1"])
   :emirates-palace (scene "Emirates Palace" ["models/emirates-palace.dae" "0 0 0"])
   :ferrari-world (scene "Ferarri World" ["models/ferarri-world.dae" "-500 -600 -500" "0.25 0.25 0.25"])
   :burj-al-arab (scene "Burj Al Arab" ["models/burj-al-arab.dae" "-500 -500 -500" "1 1 1"])})

(def index
  (html
    [:head
     [:title "Project Synthesis"]
     [:script {:src "js/aframe.min.js"}]
     [:script {:src "js/redirect.js"}]]
    [:body
      [:a-scene
        [:a-image {:src "img/grand_mosque.png" :scale "2 2 2" :position "-4 1 -5" :redirect-mosque-on-click ""}]
        [:a-image {:src "img/burj_khalifa.png" :scale "2 2 2" :position "0 1 -5" :redirect-khalifa-on-click ""}]
        ;;[:a-image {:src "img/emirates_palace.png" :scale "2 2 2" :position "2 1 -5" :redirect-palace-on-click ""}]
        ;;[:a-image {:src "img/ferarri_world.png" :scale "2 2 2" :position "4 1 -5" :redirect-ferarri-on-click ""}]
        [:a-image {:src "img/burj_al_arab.png" :scale "2 2 2" :position "4 1 -5" :redirect-arab-on-click ""}]
        [:a-camera
          [:a-cursor]]
        [:a-sky {:src "img/desert.jpg"}]]]))

(defroutes app-routes
  (GET "/" [] index)
  (GET "/mosque" [] (:grand-mosque scenes))
  (GET "/khalifa" [] (:burj-khalifa scenes))
  ;;(GET "/palace" [] (:emirates-palace scenes))
  ;;(GET "/ferarri" [] (:ferrari-world scenes))
  (GET "/arab" [] (:burj-al-arab scenes))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
