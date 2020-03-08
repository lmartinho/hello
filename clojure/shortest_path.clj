;;  b - d
;; /    |
;;a     e
;; \  /
;;  c 
(def graph {
    :a [:b :c],
    :b [:d],
    :c [:e],
    :d [:e],
    :e []
})

(defn shortest [node1 node2] 
    (if (= node1 node2) 
        [node2]
        (concat
            [node1]
            (shortest (first (graph node1)) node2)
        )
    )
)

(print (shortest :a :e))
