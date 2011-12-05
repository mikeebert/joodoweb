(ns joodoweb.view.view-helpers
  "Put helper functions for views in this namespace."
  (:use
    [joodo.views :only (render-partial *view-context*)]
    [hiccup.page-helpers]
    [hiccup.form-helpers]
    [joodo.middleware.request :only (*request*)]
))

(def documented-namespaces [
	'joodo.controllers
	'joodo.datetime
	'joodo.env
	'joodo.middleware.flash
	'joodo.middleware.keyword-cookies
	'joodo.middleware.multipart-params
	'joodo.middleware.refresh
	'joodo.middleware.request
	'joodo.middleware.servlet-session
	'joodo.middleware.verbose
	'joodo.middleware.view-context
	'joodo.spec-helpers.controller
	'joodo.spec-helpers.view
	'joodo.string
	'joodo.views])

(defn format-namespace [ns-string]
	(clojure.string/replace ns-string #"joodo\." ""))

(defn ns->url [ns-string]
	(clojure.string/replace ns-string #"\." "_"))

(defn url->ns [ns-string]
	(symbol (clojure.string/replace ns-string #"_" ".")))

(defn url->github-url [ns-string]
	(str "https://github.com/slagyr/joodo/blob/master/joodo/src/" ns-string))

; (defn fn->url [fn-string]
; 	(clojure.string/replace fn-string #"\?" "-q"))
; 
; (defn url->fn [fn-string]
; 	(symbol (clojure.string/replace fn-string #"-q" "?")))