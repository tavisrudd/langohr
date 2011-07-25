(ns langohr.core
  (:import (com.rabbitmq.client ConnectionFactory Connection))
  )

;;
;; Defaults
;;

(def *default-username* "guest")
(def *default-password* "guest")
(def *default-vhost*    "/")
(def *default-host*     "localhost")
(def *default-port*     5672)


;;
;; Protocols
;;

(defprotocol Closeable
  (close [c] "Closes given entity"))

(extend-protocol Closeable
  com.rabbitmq.client.Connection
  (close [this] (.close this)))

(extend-protocol Closeable
  com.rabbitmq.client.Channel
  (close [this] (.close this)))


;;
;; API
;;

(defn connect
  "Creates and returns a new connection to RabbitMQ"
  ;; defaults
  ([]
     (let [conn-factory (ConnectionFactory.)]
       (.newConnection conn-factory)))
  ;; settings
  ([{:keys [username password vhost host port] :or {username *default-username*, password *default-password*, vhost *default-vhost*, host *default-host*, port *default-port*}}]
     (let [conn-factory (doto (ConnectionFactory.)
                          (.setUsername    username)
                          (.setPassword    password)
                          (.setVirtualHost vhost)
                          (.setHost        host)
                          (.setPort        port))]
       (.newConnection conn-factory))))