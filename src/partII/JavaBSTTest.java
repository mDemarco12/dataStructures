package partII;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
public class JavaBSTTest {
    /*
    Java collections are either sets or lists
    Lists are either ArrayLists or LinkedLists
    Sets are either TreeSet (BST - Red/Black Tree) or HashSet (hash table)
    Differences between Lists and Sets:
    1. set doesn't allow duplicates
    2. set doesn't preserve the order of elements;

    map in programming is equvalent to functions in math.
    Java map has two Main implementations:

    TreeMap (BST - Red/Black Tree) and HashMap (hash table)

    HashMap in java is equivalent to dict in Python or Dictionary C#
     */
    public static void main(String[] args){
        Set<String> names = new TreeSet<>();
        for(String fruit: new String[]{"kiwi", "orange", "apple", "orange",
                "banana", "strawberry", "apple", "cherry", "orange"})
            names.add(fruit);//same as insert in BST
        System.out.println(names);
        names.remove("kiwi");
        System.out.println(names);
        System.out.println("result of searching blueberry in the set is " +
                names.contains("blueberry"));
        System.out.println("result of searching strawberry in the set is " +
                names.contains("strawberry"));

        Map<String, Integer> frequencyOfFruits = new TreeMap<>();
        for(String fruit: new String[]{"kiwi", "orange", "apple", "orange",
                "banana", "strawberry", "apple", "cherry", "orange"}) {
            if(!frequencyOfFruits.containsKey(fruit))
                frequencyOfFruits.put(fruit, 1);
            else{
                int oldFrequency = frequencyOfFruits.get(fruit);
                frequencyOfFruits.put(fruit, oldFrequency + 1);
            }
        }
        System.out.println(frequencyOfFruits);
        System.out.println(frequencyOfFruits.keySet());
    }
}
