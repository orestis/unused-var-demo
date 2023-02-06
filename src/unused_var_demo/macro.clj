(ns unused-var-demo.macro)

(defonce ALL {})

(defn add-section [title description fqsym]
  `(do
     (swap! ALL-SECTIONS assoc (str fqsym)
            {:title ~title
             :description ~description
             :component ~fqsym})))


(defmacro defsection
  [sym & [settings body]]
  (let [fqsym     (if (namespace sym)
                    sym
                    (symbol (name (ns-name *ns*)) (name sym)))
        {::keys [title description]
         :or {title (name sym)}} settings]
    `(do
       (dev ~sym []
         [:div {:title ~title
                :description ~description} ~body])
       (add-section ~title ~description ~fqsym))))