(doctype :html5)
[:html
 [:head
  [:meta {:http-equiv "Content-Type" :content "text/html;charset=utf-8"}]
  [:link {:rel "shortcut icon" :href "images/favicon.ico"}]
	[:link {:href "http://fonts.googleapis.com/css?family=EB+Garamond" :rel "stylesheet" :type "text/css"}]
	[:link {:href "http://fonts.googleapis.com/css?family=Open+Sans:300" :rel "stylesheet" :type "text/css"}]
  [:title "Joodo | Clojure Web Framework"]
  (include-css "/stylesheets/reset.css")
  (include-css "/stylesheets/joodoweb.css")
  (include-css "/stylesheets/shCore.css")
  (include-css "/stylesheets/shThemeDefault.css")
  (include-js "/javascript/jquery-1.7.1.min.js")
  (include-js "/javascript/joodoweb.js")
  (include-js "/javascript/shCore.js")
  (include-js "/javascript/shBrushClojure.js")]
 [:body
  [:table.body [:tr
   [:td.sidebar
    [:a.title {:href "/"}
     [:img {:src "/images/logo.png" :alt "Joodo"}]]
    [:ul.navigation
     [:li [:a {:href "/docs"}      [:span "api"]]]
     [:li [:a {:href "/tutorial"}  [:span "sample application"]]]
     [:li [:a {:href "/about"}     [:span "about"]]]
     [:li [:a {:href "/community"} [:span "community"]]]]
    [:div.footer
     [:a {:href "/license"} "License Info"]
     " | "
     [:a {:href "https://github.com/slagyr/joodo" :target "_blank"} "Git Repository"]
     [:p "Copyright &copy; 2011 Micah Martin"]
     [:p "All Rights Reserved"]]]
   (if (re-matches #"^/tutorial.*" (or (:uri *request*) ""))
     (list
       [:td.drawer
        [:ul
         [:li [:a {:href "/tutorial/basics"} "Getting Started"]]
         [:li [:a {:href "/tutorial/controllers"} "Controllers"]]
         [:li [:a {:href "/tutorial/views"} "Views"]]
         [:li [:a {:href "/tutorial/reference"} "Reference"]]]]))
   (if (re-matches #"^/docs.*" (or (:uri *request*) ""))
     (list
       [:td.drawer
        [:ul
         (map
           #(merge [:li
	         (if (= (str "/docs/" (ns->url-safe %)) (or (:uri *request*) ""))
               [:a.selected {:href (str "/docs/" (ns->url-safe %))} (format-namespace %)]
               [:a {:href (str "/docs/" (ns->url-safe %))} (format-namespace %)])])
           documented-namespaces)]]))
   [:td.content
		[:br]
		[:center (get-random-icon)]
    (eval (:template-body joodo.views/*view-context*))]
  ]]
	[:div.faux_footer]
 ]
]