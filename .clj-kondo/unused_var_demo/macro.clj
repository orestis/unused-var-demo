(ns unused-var-demo.macro)

(defmacro defsection
  [sym & _rest]
  `(do (def ~sym nil) ~sym) )
