(defproject com.novemberain/langohr "1.0.0-SNAPSHOT"
  :description "An idiomatic Clojure client for RabbitMQ that embraces AMQP 0.9.1 model. Built on top of the RabbitMQ Java client"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"}
  :dependencies [[org.clojure/clojure      "1.3.0"]
                 [com.rabbitmq/amqp-client "2.8.2"]]
  :profiles {:dev { :dependencies [[org.clojure/tools.cli "0.2.1" :exclusions [org.clojure/clojure]]] }
             :1.4 { :dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.0-master-SNAPSHOT"]]}}
  :url "https://github.com/michaelklishin/langohr"
  :repositories {"sonatype" {:url "http://oss.sonatype.org/content/repositories/releases"
                             :snapshots false
                             :releases {:checksum :fail :update :always}}
                 "sonatype-snapshots" {:url "http://oss.sonatype.org/content/repositories/snapshots"
                               :snapshots true
                               :releases {:checksum :fail :update :always}}}
  :aliases {"all" ["with-profile" "dev:dev,1.4:dev,1.5"]}
  :warn-on-reflection true
  :jvm-opts ["-Xmx512m"])
