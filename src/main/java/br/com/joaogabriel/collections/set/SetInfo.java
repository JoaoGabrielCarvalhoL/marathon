package br.com.joaogabriel.collections.set;

import br.com.joaogabriel.collections.model.Anime;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * HashSet: This class implements the Set interface, backed by a hash table (actually a HashMap instance). It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. This class permits the null element.
 * LinkedHashSet: Hash table and linked list implementation of the Set interface, with well-defined encounter order. This implementation differs from HashSet in that it maintains a doubly-linked list running through all of its entries. This linked list defines the encounter order (iteration order), which is the order in which elements were inserted into the set (insertion-order).
 * EnumSet: A specialized Set implementation for use with enum types. All of the elements in an enum set must come from a single enum type that is specified, explicitly or implicitly, when the set is created. Enum sets are represented internally as bit vectors. This representation is extremely compact and efficient.
 * CopyOnWriteArraySet: A thread-safe variant of ArrayList in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying array.
 * TreeSet: A NavigableSet implementation based on a TreeMap. The elements are ordered using their natural ordering, or by a Comparator provided at set creation time, depending on which constructor is used.
 *      This implementation provides guaranteed log(n) time cost for the basic operations (add, remove and contains).
 * ConcurrentSkipListSet: A scalable concurrent NavigableSet implementation based on a ConcurrentSkipListMap. The elements of the set are kept sorted according to their natural ordering, or by a Comparator provided at set creation time, depending on which constructor is used.
 *      This implementation provides expected average log(n) time cost for the contains, add, and remove operations and their variants. Insertion, removal, and access operations safely execute concurrently by multiple threads
 * */

public class SetInfo {
    public static void main(String[] args) {
        Set<Anime> animes = new HashSet<>();

        animes.add(new Anime(101L, "Naruto", "Action"));
        animes.add(new Anime(177L, "Yu-Gi-Oh", "Action"));
        animes.add(new Anime(1L, "Cavaleiros do Zodíaco", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));
        animes.add(new Anime(2L, "Dragon Ball Z", "Action"));


        for (Anime anime : animes) {
            System.out.println(anime);
        }

    }
}
