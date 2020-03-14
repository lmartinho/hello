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

(declare shortest_path)

(defn shortest [a b]
    (if (< (count a) (count b))
        a
        b
    )
)

(defn shortest_non_empty [a b]
    (if (empty? a)
        b
        (if (empty? b)
            a 
            (shortest a b)
        )
    )
)

(defn shortest_path_aux [nodes node2]
    (if (empty? nodes)
        []
        (shortest_non_empty 
            (shortest_path (first nodes) node2)
            (shortest_path_aux (rest nodes) node2)
        )
    )
)

(defn shortest_path [node1 node2]
    (if (= node1 node2)
        [node2]
        (if (empty? (graph node1))
            []
            (concat
                [node1]
                (shortest_path_aux (graph node1) node2)
            )
        )
    )
)

(print (shortest_path :a :e))
